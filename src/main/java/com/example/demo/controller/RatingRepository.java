package com.example.demo.repository;

import com.example.demo.model.Rating;
import com.example.demo.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAll();
    void insert(Rating rating);
    void delete(Long id);
    Rating findRatingById(Long id);
    List<Rating> findByAttrValue(Double value);
    List<Rating> findByAttrAssignTime(Double assignTime);
    List<Rating> findByAttrTeam(Long team_id);
    void changeValue(Long id, Double value);
    void changeAssignTime(Long id, Double assignTime);
}