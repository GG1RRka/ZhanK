package com.example.demo.service;

import com.example.demo.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Date;

@Service
public interface MatchService {

    public List<Match> getMatches();
    public Match findMatchById(Long id);
    public List<Match> findMatchesByTeam(Long teamId);
    public List<Match> findMatchesByStadium(Long stadiumId);
    public List<Match> findMatchesByTimeslot(Long timeslotId);
    public List<Match> findMatchesByDate(String date);
}