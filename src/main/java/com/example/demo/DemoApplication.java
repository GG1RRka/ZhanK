package com.example.demo;

import com.example.demo.model.SalaryPayment;
import com.example.demo.model.Training;
import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = { "com.*" })
@EntityScan("com.*")
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		TeamService teamService = ctx.getBean("teamService", TeamService.class);
		SalaryService salaryService = ctx.getBean("salaryService", SalaryService.class);

		log.info("Teams in getTeams: {}", teamService.getTeams());
		log.info("Teams by findTeamsByName: {}", teamService.findTeamsByName("Spartak"));

		ExecutorService executorTeam = Executors.newFixedThreadPool(10);
		executorTeam.submit(new Training(teamService));

		log.info("getTrainingList by TeamId: {}", teamService.getTrainingList(teamService.findTeamById(3L)));

		ExecutorService executorSalary = Executors.newFixedThreadPool(10);
		executorSalary.submit(new SalaryPayment());

		log.info("Salaries in getSalaries: {}", salaryService.getSalaries());
		log.info("Salaries by findSalariesByCurrency: {}", salaryService.findSalariesByCurrency("KZT"));
		log.info("Salaries by findSalariesByTeam: {}", salaryService.findSalariesByTeam(5L));

	}

}