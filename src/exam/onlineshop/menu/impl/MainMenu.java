package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.menu.Menu;

import java.util.Locale;
import java.util.Scanner;

public class MainMenu implements Menu {
    public static final String MENU_COMMAND = "menu";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";;

    private static final String ERROR_MESSAGE = "Only 1, 2, 3, 4, 5 is allowed. Try one more time.";
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        context.setMainMenu(this);
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input) {
            case "1" -> new SignUpMenu().start();
            case "2" -> {
                if (context.getLoggedInUser() == null) {
                    new SignInMenu().start();
                } else {
                    new SignOutMenu().start();
                }
            }
            case "3" -> new ProductCatalogMenu().start();
            case "4" -> new MyOdersMenu().start();
            case "5" -> new SettingsMenu().start();
            case "6" -> new CustomerListMenu().start();
            case "exit", "EXIT" -> System.exit(0);
            default -> {
                System.out.println(ERROR_MESSAGE);
                context.getMainMenu().start();
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** MENU NAVIGATION ********");
        if (context.getLoggedInUser() == null) {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);;
        }
        System.out.println("Enter your input: ");
    }

}
