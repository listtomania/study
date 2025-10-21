package org.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Setter
@Getter
public class Game {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGame_time() {
        return game_time;
    }

    public void setGame_time(int game_time) {
        this.game_time = game_time;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int id;
    private String title;
    private Date release_date;
    private float price;
    private boolean online;
    private int hard;
    private int game_time;

    public Game() {
    }

    public Game(int id, int game_time, int hard, boolean online, float price, Date release_date, String title) {
        this.id = id;
        this.game_time = game_time;
        this.hard = hard;
        this.online = online;
        this.price = price;
        this.release_date = release_date;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Название: " + title + "  Дата релиза: " + release_date + "  Цена: " + price + "  Время прохождения: " + game_time + "  Онлайн: " + online + "  Сложность: " + hard;

    }
}
