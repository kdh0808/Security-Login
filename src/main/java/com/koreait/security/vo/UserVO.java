package com.koreait.security.vo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.LinkedList;

@ToString
public class UserVO extends User {


    private String userID;
    private String password;


    public UserVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userID = username;
        this.password = password;

    }
}
