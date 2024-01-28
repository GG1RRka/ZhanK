package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    void insert(Car car);
    void delete(Long id);
    Car findCarById(Long id);
    List<Car> findByName(String name);
    List<Car> findByCountry(String country);
    List<Car> findByEarnings(Long earnings);
    List<Car> findByCurrency(String currency);
}