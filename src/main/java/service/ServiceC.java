package service;

import org.springframework.beans.factory.annotation.Qualifier;
import repository.RepoC;
import repository.RepoInterface;
import service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ServiceC {
    @Autowired
    private ServiceB serviceB;
    @Autowired
    private RepoInterface repoInterface;

    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Autowired
    public void setRepoInterface(@Qualifier("repoC") RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public ServiceC(ServiceB serviceB, RepoInterface repoInterface) {
        setServiceB(serviceB);
        setRepoInterface(repoInterface);
    }

    public void methodC() {
        System.out.println("class (ServiceC) method called");
        serviceB.methodB();
        repoInterface.repoMethod();
    }
}