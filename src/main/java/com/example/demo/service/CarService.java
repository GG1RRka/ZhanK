package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void insert(Car car) {
        carRepository.insert(car);
    }
    public void delete(Long id) {
        carRepository.delete(id);
    }

    public Car findCarById(Long id) {
        return carRepository.findCarById(id);
    }

    public List<Car> findCarsByName(String name) {
        return carRepository.findByName(name);
    }

    public List<Car> findCarsByCountry(String country) {
        return carRepository.findByCountry(country);
    }

    public List<Car> findCarsByEarnings(Long earnings) {
        return carRepository.findByEarnings(earnings);
    }

    public List<Car> findCarsByCurrency(String currency) {
        return carRepository.findByCurrency(currency);
    }
}