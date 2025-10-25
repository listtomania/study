package org.example.Statement;

import org.example.ConnectionDatabase.ConnectionManager;
import org.example.MainLogic.AdminMain.CrudGames;
import org.example.Models.Cart;
import org.example.Models.Game;
import org.example.Models.Model;
import org.example.Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementUser {
    private final StatementAdmin statementAdmin = new StatementAdmin();

    public List<Cart> getMyCartList() {

        List<Cart> myCart = new ArrayList<>();
        String sql = "SELECT c.id, c.user_id, c.game_id, g.title, g.price " +
                "FROM cart c, games g WHERE c.game_id = g.id AND c.user_id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Model.getInstance().getCurrentUser().getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setUser_id(rs.getInt("user_id"));
                cart.setGame_id(rs.getInt("game_id"));
                cart.setTitle(rs.getString("title"));
                cart.setPrice(rs.getDouble("price"));
                myCart.add(cart);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myCart;
    }

    public void addGameToCartById(int game_id) {
        boolean x = statementAdmin.gameExistsById(game_id);
        if (x) {
            boolean a = gameExistsCart(game_id);
            if (!a) {
                String sql = "INSERT INTO cart (game_id, user_id) VALUES (?, ?)";
                try (Connection connection = ConnectionManager.getConnection();
                     PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, game_id);
                    pstmt.setInt(2, Model.getInstance().getCurrentUser().getId());
                    pstmt.executeUpdate();
                    System.out.println("Игра добавлена в корзину");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Такая игра уже добавлена");
            }
        } else {
            System.out.println("Игры с таким id не существует");
        }
    }

    public void deleteGameFromCartById(int gameId) {
        boolean x = statementAdmin.gameExistsById(gameId);
        if (x) {
            boolean a = gameExistsCart(gameId);
            if (a) {
                Game game = statementAdmin.getGameById(gameId);
                String sql = "DELETE FROM cart WHERE game_id = ?";
                try (Connection connection = ConnectionManager.getConnection();
                     PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, gameId);
                    int rs = pstmt.executeUpdate();
                    if (rs != 0) {
                        System.out.println("Игра " + game.getTitle() + " удалена из корзины");

                    } else {
                        System.out.println("Игра c id " + gameId + " не найдена");

                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Такой игры нет в корзине");
            }
        } else {
            System.out.println("Игры с таким id не существует");
        }

    }

    public boolean gameExistsCart(int game_id) {
        boolean a = false;
        String sql = "SELECT * FROM cart WHERE game_id = ? AND user_id = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, game_id);
            pstmt.setInt(2, Model.getInstance().getCurrentUser().getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                a = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;

    }
}
