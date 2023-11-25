package com.example.demo.service;

import com.example.demo.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaSingerService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PlayerServiceImpl implements PlayerService {
    final static String ALL_PLAYER_NATIVE_QUERY =
            "select id, name, surname, country from players";

    private Log log = LogFactory.getLog(PlayerServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Player> getPlayers() {
        List<Player> players = em.createNamedQuery(Player.FIND_ALL, Player.class).getResultList();
        return players;
    }

    @Transactional(readOnly = true)
    @Override
    public Player findPlayerById(Long id) {
        Player player = em.createNamedQuery(Player.FIND_BY_ID, Player.class).setParameter("id", id).getSingleResult();
        return player;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Player> findPlayersByName(String name) {
        List<Player> players = em.createNamedQuery(Player.FIND_BY_NAME, Player.class).setParameter("name", name).getResultList();
        return players;
    }
}