package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.Order;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.OrderManagementService;
import exam.onlineshop.services.impl.DefaultOrderManagementService;

public class MyOdersMenu implements Menu {
    private final ApplicationContext context;
    private final OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println("Please, log in or create new account to see list of your orders");
        } else if (orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId()).length == 0) {
            System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to " +
                    "place a new order");
        } else {
            printUserOders();
        }
        context.getMainMenu().start();
    }

    private void printUserOders() {
        Order[] myOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
        for (Order order:myOrders
             ) {
            if (order != null) {
                System.out.println(order);
            } else {
                break;
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** MY ORDERS ********");

    }
}
