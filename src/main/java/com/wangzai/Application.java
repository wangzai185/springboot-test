package com.wangzai;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   //标注一个类是配置类，spring boot在扫到这个注解时自动加载这个类相关的功能
@EnableAutoConfiguration  //启用自动配置 该框架就能够进行行为的配置，以引导应用程序的启动与运行, 根据导入的starter-pom 自动加载配置
@ComponentScan  //扫描组件 @ComponentScan(value = "com.spriboot.controller") 配置扫描组件的路径
public class Application {
    public static void main(String[] args) {
        // 启动Spring Boot项目的唯一入口
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}