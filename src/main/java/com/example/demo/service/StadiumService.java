package com.example.demo.service;

import com.example.demo.model.Stadium;
import com.example.demo.repository.StadiumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;
    public List<Stadium> getStadiums() {
        return stadiumRepository.findAllStadiumsNative();
    }

    public Optional<Stadium> findStadiumById(Long id) {
        return stadiumRepository.findById(id);
    }

    public List<Stadium> findStadiumsByName(String name) {
        return stadiumRepository.findByName(name);
    }

    public List<Stadium> findStadiumsByCity(String city) {
        return stadiumRepository.findByCity(city);
    }

    public List<Stadium> findStadiumsByCountry(String country) {
        return stadiumRepository.findByCountry(country);
    }
}