package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.Order;
import exam.onlineshop.entities.impl.DefaultOrder;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.OrderManagementService;
import exam.onlineshop.services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckOutMenu implements Menu {

    private static final ApplicationContext context;
    private static final OrderManagementService orderManagementService;

    static {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getSessionCart().isEmpty()) {
            System.out.println("Your cart is empty. Please, add product to cart first and then proceed with " +
                    "checkout");
            new ProductCatalogMenu().start();
        } else {
            processPurchase();
        }
    }

    private static void processPurchase() {
        if (context.getLoggedInUser() == null) {
            System.out.println("You are not logged in. Please, sign in or create new account");
            context.getMainMenu().start();
        } else {
            System.out.println("Enter your credit card number without spaces and press enter if you confirm " +
                    "purchase");
            Order order = new DefaultOrder();
            String creditCard;
            do {
                Scanner sc = new Scanner(System.in);
                creditCard = sc.nextLine();
                order.setCreditCardNumber(creditCard);
                if (!order.isCreditCardNumberValid()) {
                    System.out.println("You entered invalid credit card number. Valid credit card should " +
                            "contain 16 digits. Please, try one more time");
                }
            } while (!order.isCreditCardNumberValid());
            order.setProducts(context.getSessionCart().getProducts());
            order.setCustomerId(context.getLoggedInUser().getId());
            orderManagementService.addOrder(order);
            System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your " +
                    "email.");
            context.getMainMenu().start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** CHECKOUT ********");
    }
}
