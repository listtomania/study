package org.example;

import org.example.AdminMain.AdminMenu;
import org.example.Models.Model;
import org.example.Models.User;
import org.example.Statement.StatementAction;
import org.example.UserMain.UserMenu;

public class Manager {

    StatementAction statement = new StatementAction();
    UserMenu userMenu = new UserMenu();
    AdminMenu adminMenu = new AdminMenu();

    public void checkDataAuth(String login, String password) {
        User user = statement.authorization(login, password);
        Model.getInstance().setCurrentUser(user);
        if(!user.isBlocked()) {
            if (user.getRole() == 0) {
                userMenu.userMenu();
            } else {
                adminMenu.adminMenu();
            }
        }else {
            System.out.println("Вы заблокированы, уважаемый " + Model.getInstance().getCurrentUser().getLogin());

        }
    }

    public void checkDataRegist(String login, String password, String email) {
        User user = statement.registration(login, password, email);
        Model.getInstance().setCurrentUser(user);
        if(Model.getInstance().getCurrentUser().getLogin()!=null){
            System.out.println("Проверка");

        }else{
            System.out.println("Проверка2");
            userMenu.userMenu();

        }

    }

}
