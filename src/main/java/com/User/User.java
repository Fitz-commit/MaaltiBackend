package com.User;

public class User {

    private String email;
    private String password;
    private int id = 0;
    private String token;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        generateID();
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

    public int getId() {
        return id;
    }

    private void generateID(){
        this.id = this.id +1;
    }
}
