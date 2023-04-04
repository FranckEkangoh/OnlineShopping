package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.User;
import exam.onlineshop.entities.impl.DefaultUser;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.UserManagementService;
import exam.onlineshop.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {

    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        User user = new DefaultUser(firstName, lastName, email, password);
        String processCode =
                userManagementService.registerUser(user);
        if (!processCode.equals("")) {
            if (email.isBlank()) {
                System.out.println("You have to input email to register. Please, try one more time");
            } else {
                System.out.println("This email is already used by another user. Please, use another email");
            }
            context.getMainMenu().start();
        } else {
            System.out.println("New user is created");
            context.getMainMenu().start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** SIGN UP ********");

    }
}
