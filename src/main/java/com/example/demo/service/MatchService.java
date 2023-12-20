package com.example.demo.service;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Date;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public Match findMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public List<Match> findMatchesByTeam(Long teamId) {
        return matchRepository.findByAttrTeam(teamId);
    }

    public List<Match> findMatchesByStadium(Long stadiumId) {
        return matchRepository.findByAttrStadium(stadiumId);
    }

    public List<Match> findMatchesByTime(Long timeslotId) {
        return matchRepository.findByAttrTime(timeslotId);
    }

    public List<Match> findMatchesByDate(String date) {
        return matchRepository.findByAttrDate(date);
    }
}