package com.Shawn.SpringSecEx.Repo;

import com.Shawn.SpringSecEx.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// 這個 Table 存可被接受的 UserData

public interface UserRepo extends JpaRepository<Users, Integer> {
    // 這裡要建立 1 個 Class (User)


    Users findByUsername(String username);
    // 給 JPA 幫我們實作
}
