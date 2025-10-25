package org.example.MainLogic.UserMain;

import org.example.MainLogic.AdminMain.CrudGames;
import org.example.Models.Cart;
import org.example.Models.Game;
import org.example.Statement.StatementAdmin;
import org.example.Statement.StatementUser;

import java.util.List;
import java.util.Scanner;

public class CrudCart {
    private final StatementUser statementUser = new StatementUser();
    private final Scanner scanner = new Scanner(System.in);
    private final CrudGames crudGames = new CrudGames();

    public void mainCart() {
        int a = -1;
        while (a != 0) {
            System.out.println("1. Посмотреть содержимое\n2. Добавить игру\n3. Удалить игру\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    myCartList();
                    break;
                }
                case 2: {
                    addGameToCart();
                    break;
                }
                case 3: {
                    deleteGameFromCart();
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


    public void myCartList() {
        List<Cart> myCart = statementUser.getMyCartList();
        if (!myCart.isEmpty()) {
            System.out.println("Моя корзина:");
            double total = 0;
            for (Cart cart : myCart) {
                total += cart.getPrice();
            }
            myCart.forEach(System.out::println);
            System.out.println("Общая сумма: " + total);
        } else {
            System.out.println("Ничего не найдено");
        }
    }

    public void addGameToCart() {
        myCartList();
        crudGames.getAllGames();
        System.out.println("Выберите id игры, которую хотите добавить в корзину");
        int gameId = scanner.nextInt();
        statementUser.addGameToCartById(gameId);

    }

    public void deleteGameFromCart() {
        myCartList();
        System.out.println("Выберите id игры, которую хотите удалить из корзины");
        int gameId = scanner.nextInt();
        statementUser.deleteGameFromCartById(gameId);
    }
}
