package org.example.AdminMain;

import org.example.Statement.StatementAdmin;

import java.util.Scanner;

public class DeleteUser {
    public static void deleteUser(){
        StatementAdmin statementAdmin = new StatementAdmin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь удалим)");
        statementAdmin.getAllUsers();
        ListUsers.listOfUsers();
        System.out.println("Выберите логин жертвы");
        String victim = scanner.nextLine();
        statementAdmin.deleteVictim(victim);
    }
}
