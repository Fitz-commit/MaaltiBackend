package com.User;

import com.YouTube.Youtuber;
import com.dataManager.PostgresUserManager;

import java.util.List;

public class Profil {

    private String email;
    private int user_id;
    private String cookie; //eventeull nicht nötig?
    private List<Youtuber> favoriten; //Dürfen MAXIMAL 50 sein falls kein Datenbank aufruf

    //Hier auf Youtuber Klasse gehen mit vermindertem Konstruktor?

    public Profil(String cookie) {
        this.cookie = cookie;
        this.user_id = PostgresUserManager.getPostgresUserManager().getId(cookie);
        this.email = PostgresUserManager.getPostgresUserManager().searchUser(this.user_id);
        this.favoriten = PostgresUserManager.getPostgresUserManager().getAllFavorites(this.user_id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public List<Youtuber> getFavoriten() {
        return favoriten;
    }

    public void setFavoriten(List<Youtuber> favoriten) {
        this.favoriten = favoriten;
    }
}
