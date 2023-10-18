package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ServiceC;

@Service
public class ServiceD {
    @Autowired
    private ServiceC serviceC;

    public ServiceD(ServiceC serviceC) {
        this.serviceC = serviceC;
    }

    public void methodD() {
        System.out.println("class (ServiceD) method called");
        serviceC.methodC();
    }
}