package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.User;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.UserManagementService;
import exam.onlineshop.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private final ApplicationContext context;
    private final UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        User user = userManagementService.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
            context.setLoggedInUser(user);
            context.getMainMenu().start();
        } else {
            System.out.println("Unfortunately, such login and password does’nt exist’");
            context.getMainMenu().start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** SIGN IN ********");
    }
}
