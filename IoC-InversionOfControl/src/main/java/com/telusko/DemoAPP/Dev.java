package com.telusko.DemoAPP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {


    @Autowired // Field injection 會有問題
//    @Qualifier("laptop") // Qualifier have to refer the class name(第一個字要轉小寫), which called "beam name"
    private Computer com; // This is called Beam

//    public Dev(Laptop laptop) // Constructor Injection
//    {
//        this.laptop = laptop;
//    }

    // Autowired 是用來連接 Laptop 的
//    @Autowired // Setter Injection 也要使用 @AutoWired
//    public void setLaptop(Laptop laptop)
//    {
//        this.laptop = laptop;
//    }



    public void build()
    {
        com.compile();
        System.out.println("Yes");
    }
}

/* Dependency Injection 分成 3 種：
   因為我們使用的是Beam了，所以不會使用 Laptop() laptop = new Laptop(); 的語法 (這不是IoC)
   1. Constructor Injection
   2. Setter Injection -> 需要 Autowired
   3. Field Injection (不建議使用) -> 需要 Autowired
 */