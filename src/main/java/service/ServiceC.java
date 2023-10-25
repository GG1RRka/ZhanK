package service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import repository.RepoC;
import repository.RepoInterface;
import service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;


@Component
@Slf4j
@Service
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

        repoInterface.repoMethod();
    }

    public String throwErrorMethodC() throws DataFormatException {
        throw new DataFormatException("class (ServiceC) method called");
    }
}