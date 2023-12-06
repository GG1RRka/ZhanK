package com.example.demo.repository;

import com.example.demo.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CoachRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoachRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Coach> mapRow() {
        return (rs, rowNum) -> {
            Coach coach = new Coach();
            coach.setId(rs.getLong("id"));
            coach.setName(rs.getString("name"));
            coach.setCountry(rs.getString("country"));
            return coach;
        };
    }

    public List<Coach> findAll() {
        return jdbcTemplate.query("SELECT * FROM coaches", this.mapRow());
    }

    public void insert(Coach coach) {
        jdbcTemplate.update("INSERT INTO coaches (name, country) VALUES (?, ?)", coach.getName(), coach.getCountry());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM coaches WHERE id = ?", id);
    }

    public Coach findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM coaches WHERE id = ?", this.mapRow(), id);
    }

    public List<Coach> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM coaches WHERE name = ?", this.mapRow(), name);
    }

    public List<Coach> findByAttrSurname(String surname) {
        return jdbcTemplate.query("SELECT * FROM coaches WHERE surname = ?", this.mapRow(), surname);
    }

    public List<Coach> findByAttrTeam(Long team_id) {
        return jdbcTemplate.query("SELECT * FROM coaches WHERE team_id = ?", this.mapRow(), team_id);
    }

    public List<Coach> findByAttrCountry(String country) {
        return jdbcTemplate.query("SELECT * FROM coaches WHERE country = ?", this.mapRow(), country);
    }
}