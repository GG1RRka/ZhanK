package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RepoInterface;

@Service
@PropertySource("myprops.properties")
public class ServiceB {
    private ServiceA serviceA;
    private RepoInterface repoInterface;
    @Value("${serviceB.value}")
    private int value;

    public ServiceB(ServiceA serviceA, @Qualifier("repoBFromConfigurationClass") RepoInterface repoInterface) {
        this.serviceA = serviceA;
        this.repoInterface = repoInterface;
    }

    public void methodB() {
        System.out.println("Value " + value + ". class (ServiceB) method called");
        serviceA.methodA();
        repoInterface.repoMethod();
    }
}