package org.example.MainLogic.AdminMain;

import org.example.Models.Game;
import org.example.Statement.StatementAdmin;
import org.example.Statement.StatementUser;

import java.util.List;

public class CrudGames {
    private final StatementAdmin statementAdmin = new StatementAdmin();
    public void allGames(){
        List<Game> allGames = statementAdmin.getAllGames();
        if (!allGames.isEmpty()){
            System.out.println("Все игрушки:");
            allGames.forEach(System.out::println);
        }else {
            System.out.println("Ничего не найдено");
        }

    }
    public void addGame(){
        System.out.println("Добавить игру");
    }
    public void deleteGame(){
        System.out.println("удалить игру");
    }
    public void redactGame(){
        System.out.println("Редактировать игру");
    }
}
