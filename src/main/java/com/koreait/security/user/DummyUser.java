package com.koreait.security.user;

import com.koreait.security.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class DummyUser extends User implements UserDetails {
    private UserVO userVO;

    public DummyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

    }


}
