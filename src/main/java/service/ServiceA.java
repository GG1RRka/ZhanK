package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.RepoA;
import repository.RepoB;
import repository.RepoInterface;

@Service
public class ServiceA {
    @Autowired
    private RepoInterface repoInterface;


    @Autowired
    public void setRepoInterface(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }
    @Value("${serviceA.attribute}")
    private String attribute;
    @Autowired
    public ServiceA(@Qualifier("repoA") RepoInterface repoInterface) {
        setRepoInterface(repoInterface);
    }

    public void methodA() {
        System.out.println("Attribute " + attribute + ". class (ServiceA) method called");
        repoInterface.repoMethod();
    }
}