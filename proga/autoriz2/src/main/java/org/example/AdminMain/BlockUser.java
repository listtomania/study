package org.example.AdminMain;

import org.example.Statement.StatementAction;
import org.example.Statement.StatementAdmin;
import org.example.Statement.StatementUser;

import java.util.Scanner;

public class BlockUser {
    public static void blockUser() {
        StatementAdmin statementAdmin = new StatementAdmin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Давайте кого нибудь заблокируем)");
        statementAdmin.getAllUsers();
        ListUsers.listOfUsers();
        System.out.println("Выберите логин жертвы");
        String victim = scanner.nextLine();
        statementAdmin.blockVictim(victim);

    }
}
