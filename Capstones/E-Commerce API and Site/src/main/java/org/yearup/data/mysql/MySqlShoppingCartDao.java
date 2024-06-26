package org.yearup.data.mysql;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        String query = "{CALL getShoppingCartByUserId(?)}";

        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, userId);

            try (ResultSet rs = cs.executeQuery()) {
                ShoppingCart shoppingCart = new ShoppingCart();

                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    String productName = rs.getString("name");
                    BigDecimal productPrice = rs.getBigDecimal("price");
                    int productCategoryId = rs.getInt("category_id");
                    String productDescription = rs.getString("description");
                    String productColor = rs.getString("color");
                    int productStock = rs.getInt("stock");
                    boolean productIsFeatured = rs.getInt("featured") == 1; // 1 represents true, 0 represents false
                    String productImageUrl = rs.getString("image_url");
                    int quantity = rs.getInt("quantity");

                    Product product = new Product(productId, productName, productPrice, productCategoryId,
                            productDescription, productColor, productStock,
                            productIsFeatured, productImageUrl);


                    ShoppingCartItem item = new ShoppingCartItem();
                    item.setProduct(product);
                    item.setQuantity(quantity);


                    shoppingCart.add(item);
                }

                return shoppingCart;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching shopping cart for user ID: " + userId, e);
        }
    }

    @Override
    public ShoppingCart addProductToCart(int userId, int productId) {
        try (Connection conn = getConnection()) {
            ShoppingCart shoppingCart = getByUserId(userId);

            if (shoppingCart.contains(productId)) {
                String query = "{Call updateItemQuantityInCart(?,?)}";
                try (CallableStatement cs = conn.prepareCall(query)) {
                    cs.setInt(1, userId);
                    cs.setInt(2, productId);

                    cs.executeUpdate();

                    return getByUserId(userId);
                }
            } else {
                String query = "{CALL addProductToCart(?, ?)}";
                try (CallableStatement cs = conn.prepareCall(query)) {
                    cs.setInt(1, userId);
                    cs.setInt(2, productId);

                    cs.executeUpdate();


                    return getByUserId(userId);
                } catch (SQLException e) {
                    throw new RuntimeException("Error adding product to cart for user ID: " + userId, e);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clearCart(int userId) {
        String query = "{Call clearShoppingCart(?)}";
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, userId);

            cs.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResponseEntity<ShoppingCart> updateProductQuantity(int userId, int productId, ShoppingCartItem shoppingCartItem) {
        try (Connection conn = getConnection()) {
            ShoppingCart shoppingCart = getByUserId(userId);

            if (shoppingCart.contains(productId)) {
                String query = "{changeQuantityInCart(?,?,?)}";
                try (CallableStatement cs = conn.prepareCall(query)) {
                    cs.setInt(1, userId);
                    cs.setInt(2, productId);
                    cs.setInt(3, shoppingCartItem.getQuantity());

                    cs.executeUpdate();

                    return new ResponseEntity<>(getByUserId(userId), HttpStatus.OK);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
