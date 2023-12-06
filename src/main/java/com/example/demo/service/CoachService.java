package com.example.demo.service;

import com.example.demo.model.Coach;
import com.example.demo.repository.CoachRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;
    public List<Coach> getCoaches() {
        return coachRepository.findAll();
    }

    public Coach findCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public List<Coach> findCoachesByName(String name) {
        return coachRepository.findByAttrName(name);
    }

    public List<Coach> findCoachesBySurname(String surname) {
        return coachRepository.findByAttrSurname(surname);
    }

    public List<Coach> findCoachesByTeam(Long team_id) {
        return coachRepository.findByAttrTeam(team_id);
    }

    public List<Coach> findCoachesByCountry(String country) {
        return coachRepository.findByAttrCountry(country);
    }
}