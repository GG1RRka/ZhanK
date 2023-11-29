package com.example.demo.service;

import com.example.demo.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {

    public List<Result> getResults();
    public Result findResultById(Long id);
    public List<Result> findResultsByMinScore(Long score);
    public List<Result> findResultsByMaxScore(Long score);
    public List<Result> findResultsByWinner(Long winner_id);
}