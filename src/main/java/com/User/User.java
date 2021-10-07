package com.User;

public class User {

    private String username;
    private String password;
    private int id = 0;
    private String token;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        generateID();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getId() {
        return id;
    }

    private void generateID(){
        this.id = this.id +1;
    }
}
