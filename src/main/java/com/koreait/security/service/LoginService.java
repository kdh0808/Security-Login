package com.koreait.security.service;

import com.koreait.security.dto.UserDTO;
import com.koreait.security.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void post_register(UserDTO userDTO){
        // 기존 평문 패스워드를 인코딩 한다
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        System.out.println(encodedPassword);
        // 전달받은 유저 객체에 설정한다
        userDTO.setPassword(encodedPassword);
        // DB에 회원가입 시도한다
        loginMapper.post_user(userDTO);
    }
}
