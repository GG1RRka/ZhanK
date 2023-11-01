package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.DataFormatException;

@Slf4j
@Service
public class ServiceD {
    //@Autowired
    private ServiceC serviceC;

    private String attribute;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String value) {
        this.attribute = value;
    }

    //@Autowired
    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
    }
    public ServiceD(ServiceC serviceC) {
        setServiceC(serviceC);
    }

    public void methodD() {
        System.out.println("attribute: " + attribute + " class (ServiceD) method called");
        serviceC.methodC();
        try {
            serviceC.throwErrorMethodC();
        } catch (DataFormatException e) {
            log.error("Threw");
        }
    }

    private void init() {
        System.out.println("method called before init");
        Assert.notNull(serviceC, "Service C not null");

    }

    private void destroy() {
        System.out.println("method called after all");
        serviceC = null;

    }

    @PostConstruct
    public void postConstruct() {
        log.info("Initializing bean using 'PostConstruct()'");
    }

    @PreDestroy
    public void preDestroy() throws IOException {
        log.info("@PreDestroy method called");
        if(serviceC == null) {
            Files.deleteIfExists((Path)serviceC);
        }
    }

}