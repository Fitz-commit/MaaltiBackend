package com;

import com.User.User;
import com.YouTube.YTAPICall;
import com.dataManager.PostgresUserManager;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Testing {

    public static void main(String[] args) throws GeneralSecurityException, IOException, MessagingException {
        Mapping m1 = new Mapping();

        //m1.searchYoutuberByName("Kurzgesagt");
        //m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw", "title");




        //TODO WAS WENN YOUTUBER KEINE LIKES HAT ?
        //PostgresUserManager.getPostgresUserManager().addFavor("11",30);
        //YTAPICall.searchVideos("UCYJ61XIK64sp6ZFFS8sctxw", "date");
        //System.out.println(m1.searchYoutuberByName("Pietsmiet"));
        //System.out.println(m1.getYoutuberById("UCYJ61XIK64sp6ZFFS8sctxw"));
        //UC_x5XG1OV2P6uZZ5FSM9Ttw

    }

}
