package com.fsd.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"com.fsd.spring.config","com.fsd.spring.entity","com.fsd.spring.helper","com.fsd.spring.controller","com.fsd.spring.dao"})
public class WebAppConfig {
    @Bean
    public InternalResourceViewResolver viewresolver()
    {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }

}
