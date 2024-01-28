package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends JpaRepository<Car, Long> {
    void insert(Car car);
    void update(@Param("id") Long id, Car car);
    void delete(@Param("id") Long id);
    List<Car> findAll();
    Car findCarById(@Param("id") Long id);
    //    List<Car> findByMake(@Param("make") String make);
//    List<Car> findByModel(@Param("model") String model);
//    List<Car> findByRelease_year(@Param("release_year") Long release_year);
//    List<Car> findByPrice(@Param("price") Long price);
//    List<Car> findBySeller_id(@Param("seller_id") Long seller_id);
    @Query("SELECT c FROM Car c WHERE " +
            "(:seller_id IS NULL OR c.seller_id = :seller_id) AND " +
            "(:rating IS NULL OR c.rating >= :rating) AND " +
            "(:make IS NULL OR c.make = :make) AND " +
            "(:model IS NULL OR c.model = :model) AND " +
            "(:release_year_min IS NULL OR c.release_year >= :release_year_min) AND " +
            "(:release_year_max IS NULL OR c.release_year <= :release_year_max) AND " +
            "(:price IS NULL OR c.price = :price) AND " +
            "(:fuel_type IS NULL OR c.fuel_type = :fuel_type) AND " +
            "(:transmission IS NULL OR c.transmission = :transmission) AND " +
            "(:mileage IS NULL OR c.mileage = :mileage) AND " +
            "(:vin_code IS NULL OR c.vin_code = :vin_code) AND " +
            "(:used IS NULL OR c.used = :used) AND " +
            "(:engine_config IS NULL OR c.engine_config = :engine_config) AND " +
            "(:working IS NULL OR c.working = :working) AND " +
            "(:color IS NULL OR c.color = :color) AND " +
            "(:drive_type IS NULL OR c.drive_type = :drive_type) AND " +
            "(:rudder_side IS NULL OR c.rudder_side = :rudder_side) AND " +
            "(:owners_number IS NULL OR c.owners_number = :owners_number)")
    List<Car> findByMultipleParameters(
            @Param("seller_id") Long seller_id,
            @Param("rating") Float rating,
            @Param("make") String make,
            @Param("model") String model,
            @Param("release_year_min") Long release_year_min,
            @Param("release_year_max") Long release_year_max,
            @Param("price") Long price,
            @Param("fuel_type") String fuel_type,
            @Param("transmission") String transmission,
            @Param("mileage") Long mileage,
            @Param("vin_code") String vin_code,
            @Param("used") Boolean used,
            @Param("engine_config") String engine_config,
            @Param("working") Boolean working,
            @Param("color") String color,
            @Param("drive_type") String drive_type,
            @Param("rudder_side") String rudder_side,
            @Param("owners_number") Long owners_number
    );

}