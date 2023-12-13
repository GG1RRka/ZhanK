package com.example.demo.repository;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    final static String ALL_PLAYER_NATIVE_QUERY =
            "select id, name, surname, country from players";

    private Log log = LogFactory.getLog(PlayerRepository.class);

    @PersistenceContext
    private EntityManager em;

    //@Transactional(readOnly = true)
    public List<Player> findAll() {
        List<Player> players = em.createQuery(Player.FIND_ALL, Player.class).getResultList();
        return players;
    }

    @Transactional
    public void insert(Player player) {
        em.createNamedQuery(Player.INSERT, Player.class).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Player.DELETE, Player.class).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Player findById(Long id) {
        Player player = em.createNamedQuery(Player.FIND_BY_ID, Player.class).getSingleResult();
        return player;
    }

    @Transactional(readOnly = true)
    public List<Player> findByAttrName(String name) {
        List<Player> players = em.createNamedQuery(Player.FIND_BY_NAME, Player.class).getResultList();
        return players;
    }

    @Transactional(readOnly = true)
    public List<Player> findByAttrSurname(String surname) {
        List<Player> players = em.createNamedQuery(Player.FIND_BY_SURNAME, Player.class).getResultList();
        return players;
    }

    @Transactional(readOnly = true)
    public List<Player> findByAttrCountry(String country) {
        List<Player> players = em.createNamedQuery(Player.FIND_BY_COUNTRY, Player.class).getResultList();
        return players;
    }
}