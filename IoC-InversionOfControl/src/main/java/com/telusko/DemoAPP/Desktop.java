package com.telusko.DemoAPP;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 打入 Component 就可以
@Primary
public class Desktop implements Computer{
    public void compile()
    {
        System.out.println("405 bugs");
    }
}
//
/* 要 Spring 幫你建立 Object 實現 IoC 就要
   1. @Component
   2. @Autowired 進行 Class 之間的連線
 */