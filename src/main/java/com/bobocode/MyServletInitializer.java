package com.bobocode;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class MyServletInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        ctx.setAttribute(AppConfig.SPRING_APP_CONTEXT, new AnnotationConfigApplicationContext(AppConfig.class));
    }
}
