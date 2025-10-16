package org.example.AdminMain;

import org.example.Models.User;
import org.example.Statement.StatementAdmin;

import java.util.List;

public class ListUsers {
    private final static StatementAdmin statementAdmin = new StatementAdmin();
    public static void listOfUsers(){
        List<User> allUsers= statementAdmin.getAllUsers();
        System.out.println("Список всех пользователей:");
        allUsers.forEach(System.out::println);
    }
}
