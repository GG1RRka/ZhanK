package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RepoInterface;

@Service
public class ServiceA {
    private RepoInterface repoInterface;


    public void setRepoInterface(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }
    @Value("My Bean Method")
    private String attribute;
    //@Autowired
    public ServiceA(@Qualifier("repoAFromConfigurationClass") RepoInterface repoInterface) {
        setRepoInterface(repoInterface);
    }

    public void methodA() {
        System.out.println("Attribute " + attribute + ". class (ServiceA) method called");
        repoInterface.repoMethod();
    }
}