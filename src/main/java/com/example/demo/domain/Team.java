package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String country;
    public Long earnings;
    public String currency;
    /*@ElementCollection
    public List<Integer> trainings;*/

    public String print() {
        String result = "ID: " + id + "\n";
        result += "Name: " + name + "\n";
        result += "Country: " + country + "\n";
        result += "Earnings: " + earnings + "\n";
        result += "Currency: " + currency + "\n";
        return result;
    }
}