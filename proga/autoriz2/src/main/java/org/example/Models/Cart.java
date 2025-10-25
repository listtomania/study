package org.example.Models;


public class Cart {
    private int id;
    private int user_id;
    private int game_id;
    private String title;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private double price;

    public Cart() {
    }

    public Cart(int id, int user_id, int game_id, String title, double price) {
        this.id = id;
        this.user_id = user_id;
        this.game_id = game_id;
        this.title = title;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "id игры: " + game_id + "Название игры: " + title + " | Цена: " + price;
    }

    public String toStringWithId() {
        return "id игры: " + game_id + "Название игры: " + title + " | Цена: " + price;
    }
}
