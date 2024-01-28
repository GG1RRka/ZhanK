package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long seller_id;
    public Float rating;
    public String make;
    public String model;
    public Long release_year;
    public Long price;
    public String fuel_type;
    public String transmission;
    public Long mileage;
    public String vin_code;
    public Boolean used;
    public String engine_config;
    public Boolean working;
    public String color;
    public String drive_type;
    public String rudder_side;
    public Long owners_number;
}