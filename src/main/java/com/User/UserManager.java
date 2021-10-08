package com.User;

import com.dataManager.PostgresUserManager;

public class UserManager {

    public static void addUser(User user){

        PostgresUserManager.getPostgresUserManager().addUser(user);

    }


}
