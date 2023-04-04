package exam.onlineshop.menu.impl;

import exam.onlineshop.configs.ApplicationContext;
import exam.onlineshop.menu.Menu;

public class SignOutMenu implements Menu {
    private final ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** SIGN OUT ********");
        System.out.println("Have a nice day! Look forward to welcoming back!");
    }
}
