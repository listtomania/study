package org.example.MainLogic.AdminMain;

import org.example.Models.User;
import org.example.Statement.StatementAdmin;

import java.util.List;
import java.util.Scanner;

public class CrudUsers {
    private final StatementAdmin statementAdmin = new StatementAdmin();

    public void listOfUsers() {
        List<User> allUsers = statementAdmin.getAllUsers();
        if (!allUsers.isEmpty()) {
            System.out.println("Список всех пользователей:");
            allUsers.forEach(System.out::println);
        } else {
            System.out.println("Пользователей не найдено");
        }
    }

    public void blockUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь заблокируем)");
        List<User> allUsers = statementAdmin.getAllUsers();
        if (!allUsers.isEmpty()) {
            listOfUsers();
            System.out.println("Выберите логин жертвы");
            String victim = scanner.nextLine();
            if (!victim.isEmpty()) {
                statementAdmin.blockVictim(victim);
            }
        } else {
            System.out.println("Пользователей не найдено");
        }


    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь удалим)");
        List<User> allUsers = statementAdmin.getAllUsers();
        if (!allUsers.isEmpty()) {
            listOfUsers();
            System.out.println("Выберите логин жертвы");
            String victim = scanner.nextLine();
            if (!victim.isEmpty()) {
                statementAdmin.deleteVictim(victim);
            }
        } else {
            System.out.println("Пользователей не найдено");
        }
    }

    public void makeAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавим нового админа");
        List<User> allUsers = statementAdmin.getAllUsers();
        if (!allUsers.isEmpty()) {
            listOfUsers();
            System.out.println("Выберите логин");
            String futureAdmin = scanner.nextLine();
            if (!futureAdmin.isEmpty()) {
                statementAdmin.makeNewAdmin(futureAdmin);
            }
        } else {
            System.out.println("Пользователей не найдено");
        }
    }
}
