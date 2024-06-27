package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.stereotype.Component;
import org.yearup.data.OrderDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.*;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlOrderDao extends MySqlDaoBase implements OrderDao {

    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private ShoppingCart shoppingCart;
    private MySqlShoppingCartDao mySqlShoppingCartDao;


    public MySqlOrderDao(DataSource dataSource) {
        super(dataSource);
    }

    @Autowired
    public MySqlOrderDao(DataSource dataSource, MySqlShoppingCartDao mySqlShoppingCartDao) {
        super(dataSource);
        this.mySqlShoppingCartDao = mySqlShoppingCartDao;
    }





    @Override
    public List<OrderLineItem> createOrder(int userId) {
        shoppingCart = mySqlShoppingCartDao.getByUserId(userId);

            Order order = new Order();
            String query = "{Call addOrder(?,?,?)}";
            try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
                cs.setInt(1, userId);
                cs.setString(2, date.format(fmt));
                cs.setBigDecimal(3, BigDecimal.ZERO);


                try (ResultSet rs = cs.executeQuery()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt("generated_id");
                        order.setOrderId(generatedId); // Set the generated ID to the Category object
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            catch (Exception ex){
                ex.printStackTrace();
        }
        List<OrderLineItem> orderLineItems = addOrderLineItem(userId, order);
            mySqlShoppingCartDao.clearCart(userId);

            return orderLineItems;
        }

        public List<OrderLineItem> addOrderLineItem(int userId, Order order){
            List<OrderLineItem> orderLineItems = new ArrayList<>();
            String query = "{Call addOrderLineItem(?, ?, ?)}";
            try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
                cs.setInt(1, userId);
                cs.setInt(2, order.getOrderId());
                cs.setBigDecimal(3, BigDecimal.ZERO);


                try (ResultSet rs = cs.executeQuery()) {
                    while (rs.next()) {
                        // Assuming order_line_items table structure, adjust as per your actual schema
                        int orderLineItemId = rs.getInt("order_line_item_id");
                        int orderId = rs.getInt("order_id");
                        int productId = rs.getInt("product_id");
                        BigDecimal salesPrice = rs.getBigDecimal("sales_price");
                        int quantity = rs.getInt("quantity");
                        BigDecimal discount = rs.getBigDecimal("discount");

                        // Create OrderLineItem objects and add them to the list
                        OrderLineItem orderLineItem = new OrderLineItem(orderLineItemId, order.getOrderId(), productId, salesPrice, quantity, discount);
                        orderLineItems.add(orderLineItem);
                    }
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            return orderLineItems;
        }

    }
