package com.Shawn.SpringSecEx.config;

import com.Shawn.SpringSecEx.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // 就是告訴 JAVA 說我要使用 自己的Filter
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private  JwtFilter jwtFilter;

    @Bean // 指 建立一個 Spring 容器
    public DefaultSecurityFilterChain customSecurityConfig(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable())
                 // 就是取消 csrf
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().authenticated())
                // 說明 any request 都要驗證(但沒配上底下的 login 都會不給你連 + 跟你說 403 Forbidden)
                //.http.formLogin(Customizer.withDefaults()); // For Bowser Login
                .httpBasic(Customizer.withDefaults())
                // For Postman Login "Basic"
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 代表 變成 stateless 每次都會給你新的 session_ID 但就會一直卡在 Login 畫面
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
        // Builder pattern
    }
    // Build FilterChain

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        // 這邊的意思是每次當使用者要使用時加密存入資料庫中，當有需要比對時，Plaintext會再被轉成 密文 比對。
        // 這邊必須要跟你當時Registry時 BCrypt 加密次數，當你加入2^12次時，你打當時的 plain text 才能轉換成正確的密文
        // NoOpPasswordEncoder.getInstance() 使用者登入時輸入的密碼，請直接用純文字去跟資料庫中的密碼做比對，不要做任何加密運算
        provider.setUserDetailsService(userDetailsService);
        // UserDetailsService 是一個 interface，用來定義使用者資料來源(我們要自訂義成Postgre)
        return provider;
    }
    // Build AuthenticationProvider
    // 自訂義 authenticationProvider 來連接資料庫 需做到：
    // 1. 需要 Pass Encoder
    // 2. 需要 Pass CustomUserDetailsService (本身是一個Service因為會寫連到資料庫的邏輯) (又需要 Pass UserDetails)

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    // AuthenticationManger will talk to AuthenticationProvider


}
