package com.example.demo.repository;

import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class TeamRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeamRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Team> mapRow() {
        return (rs, rowNum) -> {
            Team team = new Team();
            team.setId(rs.getLong("id"));
            team.setName(rs.getString("name"));
            team.setCountry(rs.getString("country"));
            return team;
        };
    }

    public List<Team> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM teams", this.mapRow());
    }

    public void insert(Team team) {
        jdbcTemplate.update("INSERT INTO teams (name, country) VALUES (?, ?)", team.getName(), team.getCountry());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM teams WHERE id = ?", id);
    }

    public Team findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM teams WHERE id = ?", this.mapRow(), id);
    }

    public List<Team> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM teams WHERE name = ?", this.mapRow(), name);
    }

    public List<Team> findByAttrCountry(String country) {
        return jdbcTemplate.query("SELECT * FROM teams WHERE country = ?", this.mapRow(), country);
    }
}