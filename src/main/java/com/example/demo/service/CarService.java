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
    public void update(Long id, Car car) {
        carRepository.update(id, car);
    }

    public Car findCarById(Long id) {
        return carRepository.findCarById(id);
    }

//    public List<Car> findCarsByMake(String make) {
//        return carRepository.findByMake(make);
//    }
//
//    public List<Car> findCarsByModel(String model) {
//        return carRepository.findByModel(model);
//    }
//
//    public List<Car> findCarsByRelease_year(Long release_year) {
//        return carRepository.findByRelease_year(release_year);
//    }
//
//    public List<Car> findCarsByPrice(Long price) {
//        return carRepository.findByPrice(price);
//    }
//
//    public List<Car> findCarsBySeller_id(Long seller_id) {
//        return carRepository.findBySeller_id(seller_id);
//    }

    public List<Car> searchCars(Long seller_id, Float rating, String make, String model, Long release_year_min, Long release_year_max, Long price, String fuel_type, String transmission, Long mileage, String vin_code, Boolean used, String engine_config, Boolean working, String color, String drive_type, String rudder_side, Long owners_number) {
        return carRepository.findByMultipleParameters(seller_id, rating, make, model, release_year_min, release_year_max, price, fuel_type, transmission, mileage, vin_code, used, engine_config, working, color, drive_type, rudder_side, owners_number);
    }
}