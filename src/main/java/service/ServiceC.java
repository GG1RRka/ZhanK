package service;

import repository.RepoC;
import service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ServiceC {
    @Autowired
    private ServiceB serviceB;
    private RepoC repoC;

    public ServiceC(ServiceB serviceB, RepoC repoC) {
        this.serviceB = serviceB;
        this.repoC = repoC;
    }

    public void methodC() {
        System.out.println("class (ServiceC) method called");
        serviceB.methodB();
        repoC.repoMethodC();
    }
}