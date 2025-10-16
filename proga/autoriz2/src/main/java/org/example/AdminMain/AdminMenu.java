package org.example.AdminMain;

import org.example.Models.Model;
import org.example.Models.User;
import org.example.UserMain.HistoryOrders;
import org.example.UserMain.MakeOrder;
import org.example.UserMain.MyInfo;

import java.util.Scanner;

public class AdminMenu {
    private Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        System.out.println("Здравствуйте, " + Model.getInstance().getCurrentUser().getLogin());
        System.out.println("Меню админа:");

        int a = -1;
        while (a != 0) {
            System.out.println("1. Список пользователей\n2. Удаление пользователя\n" +
                    "3. Заблокировать пользователя\n4. Сделать пользователя админом\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    ListUsers.listOfUsers();
                    break;
                }
                case 2: {
                    DeleteUser.deleteUser();
                    break;
                }
                case 3: {
                    BlockUser.blockUser();
                    break;
                }
                case 4:{
                    MakeAdmin.makeAdmin();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Неверный выбор");
                    break;
                }
            }
        }
        scanner.close();


    }
}
