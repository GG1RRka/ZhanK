package com.example.demo.service;

import com.example.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    public List<Player> getPlayers();
    public Player findPlayerById(Long id);
    public List<Player> findPlayersByName(String name);
}