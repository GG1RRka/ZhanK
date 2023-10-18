package service;

import org.springframework.beans.factory.annotation.Qualifier;
import repository.RepoB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.RepoC;
import repository.RepoInterface;

@Service
public class ServiceB {
    @Autowired
    private ServiceA serviceA;
    @Autowired
    private RepoInterface repoInterface;
    @Value("${serviceB.value}")
    private int value;

    @Autowired
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Autowired
    public void setRepoInterface(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public ServiceB(ServiceA serviceA, @Qualifier("repoB") RepoInterface repoInterface) {
        setServiceA(serviceA);
        setRepoInterface(repoInterface);
    }

    public void methodB() {
        System.out.println("Value " + value + ". class (ServiceB) method called");
        serviceA.methodA();
        repoInterface.repoMethod();
    }
}