//package com.koreait.security.config;
//
//import com.koreait.security.filter.CsefTokenFilter;
//import com.koreait.security.service.CustomUserDetailsService;
//import com.koreait.security.user.DummyUser;
//import com.koreait.security.vo.UserVO;
//import lombok.Builder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.csrf.CsrfFilter;
//
//@Configuration
//public class ProjectConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterAfter(new CsefTokenFilter(), CsrfFilter.class)
//                .authorizeRequests()
//                .mvcMatchers("/main").authenticated()   // james tom
//                .mvcMatchers("/board").hasRole("USER")  // james
//                .mvcMatchers("/board").hasAuthority("READ") //tom
//                .mvcMatchers("/error").permitAll()  // james tom 로그인없이 가능
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic(c ->{
//                    c.realmName("TEST");
//                    c.authenticationEntryPoint(new CustomEntryPoint());
//                });
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var manager = new InMemoryUserDetailsManager();
//        UserDetails james = User.withUsername("james")
//                .password(passwordEncoder().encode("456"))
//                .roles("USER")
//                .authorities("READ")
//                .build();
//        UserDetails tom = User.withUsername("tom")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN")
//                .authorities("WRITE")
//                .build();
//        manager.createUser(james);
//        manager.createUser(tom);
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//
//}
