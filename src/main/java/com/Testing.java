package com;

import com.User.User;
import com.User.UserManager;
import com.YouTube.YTAPICall;
import com.dataManager.PostgresUserManager;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Testing {

    public static void main(String[] args) throws GeneralSecurityException, IOException {

        System.out.println(YTAPICall.channelListUsername("Gronkh").getCreatorid());

    }

}
