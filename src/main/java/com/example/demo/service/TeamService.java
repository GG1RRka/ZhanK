package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        try {
            return teamRepository.findAll();
        } catch (SQLException e) {
            log.error("Error getting team: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addTeam(Team team) {
        try {
            teamRepository.insert(team);
        } catch (Exception e) {
            log.error("Error adding team: {}", e.getMessage(), e);
        }
    }

    public void deleteTeam(Long id) {
        try {
            teamRepository.delete(id);
        } catch (Exception e) {
            log.error("Error deleting team: {}", e.getMessage(), e);
        }
    }

    public Team findTeamById(Long id) {
        try {
            return teamRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding team: {}", e.getMessage(), e);
            return new Team();
        }
    }

    public List<Team> findTeamsByName(String name) {
        try {
            return teamRepository.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Team> findTeamsByCountry(String country) {
        try {
            return teamRepository.findByAttrCountry(country);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}