package com.wangzai.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 *
 * 功能描述: 设置拦截规则
 * //TODO WebMvcConfiguration 在springboot2.0时已经过时 这里暂时使用WebMvcConfigurationSupport解决 但是对应静态资源拦截是失效的
 * @param:
 * @return:
 * @auther: zhangw
 * @date: 2018/9/29 10:58
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurationSupport {

    /**
     * 配置静态资源
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/sql-mapping/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/generator/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/xxx/login") //登录页
                .excludePathPatterns("//user/sendEmail") //发送邮箱
                .excludePathPatterns("//user/register") //用户注册
                .excludePathPatterns("//user/login"); //用户登录
        super.addInterceptors(registry);
    }
}
