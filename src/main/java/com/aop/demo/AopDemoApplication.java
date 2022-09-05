package com.aop.demo;

import com.aop.demo.config.AopConfig;
import com.aop.demo.controller.SimpleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        SimpleController simpleController = context.getBean("simpleController", SimpleController.class);
        simpleController.test();
    }
}
