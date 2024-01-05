package com.example.demo.service;

import com.example.demo.model.Salary;
import com.example.demo.repository.SalaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    public List<Salary> getSalaries() {
        return salaryRepository.findAll();
    }

    public Salary findSalaryById(Long id) {
        return salaryRepository.findSalaryById(id);
    }

    public List<Salary> findSalariesByName(Long value) {
        return salaryRepository.findByAttrValue(value);
    }

    public List<Salary> findSalariesByCurrency(String currency) {
        return salaryRepository.findByAttrCurrency(currency);
    }

    public List<Salary> findSalariesByTeam(Long team_id) {
        return salaryRepository.findByAttrTeam(team_id);
    }
}