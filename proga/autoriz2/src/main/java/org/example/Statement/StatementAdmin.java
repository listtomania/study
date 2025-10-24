package org.example.Statement;

import org.example.ConnectionDatabase.ConnectionManager;
import org.example.Models.Game;
import org.example.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementAdmin {

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    public void deleteVictim(String victim) {
        String sql = "DELETE FROM users WHERE login = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, victim);
            int rs = pstmt.executeUpdate();
            if (rs != 0) {
                System.out.println("Пользователь " + victim + " удален");

            } else {
                System.out.println("Пользователь " + victim + " не найден");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void blockVictim(String victim) {
        String sql = "UPDATE users SET blocked = true WHERE login = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, victim);
            int rs = pstmt.executeUpdate();
            if (rs != 0) {
                System.out.println("Пользователь " + victim + " заблокирован");

            } else {
                System.out.println("Пользователь " + victim + " не найден");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeNewAdmin(String futureAdmin) {
        String sql = "UPDATE users SET role = 1 WHERE login = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, futureAdmin);
            int rs = pstmt.executeUpdate();
            if (rs != 0) {
                System.out.println("Пользователь " + futureAdmin + " стал админом");
            } else {
                System.out.println("Пользователь " + futureAdmin + " не найден");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //crudGames

    public List<Game> getAllGames() {
        List<Game> allGames = new ArrayList<>();
        String sql = "SELECT * FROM games";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setHard(rs.getInt("hard"));
                game.setGame_time(rs.getInt("game_time"));
                game.setTitle(rs.getString("title"));
                game.setOnline(rs.getBoolean("online"));
                game.setPrice(rs.getFloat("price"));
                game.setRelease_date(rs.getDate("release_date"));
                allGames.add(game);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allGames;
    }


    public Game getGameById(int id) {
        Game game = new Game();
        String sql = "SELECT * FROM games WHERE id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                game.setId(rs.getInt("id"));
                game.setHard(rs.getInt("hard"));
                game.setGame_time(rs.getInt("game_time"));
                game.setTitle(rs.getString("title"));
                game.setOnline(rs.getBoolean("online"));
                game.setPrice(rs.getFloat("price"));
                game.setRelease_date(rs.getDate("release_date"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return game;
    }

    private boolean gameExists(String title) {
        boolean a = false;
        String sql = "SELECT * FROM games WHERE title = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                a = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    public boolean gameExistsById(int id) {
        boolean a = false;
        String sql = "SELECT * FROM games WHERE id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                a = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }


    public void deleteGameById(int gameId) {
        Game game = getGameById(gameId);
        String sql = "DELETE FROM games WHERE id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, gameId);
            int rs = pstmt.executeUpdate();
            if (rs != 0) {
                System.out.println("Игра " + game.getTitle() + " удалена");

            } else {
                System.out.println("Игра c id " + gameId + " не найдена");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Game addGame(String title, java.sql.Date release_date, int hard, int game_time, double price, boolean online){
        Game game = null;
        String sql = "INSERT INTO games (title, release_date, hard, game_time, price, online) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            if(!gameExists(title)) {
                game = new Game();
                pstmt.setString(1, title);
                pstmt.setDate(2, release_date);
                pstmt.setInt(3, hard);
                pstmt.setInt(4, game_time);
                pstmt.setDouble(5, price);
                pstmt.setBoolean(6, online);
                pstmt.executeUpdate();
                System.out.println("Игра" + game.getTitle() +"добавлена ");

                return game;

            }else {
                System.out.println("Игра с таким названием уже существует");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return game;
    }

    public Game readactGameById(int id, String title, java.sql.Date release_date, int hard, int game_time, double price, boolean online){
        Game game = null;
        String sql = "UPDATE games SET title = ?, release_date = ?, hard = ?, game_time = ?, price = ?, online = ? WHERE id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            if(!gameExists(title)) {
                game = new Game();
                pstmt.setString(1, title);
                pstmt.setDate(2, release_date);
                pstmt.setInt(3, hard);
                pstmt.setInt(4, game_time);
                pstmt.setDouble(5, price);
                pstmt.setBoolean(6, online);
                pstmt.setInt(7, id);
                pstmt.executeUpdate();
                System.out.println("Игра " + game.getTitle() +" обновлена");

                return game;

            }else {
                System.out.println("Игра с таким названием уже существует");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return game;
    }


}
