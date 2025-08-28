package com.Shawn.SpringSecEx.Service;

import com.Shawn.SpringSecEx.Model.Users;
import com.Shawn.SpringSecEx.Model.UserPrincipal;
import com.Shawn.SpringSecEx.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
// 因為 UserDetailsService 是一個 Interface 所以我們選擇寫一個 Class實作他

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = repo.findByUsername(username);

        if(users == null)
        {
            System.out.println("User Not Found");
            // 印在 Console 上
            throw new UsernameNotFoundException("user not found");
            // 給前端知道
        }

        return new UserPrincipal(users);

        // 這邊的邏輯是：如果資料庫確定有這人 我們就把這人的資訊回傳回去

        // 當使用者登入時，Spring Security 會去呼叫你實作的 UserDetailsService (= MyUserDetailsService)，
        // 然後這個 MyUserDetailsService 會回傳一個 UserDetails 的物件給 Spring Security，
        // Spring Security 就會根據這個物件來判斷：
        // 這個使用者存不存在？
        // 密碼對不對？
        // 有哪些權限可以使用？
        // 帳號有沒有被鎖定？
        // 資料有沒有過期？
        // 是否啟用？
        // 因為 UserDetails 也是 interface 所以這次我們也要寫一個 Class 來時做我們要的 UserDetails
        // 也就是 UserPrincipal
    }
}
