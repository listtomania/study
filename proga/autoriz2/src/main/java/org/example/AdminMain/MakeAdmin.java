package org.example.AdminMain;

import org.example.Statement.StatementAdmin;

import java.util.Scanner;

public class MakeAdmin {
    public static void makeAdmin(){
        StatementAdmin statementAdmin = new StatementAdmin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавим нового админа");
        statementAdmin.getAllUsers();
        ListUsers.listOfUsers();
        System.out.println("Выберите логин");
        String futureAdmin = scanner.nextLine();
        statementAdmin.makeNewAdmin(futureAdmin);
    }
}
