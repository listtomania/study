package org.example.MainLogic.UserMain;

import org.example.Models.Model;
import org.example.Models.User;

import java.util.Scanner;


public class UserMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final CrudMyOrders crudMyOrders = new CrudMyOrders();

    public void userMenu() {
        System.out.println("Здравствуйте, " + Model.getInstance().getCurrentUser().getLogin());
        System.out.println("Меню пользователя:");
        int a = -1;
        while (a != 0) {
            System.out.println("1. Оформить заказ\n2. Перейти в корзину\n3. История заказов" +
                    "\n4. Мои данные\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    crudMyOrders.makeOrderUser();
                    break;
                }
                case 2: {
                    crudMyOrders.historyOrdersUser();
                    break;
                }
                case 3: {
                    crudMyOrders.myInfoUser();
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Неверный выбор");
                    break;
                }
            }
        }


    }



}
