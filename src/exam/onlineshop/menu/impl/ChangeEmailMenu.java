package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.menu.Menu;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String newEmail = sc.next();
        context.getLoggedInUser().setEmail(newEmail);
        System.out.println("Your email has been successfully changed, thank you.");
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** CHANGE EMAIL ********");
        System.out.println("Enter new email: ");
    }
}
