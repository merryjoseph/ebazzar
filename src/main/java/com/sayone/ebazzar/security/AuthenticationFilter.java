package com.sayone.ebazzar.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayone.ebazzar.SpringApplicationContext;
import com.sayone.ebazzar.dto.UserDto;
import com.sayone.ebazzar.model.request.UserLoginRequestModel;
import com.sayone.ebazzar.service.UserService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserLoginRequestModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLoginRequestModel.class);


            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String userName = ((User) auth.getPrincipal()).getUsername();


        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis()+ SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.getTokenSecret())
                .compact();

        UserService userService= (UserService) SpringApplicationContext.getBean("userService");
        UserDto userDto=userService.getUser(userName);

        res.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+ token);
        res.addHeader("Email",userDto.getEmail());

    }




}
