package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.RepoA;
import repository.RepoB;
import repository.RepoC;
import service.ServiceA;
import service.ServiceB;
import service.ServiceC;
import service.ServiceD;

@Configuration
public class ConfigurationClass {
    @Bean("serviceAFromConfigurationClass")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(new RepoA());
        return serviceA;
    }
    @Bean("serviceBFromConfigurationClass")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB(getServiceA(), new RepoB());
        return serviceB;
    }

    @Bean("serviceCFromConfigurationClass")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC());
        return  serviceC;
    }

    @Bean("serviceDFromConfigurationClass")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC()));
        return serviceD;
    }

    @Bean("repoAFromConfigurationClass")
    public RepoA getRepoA(){
        return new RepoA();
    }

    @Bean("repoBFromConfigurationClass")
    public RepoB getRepoB(){
        return new RepoB();
    }

    @Bean("repoCFromConfigurationClass")
    public RepoC getRepoC(){
        return new RepoC();
    }

    @Value("${configurationClass.value}")
    private String configurationValue;

}