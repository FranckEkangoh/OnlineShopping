package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.Product;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.ProductManagementService;
import exam.onlineshop.services.impl.DefaultProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private static final String CHECKOUT_COMMAND = "checkout";
    private final Scanner sc = new Scanner(System.in);
    private final ApplicationContext context;
    private final ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        printProduct();
        String command = sc.nextLine();
        if (command.equalsIgnoreCase(CHECKOUT_COMMAND)) {
            checkOut();
        }
        else if (command.equalsIgnoreCase("menu")) {
            context.getMainMenu().start();
        } else if (isIntValue(command)){
            Product product = productManagementService.getProductById(Integer.parseInt(command));
            if (product == null) {
                System.out.println("Please, enter product ID if you want to add product to cart. " +
                        "Or enter \"checkout\" if you want to proceed with checkout. \n" +
                        "Or enter \"menu\" if you want to navigate back to the main menu.");
                start();
            } else {
                context.getSessionCart().addProduct(product);
                System.out.println("Product " + product.getProductName() + "  has been added to your cart. " +
                        "If you want to add a new product - enter the product id. \n" +
                        "If you want to proceed with checkout - enter word \"checkout\" to console");
                start();
            }
        } else {
            System.out.println("Please, enter product ID if you want to add product to cart. " +
                    "Or enter \"checkout\" if you want to proceed with checkout. \n" +
                    "Or enter \"menu\" if you want to navigate back to the main menu.");
            start();
        }
    }

    private void printProduct() {
        Product[] products = productManagementService.getProducts();
        for (Product product:products
             ) {
            System.out.println(product);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** PRODUCT CATALOG *******");
    }

    private void checkOut() {
        if (context.getSessionCart().isEmpty() || context.getSessionCart() == null) {
            System.out.println("Your cart is empty. Please, add product to cart first and then proceed with " +
                    "checkout");
            new ProductCatalogMenu().start();
        } else {
            new CheckOutMenu().start();
        }
    }
    private boolean isIntValue(String s) {
        if (s == null) {
            return false;
        } else {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return false;
            }
            return true;
        }
    }

}
