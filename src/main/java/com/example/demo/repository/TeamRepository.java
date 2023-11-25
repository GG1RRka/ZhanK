package com.example.demo.repository;

import com.example.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT s FROM Team s WHERE s.id = :id")
    Optional<Team> findById(@Param("id") Long id);
    @Query("SELECT s FROM Team s WHERE s.name = :name")
    List<Team> findByName(@Param("name") String name);

    @Query("SELECT s FROM Team s WHERE s.country = :country")
    List<Team> findByCountry(@Param("country") String country);


    @Query(value = "SELECT * FROM Team s", nativeQuery = true)
    List<Team> findAllTeamsNative();
}