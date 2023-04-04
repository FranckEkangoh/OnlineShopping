package exam.onlineshop.services.impl;

import exam.onlineshop.entities.Order;
import exam.onlineshop.entities.impl.DefaultOrder;
import exam.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService{
    private static final int DEFAULT_ORDER_CAPACITY = 10;
    private Order[] orders = new DefaultOrder[DEFAULT_ORDER_CAPACITY];
    private int nbOfOrders = 0;
    private static DefaultOrderManagementService instance;

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        orders[nbOfOrders++] = order;
    }


    @Override
    public Order[] getOrdersByUserId(int userId) {
        Order[] userOrders = new DefaultOrder[orders.length];
        int idx = 0;
        for (Order order:orders
             ) {
            if (order != null) {
                if (order.getCustomerId() == userId) {
                    userOrders[idx++] = order;
                }
            } else {
                break;
            }
        }
        return userOrders;
    }

    @Override
    public Order[] getOrders() {
        return this.orders;
    }

    void clearServiceState() {
        orders = new DefaultOrder[DEFAULT_ORDER_CAPACITY];
        nbOfOrders = 0;
        instance = null;
    }
}
