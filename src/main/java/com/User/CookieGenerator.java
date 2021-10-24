package com.User;


import java.util.UUID;

public class CookieGenerator {

    public static String generateCookie(){
        String uuid = UUID.randomUUID().toString();
        uuid.replace("-","");
        return uuid;
    }

}
