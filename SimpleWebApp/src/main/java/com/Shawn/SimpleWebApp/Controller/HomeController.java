package com.Shawn.SimpleWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller
public class HomeController {

    @RequestMapping("/") // 如果有人 request = / 則執行這個。
    public String greet()
    {
        return "Welcome to Shawn！";
        // 會讓他去找 "Welcome to Shawn！" 的 page(layout) ，(No static resource Welcome to Shawn！)
        // 若我們要看到 字 回傳 state(data) -> RestController
    }

    @RequestMapping("/about")
    public String about()
    {
        return "We don't have about";
    }

}
