package com.User;

import com.dataManager.PostgresUserManager;

public class User {

    private String email;
    private String password;
    private long id = 0;
    private String token;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        //generateID();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    private void generateID(){
        PostgresUserManager post = PostgresUserManager.getPostgresUserManager();
        this.id = post.getDatabaseID() +1;

    }
}
