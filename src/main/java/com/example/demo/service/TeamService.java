package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findTeamsByName(String name) {
        return teamRepository.findByAttrName(name);
    }

    public List<Team> findTeamsByCountry(String country) {
        return teamRepository.findByAttrCountry(country);
    }

    public void addTraining(Team team, Integer x) {
        teamRepository.addTraining(team, x);
    }
    public List<Integer> getTrainingList(Team team) {
        return teamRepository.getTrainingList(team);
    }
}