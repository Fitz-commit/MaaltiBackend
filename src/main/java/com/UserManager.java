package com;

public class UserManager {

    public void addUser(User user){
        PostgresUserManager.getPostgresUserManager().addUser(user);

    }


}
