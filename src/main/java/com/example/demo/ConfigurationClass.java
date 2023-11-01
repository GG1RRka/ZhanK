package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import com.example.demo.repository.RepoA;
import com.example.demo.repository.RepoB;
import com.example.demo.repository.RepoC;
import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceB;
import com.example.demo.service.ServiceC;
import com.example.demo.service.ServiceD;

@Configuration
@PropertySource("application.properties")
public class ConfigurationClass {
    @Bean("serviceAFromConfigurationClass")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(getRepoA());
        return serviceA;
    }
    @Bean("serviceBFromConfigurationClass")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB(getServiceA(), getRepoB());
        return serviceB;
    }

    @Bean("serviceCFromConfigurationClass")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC(getServiceB(), getRepoC());
        return  serviceC;
    }

    @Bean("serviceDFromConfigurationClass")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(getServiceC());
        return serviceD;
    }

    @Bean("repoAFromConfigurationClass")
    @Primary
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

}