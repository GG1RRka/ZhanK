package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.demo.service.ServiceD;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		ServiceD serviceDFromConfigurationClass = ctx.getBean("serviceDFromConfigurationClass", ServiceD.class);
		serviceDFromConfigurationClass.methodD();
	}

}