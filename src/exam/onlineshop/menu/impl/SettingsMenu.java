package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.menu.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {
    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private final ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println("Please, log in or create new account to change your account settings");
            context.getMainMenu().start();
        } else {
            Scanner sc = new Scanner(System.in);
            String entry = sc.nextLine();
            switch (entry) {
                case "1" -> {
                    changePassword(sc);
                    context.getMainMenu().start();
                }
                case "2" -> new ChangeEmailMenu().start();
                case "menu" -> context.getMainMenu().start();
                default -> System.out.println("Only 1, 2 is allowed. Try one more time");
            }
        }

    }

    private void changePassword(Scanner sc) {
        System.out.println("Enter new password");
        String password = sc.nextLine();
        context.getLoggedInUser().setPassword(password);
        System.out.println("Your password has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** SETTINGS ********");
        System.out.println(SETTINGS);
    }
}
