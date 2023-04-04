package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.entities.User;
import exam.onlineshop.menu.Menu;
import exam.onlineshop.services.UserManagementService;
import exam.onlineshop.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] customerList = userManagementService.getUsers();
        for (User user:customerList
             ) {
            System.out.println(user);
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** CUSTOMER LIST ********");
    }
}
