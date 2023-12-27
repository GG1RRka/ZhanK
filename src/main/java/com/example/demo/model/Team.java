package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
@Slf4j
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private Long totalEarnings;
    @ElementCollection
    public List<Integer> trainingsCount;
}