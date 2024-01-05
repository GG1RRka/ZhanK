package com.example.demo.repository;

import com.example.demo.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findAll();
    void insert(Salary salary);
    void delete(Long id);
    Salary findSalaryById(Long id);
    List<Salary> findByAttrValue(Long value);
    List<Salary> findByAttrCurrency(String currency);
    List<Salary> findByAttrTeam(Long team_id);
}