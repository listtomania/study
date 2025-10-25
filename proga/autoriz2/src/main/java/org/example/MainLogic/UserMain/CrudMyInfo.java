package org.example.MainLogic.UserMain;

import org.example.Models.Model;
import org.example.Models.User;

import java.util.Scanner;

public class CrudMyInfo {
    private final Scanner scanner = new Scanner(System.in);

    public void mainMyInfo(){
        int a = -1;
        while (a != 0) {
            System.out.println("1. Мои данные\n2. Изменить данные\n3. Удалить аккаунт\n0. Выход");
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {
                    printMyInfo();
                    break;
                }
                case 2: {
                    changeInfo();
                    break;
                }
                case 3: {
                    deleteAccount();
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

    public void printMyInfo(){
        User user = Model.getInstance().getCurrentUser();
        System.out.println("Логин: " + Model.getInstance().getCurrentUser().getLogin());
        System.out.println("Почта: " + Model.getInstance().getCurrentUser().getEmail());
    }

    public void changeInfo(){

    }
    public void deleteAccount(){

    }
}
