package com.Shawn.SpringSecEx.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private Users users;

    public UserPrincipal(Users users) {
        this.users = users;
    }
    // 這樣才能會還 password、Username ...

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
        // 指的是 by default 每個在 資料庫的user都會是 USER 權限
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
        // 意思是 機敏資料是否 未過期
    }

    @Override
    public boolean isEnabled() {
        return true;
        // 意思是 account is 啟用
    }
}
