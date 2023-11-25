package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public List<Team> getTeams() {
        return teamRepository.findAllTeamsNative();
    }

    public Optional<Team> findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findTeamsByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> findTeamsByCountry(String country) {
        return teamRepository.findByCountry(country);
    }
}