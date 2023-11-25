package com.example.demo.service;

import com.example.demo.model.Timeslot;
import com.example.demo.repository.TimeslotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TimeslotService {

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    public TimeslotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    public List<Timeslot> getTimeslots() {
        try {
            return timeslotRepository.findAll();
        } catch (SQLException e) {
            log.error("Error getting timeslot: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addTimeslot(Timeslot timeslot) {
        try {
            timeslotRepository.insert(timeslot);
        } catch (Exception e) {
            log.error("Error adding timeslot: {}", e.getMessage(), e);
        }
    }

    public void deleteTimeslot(Long id) {
        try {
            timeslotRepository.delete(id);
        } catch (Exception e) {
            log.error("Error deleting timeslot: {}", e.getMessage(), e);
        }
    }

    public Timeslot findTimeslotById(Long id) {
        try {
            return timeslotRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding timeslot: {}", e.getMessage(), e);
            return new Timeslot();
        }
    }

    public List<Timeslot> findTimeslotsByTime(String starttime) {
        try {
            return timeslotRepository.findByAttrTime(starttime);
        } catch (Exception e) {
            log.error("Error finding timeslots: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}