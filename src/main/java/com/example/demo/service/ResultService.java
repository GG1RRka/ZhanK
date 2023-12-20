package com.example.demo.service;

import com.example.demo.model.Result;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Date;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    public Result findResultById(Long id) {
        return resultRepository.findById(id);
    }

    public List<Result> findResultsByMinScore(Long score) {
        return resultRepository.findByAttrMinScore(score);
    }

    public List<Result> findResultsByMaxScore(Long score) {
        return resultRepository.findByAttrMaxScore(score);
    }

    public List<Result> findMatchesByDate(Long winner_id) {
        return resultRepository.findByAttrWinner(winner_id);
    }
}