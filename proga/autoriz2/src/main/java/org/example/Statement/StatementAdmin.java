package org.example.Statement;

import org.example.ConnectionDatabase.ConnectionManager;
import org.example.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementAdmin {

    public List<User> getAllUsers(){
        List<User> allUsers= new ArrayList<>();
        String sql = "SELECT * FROM users";
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getInt("role"));
                    user.setBlocked(rs.getBoolean("blocked"));
                    allUsers.add(user);
                }
            }else{
                System.out.println("Пользователей не найдено");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    public void deleteVictim(String victim){
        String sql = "DELETE FROM users WHERE login = ?";
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, victim);
            int rs = pstmt.executeUpdate();
            if(rs!=0){
                System.out.println("Пользователь " + victim + " удален");

            }else {
                System.out.println("Пользователь " + victim + " не найден");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void blockVictim(String victim){
        String sql = "UPDATE users SET blocked = true WHERE login = ?";
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, victim);
            int rs = pstmt.executeUpdate();
            if(rs!=0){
                System.out.println("Пользователь " + victim + " заблокирован");

            }else {
                System.out.println("Пользователь " + victim + " не найден");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeNewAdmin(String futureAdmin){
        String sql = "UPDATE users SET role = 1 WHERE login = ?";
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, futureAdmin);
            int rs = pstmt.executeUpdate();
            if(rs!=0) {
                System.out.println("Пользователь " + futureAdmin + " стал админом");
            }else{
                System.out.println("Пользователь " + futureAdmin + " не найден");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
