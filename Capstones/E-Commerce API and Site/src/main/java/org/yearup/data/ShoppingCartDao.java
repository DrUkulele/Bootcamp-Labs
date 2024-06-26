package org.yearup.data;

import org.springframework.http.ResponseEntity;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    // add additional method signatures here

    ShoppingCart addProductToCart(int userId, int productId);

    void clearCart(int userId);

    ResponseEntity<ShoppingCart> updateProductQuantity(int userId, int productId, ShoppingCartItem shoppingCartItem);
}
