package org.example.MainLogic.AdminMain;

import org.example.Models.Model;

import java.sql.Date;
import java.util.Scanner;

public class AdminMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final CrudUsers crudUsers = new CrudUsers();
    private final CrudGames crudGames = new CrudGames();
    private final CrudOrders crudOrders = new CrudOrders();
    private final CrudStatistic crudStatistic = new CrudStatistic();

    public void adminMenu() {
        System.out.println("Здравствуйте, " + Model.getInstance().getCurrentUser().getLogin());
        System.out.println("Меню админа:");
        int a = -1;
        while (a != 0) {
            System.out.println("1. Работа с пользователями\n2. Работа с играми\n" +
                    "3. Работа с заказами\n4. Статистика\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    crudUsers();
                    break;
                }
                case 2: {
                    crudGames();
                    break;
                }
                case 3: {
                    crudOrders();
                    break;
                }
                case 4: {
                    crudStatistic();
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

    public void crudUsers() {
        int a = -1;
        while (a != 0) {
            System.out.println("1. Список пользователей\n2. Удаление пользователя\n" +
                    "3. Заблокировать пользователя\n4. Сделать пользователя админом\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();
            switch (a) {
                case 1: {
                    crudUsers.listOfUsers();
                    break;
                }
                case 2: {
                    crudUsers.deleteUser();
                    break;
                }
                case 3: {
                    crudUsers.blockUser();
                    break;
                }
                case 4: {
                    crudUsers.makeAdmin();
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

    public void crudGames() {
        int a = -1;
        while (a != 0) {
            System.out.println("1. Список всех игр\n2. Добавить игру\n3. Удалить игру\n" +
                    "4. Редактировать игру\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();
            switch (a) {
                case 1: {
                    crudGames.getAllGames();
                    break;
                }
                case 2: {
                    crudGames.addNewGame();
                    break;
                }
                case 3: {
                    crudGames.deleteGame();
                    break;
                }
                case 4: {
                    crudGames.redactGame();
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

    public void crudOrders() {
        int a = -1;
        while (a != 0) {
            System.out.println("1. Список всех заказов\n2. \n3. \n" +
                    "4. \n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();
            switch (a) {
                case 1: {
                    crudOrders.allOrders();
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

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

    public void crudStatistic() {
        int a = -1;
        while (a != 0) {
            System.out.println("1. \n2. \n3. \n" +
                    "4. \n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();
            switch (a) {
                case 1: {

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

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
