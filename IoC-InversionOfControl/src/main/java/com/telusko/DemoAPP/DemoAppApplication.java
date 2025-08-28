package com.telusko.DemoAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {

		// 1. context 啟動 Spring Boot + Start the container
		ApplicationContext context = SpringApplication.run(DemoAppApplication.class, args);

		// 2. 從容器中取得 Dev bean， 且 beam 的意思 = 被註冊到 SPRING IoC 容器的 object
		Dev dev = context.getBean(Dev.class);

		// 呼叫 build 方法
		dev.build();
	}

}

/* 步驟：
1. Context 啟動 Container(Bean)
2. context.getBeam(xxx.class)
*/
