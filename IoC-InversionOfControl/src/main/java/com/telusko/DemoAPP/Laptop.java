package com.telusko.DemoAPP;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public void compile()
    {
        System.out.println("404 bugs");
    }
}
