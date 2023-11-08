package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        try {
            return playerRepository.findAll();
        } catch (SQLException e) {
            log.error("Error getting player: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addPlayer(Player player) {
        try {
            playerRepository.insert(player);
        } catch (Exception e) {
            log.error("Error adding player: {}", e.getMessage(), e);
        }
    }

    public void deletePlayer(Long id) {
        try {
            playerRepository.delete(id);
        } catch (Exception e) {
            log.error("Error deleting player: {}", e.getMessage(), e);
        }
    }

    public Player findPlayerById(Long id) {
        try {
            return playerRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding player: {}", e.getMessage(), e);
            return new Player();
        }
    }

    public List<Player> findPlayersByName(String name) {
        try {
            return playerRepository.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Player> findPlayersBySurname(String surname) {
        try {
            return playerRepository.findByAttrSurname(surname);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Player> findPlayersByCountry(String country) {
        try {
            return playerRepository.findByAttrCountry(country);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}