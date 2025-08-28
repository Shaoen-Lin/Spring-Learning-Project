package com.Shawn;

import org.springframework.stereotype.Component;

@Component
public class Develop {

    private Computer com;

//    private int age;
//
//    public Develop(int age) {
//        this.age = age;
//        System.out.println("Develop Constructor"); // 區分 Default Constructor
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Computer getCom() {
//        return com;
//    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public Develop()
    {
        System.out.println("Dev Constructor");
    }

    public void build()
    {
        System.out.println("You Did It！");
        com.compile();
    }
}

