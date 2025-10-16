package org.example.UserMain;

import org.example.Models.Model;
import org.example.Models.User;

import java.util.Scanner;


public class UserMenu {
    private Scanner scanner = new Scanner(System.in);

    public void userMenu() {
        System.out.println("Здравствуйте, " + Model.getInstance().getCurrentUser().getLogin());
        System.out.println("Меню пользователя:");
        int a = -1;
        while (a != 0) {
            System.out.println("1. Сделать заказ\n2. История заказов\n3. Мои данные\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    MakeOrder.makeOrderUser();
                    break;
                }
                case 2: {
                    HistoryOrders.historyOrdersUser();
                    break;
                }
                case 3: {
                    MyInfo.myInfoUser();
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
