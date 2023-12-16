package com.koreait.security.service;

import com.koreait.security.dto.UserDTO;
import com.koreait.security.mapper.LoginMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(" ======= loadUserByUsername: ["+ username + "]");
        // 로그인 시도 한 유저 이름(id)가 DB에 있는지 확인해서 유저를 가져온다
        UserDTO userDTO = loginMapper.get_user_by_id(username);
        // DB에 해당 이름의 유저가 없었다!
        if(userDTO == null){
            throw new UsernameNotFoundException("ERROR: USER NOT FOUND!");
        }
        // 유저가 있었다면 그 유저의 내용으로 User 객체를 생성한 뒤 반환
        return User
                .withUsername(userDTO.getUserID())
                .password(userDTO.getPassword())
                .authorities("ROLE_READ")
                .build();
    }
}
