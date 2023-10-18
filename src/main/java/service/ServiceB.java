package service;

import repository.RepoB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    private ServiceA serviceA;
    @Autowired
    private RepoB repoB;
    @Value("${serviceB.value}")
    private int value;

    public ServiceB(ServiceA serviceA, RepoB repoB) {
        this.serviceA = serviceA;
        this.repoB = repoB;
    }

    public void methodB() {
        System.out.println("Value " + value + ". class (ServiceB) method called");
        serviceA.methodA();
        repoB.methodB();
    }
}