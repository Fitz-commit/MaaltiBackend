package com;

import com.User.User;
import com.YouTube.YTAPICall;
import com.dataManager.PostgresUserManager;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Testing {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        Mapping m1 = new Mapping();

        m1.getProfil("6c36534c-9379-4edd-bfc6-cd3e1d6d2205");

        //PostgresUserManager.getPostgresUserManager().addYoutuber("234234324","gg","abc");
        //YTAPICall.searchVideos("UCYJ61XIK64sp6ZFFS8sctxw", "date");
        //System.out.println(m1.searchYoutuberByName("Pietsmiet"));
        //System.out.println(m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw"));

    }

}
