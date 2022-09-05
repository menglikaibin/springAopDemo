package com.aop.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// @EnableAspectJAutoProxy用于开启注解版的Spring AOP功能，类似使用XML方式的<aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
@ComponentScan("com.aop.demo")
public class AopConfig {
}
