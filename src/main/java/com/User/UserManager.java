package com.User;

import com.dataManager.PostgresUserManager;

public class UserManager {

    public void addUser(User user){
        PostgresUserManager.getPostgresUserManager().createTableUser();
        PostgresUserManager.getPostgresUserManager().addUser(user);

    }


}
