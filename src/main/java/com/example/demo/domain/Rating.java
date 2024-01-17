package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double value;
    public Double time;
    public Long team_id;

    public String print() {
        String result = "ID: " + id + "\n";
        result += "Name: " + value + "\n";
        result += "Time: " + time + "\n";
        result += "Team: " + team_id + "\n";
        return result;
    }
}