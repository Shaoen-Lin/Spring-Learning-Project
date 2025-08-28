package com.shawn.QuickWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Web {
    @RequestMapping("/")
    public String greet()
    {
        return "Hello World, Welcome to Shawn's First Web Project";
    }
}