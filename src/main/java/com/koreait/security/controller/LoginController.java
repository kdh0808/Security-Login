package com.koreait.security.controller;

import com.koreait.security.dto.UserDTO;
import com.koreait.security.mapper.LoginMapper;
import com.koreait.security.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login/main")
    public void get_login(Model model, String error, @AuthenticationPrincipal UserDetails userDetails){
        log.info("==== login 페이지로 이동 === ");
        if(error != null && error.isEmpty()){
            model.addAttribute("errorMessage", "! 로그인 실패했어요 !");
        }
        if(userDetails != null){
            System.out.println("현재 로그인되어있는 유저 :" + userDetails.getUsername());
        }
    }

    @GetMapping("/login/register")
    public void get_register(){

    }

    @GetMapping("/logout")
    public String get_logout(){
        return "redirect:/board/main";
    }

    @PostMapping("/login/register")
    public String post_register(UserDTO userDTO){
        loginService.post_register(userDTO);
        return "redirect:/board/main";
    }
}
