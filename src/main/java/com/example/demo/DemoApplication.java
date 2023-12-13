package com.example.demo;

import com.example.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories("com.example.demo")
@EntityScan("com.example.demo.model")
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		TeamService teamService = ctx.getBean("teamService", TeamService.class);
		PlayerService playerService = ctx.getBean("playerService", PlayerService.class);
		StadiumService stadiumService = ctx.getBean("stadiumService", StadiumService.class);
		TimeslotService timeslotService = ctx.getBean("timeslotService", TimeslotService.class);
		MatchServiceImpl matchService = ctx.getBean("matchService", MatchServiceImpl.class);
		CoachService coachService = ctx.getBean("coachService", CoachService.class);
		ResultServiceImpl resultService = ctx.getBean("resultService", ResultServiceImpl.class);
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
		log.info("Matches in database: {}", matchService.getMatches());
		log.info("findMatchesByTeam in database: {}", matchService.findMatchesByTeam(4L));
		log.info("findMatchesByDate in database: {}", matchService.findMatchesByDate("2023-01-18"));
		log.info("Coaches in database: {}", coachService.getCoaches());
		log.info("findCoachesByTeam in database: {}", coachService.findCoachesByTeam(2L));
		log.info("findCoachesByDate in database: {}", coachService.findCoachesBySurname("Klopp"));
		log.info("Results in database: {}", resultService.getResults());
		log.info("findResultsByTeam in database: {}", resultService.findResultById(5L));
		log.info("findResultsByDate in database: {}", resultService.findResultsByMaxScore(2L));
	}
}