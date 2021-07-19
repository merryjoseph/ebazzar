package com.sayone.ebazzar.security;

import com.sayone.ebazzar.SpringApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME=864000000;
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000;




    public static String getTokenSecret(){
        AppProperties appProperties=(AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }

}
