package org.example;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Добро пожаловать!");

        int a = -1;
        while (a != 0) {
            System.out.println("Главное меню\n1. Вход\n2. Регистрация\n0. Выход");
            //
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите число!");
                scanner.next();
                continue;
            }
            //
            a = scanner.nextInt();
            scanner.nextLine();

            switch (a) {
                case 1: {

                    System.out.println("Введите логин: ");
                    String login = scanner.nextLine();
                    System.out.println("Введите пароль: ");
                    String password = scanner.nextLine();
                    manager.checkDataAuth(login, password);
                    break;
                }
                case 2: {
                    System.out.println("Введите логин: ");
                    String login = scanner.nextLine();

                    System.out.println("Введите пароль: ");
                    String password = scanner.nextLine();
                    String hashPassword = encoder.encode(password);
                    String email;
                    while (true) {
                        System.out.println("Введите почту: ");
                        email = scanner.nextLine();
                        if (!email.contains("@")) {
                            System.out.println("Почта должна содержать '@'");

                        } else {
                            break;
                        }
                    }


                    //хуй
                    manager.checkDataRegist(login, hashPassword, email, password);
                    break;

                }
                case 0: {
                    exit(1);
                }
                default: {
                    System.out.println("Неверный выбор");
                }
            }
        }
        scanner.close();

    }
}