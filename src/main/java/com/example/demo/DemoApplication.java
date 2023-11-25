package com.example.demo;

import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		TeamService teamService = ctx.getBean("teamService", TeamService.class);
		PlayerServiceImpl playerService = ctx.getBean("playerService", PlayerServiceImpl.class);
		StadiumService stadiumService = ctx.getBean("stadiumService", StadiumService.class);
		TimeslotService timeslotService = ctx.getBean("timeslotService", TimeslotService.class);
		log.info("Teams in database: {}", teamService.getTeams());
		log.info("findTeamById in database: {}", teamService.findTeamById(2L));
		log.info("findTeamsByCountry in database: {}", teamService.findTeamsByCountry("Kazakhstan"));
		log.info("Players in database: {}", playerService.getPlayers());
		log.info("findPlayerById in database: {}", playerService.findPlayerById(5L));
		log.info("findPlayersByName in database: {}", playerService.findPlayersByName("Cristiano"));
		log.info("Stadiums in database: {}", stadiumService.getStadiums());
		log.info("findStadiumById in database: {}", stadiumService.findStadiumById(3L));
		log.info("findStadiumsByCity in database: {}", stadiumService.findStadiumsByCity("Astana"));
		log.info("Timeslots in database: {}", timeslotService.getTimeslots());
		log.info("findTimeslotById in database: {}", timeslotService.findTimeslotById(1L));
		log.info("findTimeslotsByCity in database: {}", timeslotService.findTimeslotsByTime("16:00"));
	}


}