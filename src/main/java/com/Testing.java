package com;

import com.User.User;
import com.YouTube.YTAPICall;
import com.dataManager.PostgresUserManager;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Testing {

    public static void main(String[] args) throws GeneralSecurityException, IOException {


        PostgresUserManager.getPostgresUserManager().addFavorite("sdfdsfsdf",293);
        //YTAPICall.searchVideos("UCYJ61XIK64sp6ZFFS8sctxw", "date");
        //System.out.println(m1.searchYoutuberByName("Pietsmiet"));
        //System.out.println(m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw"));
        //System.out.println(m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw"));
    }

}
