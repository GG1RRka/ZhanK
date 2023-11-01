package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import com.example.demo.repository.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;


@Component
@Slf4j
@Service
public class ServiceC {
    //@Autowired
    private ServiceB serviceB;
    private RepoInterface repoInterface;

    //@Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
    public void setRepoInterface(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public ServiceC(ServiceB serviceB, @Qualifier("repoCFromConfigurationClass") RepoInterface repoInterface) {
        setServiceB(serviceB);
        setRepoInterface(repoInterface);
    }

    public void methodC() {
        System.out.println("class (ServiceC) method called");

        repoInterface.repoMethod();
    }

    public String throwErrorMethodC() throws DataFormatException {
        throw new DataFormatException("class (ServiceC) method called");
    }
}