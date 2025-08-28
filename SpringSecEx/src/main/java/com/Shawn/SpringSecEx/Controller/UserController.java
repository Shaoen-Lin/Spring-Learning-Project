package com.Shawn.SpringSecEx.Controller;

import com.Shawn.SpringSecEx.Model.Users;
import com.Shawn.SpringSecEx.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userservice;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    // 2^12 輪 Hash 加密

    @PostMapping("/register")
    public Users register(@RequestBody Users user) // 建立會直接便一個 user object 直接 assign 就可以！
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return userservice.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user)
    {
        return userservice.verify(user);
    }
}
