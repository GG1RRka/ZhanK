package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.RepoA;

@Service
public class ServiceA {
    @Autowired
    private RepoA repoA;


    @Value("${serviceA.attribute}")
    private String attribute;
    public ServiceA(RepoA repoA) {
        this.repoA = repoA;
    }

    public void methodA() {
        System.out.println("Attribute " + attribute + ". class (ServiceA) method called");
        repoA.methodA();
    }
}