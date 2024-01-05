package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.model.Salary;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.SalaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public Rating findRatingById(Long id) {
        return ratingRepository.findSalaryById(id);
    }

    public List<Rating> findRatingsByName(Long value) {
        return ratingRepository.findByAttrValue(value);
    }

    public List<Rating> findRatingsByTime(Long assignTime) {
        return ratingRepository.findByAttrAssignTime(assignTime);
    }

    public List<Rating> findRatingsByTeam(Long team_id) {
        return ratingRepository.findByAttrTeam(team_id);
    }

    @Scheduled(fixedDelay = 1000)
    public void ratingDecayForAll() {
        for (Rating i : getRatings()) {

        }
        log.info("Rating decay - {}", System.currentTimeMillis() / 1000);
    }
    @Scheduled(fixedRate = 2000 /*7200000*/) // Training is on every 2nd day (for demonstration - every 2 seconds)
    public void ratingUpdateAfterTraining(Long id) {
        log.info("Rating update after training - {}", System.currentTimeMillis() / 1000);
    }
    @Async
    @Scheduled(fixedRate = 7000 /*25200000*/) // Event is every week (for demonstration - every 7 seconds), but skipping days with event
    public void ratingUpdateAfterEvent(Long id) {
        log.info("Rating update after event - {}", System.currentTimeMillis() / 1000);
    }
    @Scheduled(cron = "0 0 0 1 * ?") // 00:00 of 1st day of every month
    public void ratingUpdateEveryMonth() {
        log.info("Monthly rating update - {}", System.currentTimeMillis() / 1000);
    }
}