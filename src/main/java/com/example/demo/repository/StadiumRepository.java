package com.example.demo.repository;

import com.example.demo.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    @Query("SELECT s FROM Stadium s WHERE s.id = :id")
    Optional<Stadium> findById(@Param("id") Long id);
    @Query("SELECT s FROM Stadium s WHERE s.name = :name")
    List<Stadium> findByName(@Param("name") String name);
    @Query("SELECT s FROM Stadium s WHERE s.city = :city")
    List<Stadium> findByCity(@Param("city") String city);

    @Query("SELECT s FROM Stadium s WHERE s.country = :country")
    List<Stadium> findByCountry(@Param("country") String country);

    @Query(value = "SELECT * FROM Stadium s", nativeQuery = true)
    List<Stadium> findAllStadiumsNative();
}