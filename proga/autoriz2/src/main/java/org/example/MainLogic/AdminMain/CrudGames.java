package org.example.MainLogic.AdminMain;

import org.example.Models.Game;
import org.example.Models.User;
import org.example.Statement.StatementAdmin;
import org.example.Statement.StatementUser;

import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CrudGames {
    private final StatementAdmin statementAdmin = new StatementAdmin();

    public void getAllGames() {
        List<Game> allGames = statementAdmin.getAllGames();
        if (!allGames.isEmpty()) {
            System.out.println("Все игрушки:");
            allGames.forEach(System.out::println);
        } else {
            System.out.println("Ничего не найдено");
        }

    }

    public void addNewGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название: ");
        String title = scanner.nextLine();
        System.out.println("Введите дату выхода (гггг-мм-дд): ");
        String date = scanner.next();
        java.sql.Date release_date = java.sql.Date.valueOf(date);
        System.out.println("Введите сложность (1-10): ");
        int hard = parseInt(scanner.nextLine());
        System.out.println("Введите время прохождения игры: ");
        int game_time = parseInt(scanner.nextLine());
        System.out.println("Введите цену: ");
        double price = parseDouble(scanner.nextLine());
        System.out.println("Введите возможность игры онлайн (true/false): ");
        boolean online = scanner.nextBoolean();

        Game game = statementAdmin.addGame(title, release_date, hard, game_time, price, online);
        if(game!=null){
            System.out.println("Игра " + game.getTitle() + " добавлена");
        }else {
            System.out.println("Ошибка добавления игры");
        }

    }

    public void deleteGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Удалим игру");
        List<Game> allGames = statementAdmin.getAllGames();

        if (!allGames.isEmpty()) {
            getAllGames();
            System.out.println("Выберите id игры, которую хотите удалить");
            int game = scanner.nextInt();
            statementAdmin.deleteGameById(game);

        } else {
            System.out.println("Пользователей не найдено");
        }
    }

    public void redactGame() {
        Scanner scanner = new Scanner(System.in);
        List<Game> allGames = statementAdmin.getAllGames();
        if (!allGames.isEmpty()) {
            getAllGames();
            System.out.println("Выберите id игры, которую хотите редактировать");
            int gameId = scanner.nextInt();
            boolean a = statementAdmin.gameExistsById(gameId);
            if(a){
                System.out.println("Введите название: ");
                String title = scanner.nextLine();
                System.out.println("Введите дату выхода (гггг-мм-дд): ");
                String date = scanner.next();
                java.sql.Date release_date = java.sql.Date.valueOf(date);
                System.out.println("Введите сложность (1-10): ");
                int hard = parseInt(scanner.nextLine());
                System.out.println("Введите время прохождения игры: ");
                int game_time = parseInt(scanner.nextLine());
                System.out.println("Введите цену: ");
                double price = parseDouble(scanner.nextLine());
                System.out.println("Введите возможность игры онлайн (true/false): ");
                boolean online = scanner.nextBoolean();
                statementAdmin.readactGameById(gameId, title, release_date, hard, game_time, price, online);

            }else {
                System.out.println("Игра с id " + gameId + " не найдена");
            }

        } else {
            System.out.println("Игр не найдено");
        }

    }
}
