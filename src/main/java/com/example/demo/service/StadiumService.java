package com.example.demo.service;

import com.example.demo.model.Stadium;
import com.example.demo.repository.StadiumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class StadiumService {

    private StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public List<Stadium> getStadiums() {
        try {
            return stadiumRepository.findAll();
        } catch (SQLException e) {
            log.error("Error getting stadium: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addStadium(Stadium stadium) {
        try {
            stadiumRepository.insert(stadium);
        } catch (Exception e) {
            log.error("Error adding stadium: {}", e.getMessage(), e);
        }
    }

    public void deleteStadium(Long id) {
        try {
            stadiumRepository.delete(id);
        } catch (Exception e) {
            log.error("Error deleting stadium: {}", e.getMessage(), e);
        }
    }

    public Stadium findStadiumById(Long id) {
        try {
            return stadiumRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding stadium: {}", e.getMessage(), e);
            return new Stadium();
        }
    }

    public List<Stadium> findStadiumsByName(String name) {
        try {
            return stadiumRepository.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding stadiums: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Stadium> findStadiumsByCity(String city) {
        try {
            return stadiumRepository.findByAttrCity(city);
        } catch (Exception e) {
            log.error("Error finding stadiums: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Stadium> findStadiumsByCountry(String country) {
        try {
            return stadiumRepository.findByAttrCountry(country);
        } catch (Exception e) {
            log.error("Error finding stadiums: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}