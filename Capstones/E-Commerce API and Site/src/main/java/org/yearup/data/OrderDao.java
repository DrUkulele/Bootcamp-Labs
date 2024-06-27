package org.yearup.data;

import org.yearup.models.Order;
import org.yearup.models.OrderLineItem;

import java.util.List;

public interface OrderDao {
    List<OrderLineItem> createOrder(int userId);

}
