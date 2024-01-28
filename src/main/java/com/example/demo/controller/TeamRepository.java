package com.example.demo.repository;

import com.example.demo.model.Salary;
import com.example.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAll();
    void insert(Team team);
    void delete(Long id);
    Team findTeamById(Long id);
    List<Team> findByAttrName(String name);
    List<Team> findByAttrCountry(String country);
    List<Team> findByAttrEarnings(Long totalEarnings);
    List<Team> findByAttrCurrency(String currency);
    List<Team> addTraining(Team team, Integer x);
    List<Integer> getTrainingList(Team team);
}