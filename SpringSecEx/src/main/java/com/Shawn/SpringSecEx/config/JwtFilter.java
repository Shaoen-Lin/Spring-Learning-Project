package com.Shawn.SpringSecEx.config;

import com.Shawn.SpringSecEx.Service.JWTService;
import com.Shawn.SpringSecEx.Service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter { // 為了讓他表現得像 Filter 我們直接 extends OncePerRequestFilter
    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context; // ApplicationContext 是所有 bean 的容器 取名為 context

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        // Authorization 會得到 Bearer token 也就是 Bearer xxxxxxxxxxxxxxx token xxxxxxxxxxxx
        String token = null;
        String username = null;

        // 取得 Token
        if(authHeader != null && authHeader.startsWith("Bearer "))
        {
            token = authHeader.substring(7); // 把前6個字切掉
            username = jwtService.extractUserName(token);
        }


        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
        //getAuthentication() == null 指 目前還沒有任何使用者登入資訊被放進來 => 不會重複登入
        {
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            // userDetails 取得 UserDetails 這個 bean

            if(jwtService.validateToken(token, userDetails))
            {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                //UsernamePasswordAuthenticationToken 是 Spring Security 中用來封裝 用戶名 和 密碼，並交給 AuthenticationManager 的
                // it ask three things ： Principal 、 Credential 、 Authority
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                // We Pass this filter so we have to create another authToken to pass to the next Filter
                // to tell it I do have the token
            }
        }
        filterChain.doFilter(request, response);
    }
}
