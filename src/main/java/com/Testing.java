package com;

import com.User.User;
import com.YouTube.YTAPICall;
import com.dataManager.PostgresUserManager;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Testing {

    public static void main(String[] args) throws GeneralSecurityException, IOException {

        Mapping m1 = new Mapping();
        //System.out.println(PostgresUserManager.getPostgresUserManager());
        //YTAPICall.searchVideos("UCYJ61XIK64sp6ZFFS8sctxw", "date");
        //System.out.println(m1.searchYoutuberByName("Pietsmiet"));
        System.out.println(m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw"));
    }

}
