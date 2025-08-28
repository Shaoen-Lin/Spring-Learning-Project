package com.Shawn;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // This line basically create the container + configure the class in it(by XML File)
        // BeanFactory 是 Spring Framework 中最基本的 IOC Container，
        // This line also help you create the class 所以會直接 Call Constructor

        Develop obj = (Develop) context.getBean("dev");
//        System.out.println(obj.getAge());
        obj.build();

        /*
        Develop obj = (Develop) context.getBean("dev");
        // This line put "Develop.class" or its id which is "dev" into container & get the beam to obj
        // TYPE CASTING IS inevitable
        obj.build();
        */
    }
}
