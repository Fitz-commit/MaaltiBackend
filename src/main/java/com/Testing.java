package com;

import com.User.User;
import com.User.UserManager;

public class Testing {

    public static void main(String[] args) {

        UserManager manager = new UserManager();
        User Testuser = new User("Test", "Test123");
        manager.addUser(Testuser);


    }

}
