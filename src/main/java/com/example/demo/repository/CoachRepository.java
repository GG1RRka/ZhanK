package com.example.demo.repository;

import com.example.demo.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    @Query("SELECT s FROM Coach s WHERE s.id = :id")
    Optional<Coach> findById(@Param("id") Long id);
    @Query("SELECT s FROM Coach s WHERE s.name = :name")
    List<Coach> findByName(@Param("name") String name);
    @Query("SELECT s FROM Coach s WHERE s.surname = :surname")
    List<Coach> findBySurname(@Param("surname") String surname);
    @Query("SELECT s FROM Coach s WHERE s.team_id = :team_id")
    List<Coach> findByTeam(@Param("team") Long team_id);

    @Query("SELECT s FROM Coach s WHERE s.country = :country")
    List<Coach> findByCountry(@Param("country") String country);


    @Query(value = "SELECT * FROM Coach s", nativeQuery = true)
    List<Coach> findAllCoachesNative();
}