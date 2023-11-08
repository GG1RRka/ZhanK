package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Player> mapRow() {
        return (rs, rowNum) -> {
            Player player = new Player();
            player.setId(rs.getLong("id"));
            player.setName(rs.getString("name"));
            player.setSurname(rs.getString("surname"));
            player.setCountry(rs.getString("country"));
            return player;
        };
    }

    public List<Player> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM players", this.mapRow());
    }

    public void insert(Player player) {
        jdbcTemplate.update("INSERT INTO players (name, surname, country) VALUES (?, ?, ?)", player.getName(), player.getSurname(), player.getCountry());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM players WHERE id = ?", id);
    }

    public Player findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM players WHERE id = ?", this.mapRow(), id);
    }

    public List<Player> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM players WHERE name = ?", this.mapRow(), name);
    }

    public List<Player> findByAttrSurname(String surname) {
        return jdbcTemplate.query("SELECT * FROM players WHERE surname = ?", this.mapRow(), surname);
    }

    public List<Player> findByAttrCountry(String country) {
        return jdbcTemplate.query("SELECT * FROM players WHERE country = ?", this.mapRow(), country);
    }
}