package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {

    public MyBean() {
        System.out.println("Constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method called");
    }

    public void customInitMethod() {
        System.out.println("Custom initMethod called");
    }

    public void customDestroyMethod() {
        System.out.println("Custom destroyMethod called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy method called");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean's destroy method called");
    }
}