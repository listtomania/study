package org.example.Statement;

import org.example.ConnectionDatabase.ConnectionManager;
import org.example.Models.Model;
import org.example.Models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatementAction {
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    private boolean userExists(String login) {
        boolean a = false;
        String sql = "SELECT * FROM users WHERE login = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                a = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public User authorization(String login, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE login = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if (encoder.matches(password, rs.getString("password"))) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getInt("role"));
                user.setBlocked(rs.getBoolean("blocked"));
                System.out.println("Ваша почта: " + user.getEmail());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User registration(String login, String password, String email) {
        User user = new User();
        String sql = "INSERT INTO Users (login, password, email, role, blocked) VALUES (?, ?, ?, ?, ?)";
        int x = 0;
        boolean y = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            if(!userExists(login)) {
                System.out.println("Проверка3");
                pstmt.setString(1, login);
                pstmt.setString(2, password);
                pstmt.setString(3, email);
                pstmt.setInt(4, x);
                pstmt.setBoolean(5, y);
                pstmt.executeUpdate();
                System.out.println("Регистрация прошла успешно");

                return user;

                // здесь ты не работаешь с юзером, ты только
                //значения добавляешь в бд, в этом и проблема
            }else {
                System.out.println("Пользователь с таким логином уже существует");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

}
