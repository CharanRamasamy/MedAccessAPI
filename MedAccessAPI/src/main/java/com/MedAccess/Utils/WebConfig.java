package com.MedAccess.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/MedAccess/**")
                //.allowedOrigins("https://medaccess.herokuapp.com")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("PUT", "DELETE", "GET", "POST", "HEAD", "OPTIONS")
                .allowedHeaders("Content-Type", "Access-Control-Allow-Origin")
                .exposedHeaders("header-1", "header-2")
                .allowCredentials(false).maxAge(3600);
    }
}