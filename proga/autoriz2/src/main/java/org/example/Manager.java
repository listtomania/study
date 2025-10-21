package org.example;

import org.example.MainLogic.AdminMain.AdminMenu;
import org.example.Models.Model;
import org.example.Models.User;
import org.example.Statement.StatementAction;
import org.example.MainLogic.UserMain.UserMenu;

public class Manager {

    StatementAction statement = new StatementAction();
    UserMenu userMenu = new UserMenu();
    AdminMenu adminMenu = new AdminMenu();

    public void checkDataAuth(String login, String password) {
        User user = statement.authorization(login, password);
        if (user != null) {
            Model.getInstance().setCurrentUser(user);
            if (!user.isBlocked()) {
                if (user.getRole() == 0) {
                    userMenu.userMenu();
                } else {
                    adminMenu.adminMenu();
                }
            } else {
                System.out.println("Вы заблокированы, уважаемый " + Model.getInstance().getCurrentUser().getLogin());

            }
        }else{
            System.out.println("Такого пользователя не существует");
        }
    }

    public void checkDataRegist(String login, String password, String email, String psw) {
        User user = statement.registration(login, password, email, psw);
        if (user!=null){
            Model.getInstance().setCurrentUser(user);
            userMenu.userMenu();
        }


    }

}
