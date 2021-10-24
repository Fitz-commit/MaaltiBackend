package com.User;

import javax.servlet.http.Cookie;

public class CookieGenerator {

    public static Cookie generateCookie(){

        Cookie cookie = new Cookie("abc","def");

        cookie.setMaxAge(500);

        return cookie;
    }

}
