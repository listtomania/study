package org.example.MainLogic.AdminMain;

import org.example.Models.User;
import org.example.Statement.StatementAdmin;

import java.util.List;
import java.util.Scanner;

public class CrudUsers {
    private final StatementAdmin statementAdmin = new StatementAdmin();
    public void listOfUsers(){
        List<User> allUsers= statementAdmin.getAllUsers();
        System.out.println("Список всех пользователей:");
        allUsers.forEach(System.out::println);
    }
    public void blockUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь заблокируем)");
        statementAdmin.getAllUsers();
        listOfUsers();
        System.out.println("Выберите логин жертвы");
        String victim = scanner.nextLine();
        statementAdmin.blockVictim(victim);

    }
    public void deleteUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь удалим)");
        statementAdmin.getAllUsers();
        listOfUsers();
        System.out.println("Выберите логин жертвы");
        String victim = scanner.nextLine();
        statementAdmin.deleteVictim(victim);
    }
    public void makeAdmin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавим нового админа");
        statementAdmin.getAllUsers();
        listOfUsers();
        System.out.println("Выберите логин");
        String futureAdmin = scanner.nextLine();
        statementAdmin.makeNewAdmin(futureAdmin);
    }
}
