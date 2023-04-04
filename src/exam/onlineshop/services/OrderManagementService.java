package exam.onlineshop.services;

import exam.onlineshop.entities.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();

}
