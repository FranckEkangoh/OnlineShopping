package exam.onlineshop;

import exam.onlineshop.menu.Menu;
import exam.onlineshop.menu.impl.MainMenu;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}
