package com.example.demo.repository;

import com.example.demo.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaryRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalaryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Salary> mapRow() {
        return (rs, rowNum) -> {
            Salary salary = new Salary();
            salary.setId(rs.getLong("id"));
            salary.setValue(rs.getLong("value"));
            salary.setCurrency(rs.getString("currency"));
            salary.setTeam_id(rs.getLong("team_id"));
            return salary;
        };
    }

    public List<Salary> findAll() {
        return jdbcTemplate.query("SELECT * FROM salaries", this.mapRow());
    }

    public void insert(Salary salary) {
        jdbcTemplate.update("INSERT INTO salaries (value, currency, team_id) VALUES (?, ?, ?)", salary.getValue(), salary.getCurrency(), salary.getTeam_id());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM salaries WHERE id = ?", id);
    }

    public Salary findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM salaries WHERE id = ?", this.mapRow(), id);
    }

    public List<Salary> findByAttrValue(Long value) {
        return jdbcTemplate.query("SELECT * FROM salaries WHERE value = ?", this.mapRow(), value);
    }

    public List<Salary> findByAttrCurrency(String currency) {
        return jdbcTemplate.query("SELECT * FROM salaries WHERE currency = ?", this.mapRow(), currency);
    }

    public List<Salary> findByAttrTeam_id(Long team_id) {
        return jdbcTemplate.query("SELECT * FROM salaries WHERE team_id = ?", this.mapRow(), team_id);
    }
}