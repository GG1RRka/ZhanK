package com.example.demo.model;

import com.example.demo.DemoApplication;
import com.example.demo.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

@Slf4j
public class Training implements Runnable {
    TeamService teamService;
    public Training() {}
    public Training(TeamService teamService) {
        this.teamService = teamService;
    }
    @Override
    public void run() {
        log.info("Started working day");
        Stream.iterate(0, n -> n + 1).limit(7)
                .forEach(id -> {
                    log.info("Starting training with id " + id);
                    for (Team team : teamService.getTeams()) {
                        log.info("team #" + team.getId() + " is doing training #" + id);
                        //teamService.addTraining(team, id);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        log.info("Finished working day");
    }
}