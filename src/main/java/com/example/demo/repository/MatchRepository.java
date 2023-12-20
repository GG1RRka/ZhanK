package com.example.demo.repository;

import com.example.demo.model.Match;
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
public class MatchRepository {
    final static String ALL_MATCH_NATIVE_QUERY =
            "select id, team1_id, team2_id, stadium_id, timeslot_id, match_date from matches";

    private Log log = LogFactory.getLog(PlayerRepository.class);

    @PersistenceContext
    private EntityManager em;

    //@Transactional(readOnly = true)
    public List<Match> findAll() {
        List<Match> matches = em.createQuery(Match.FIND_ALL, Match.class).getResultList();
        return matches;
    }

    @Transactional
    public void insert(Match match) {
        em.createNamedQuery(Match.INSERT, Match.class).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Match.DELETE, Match.class).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Match findById(Long id) {
        Match match = em.createNamedQuery(Match.FIND_BY_ID, Match.class).getSingleResult();
        return match;
    }

    @Transactional(readOnly = true)
    public List<Match> findByAttrTeam(Long team_id) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_TEAM, Match.class).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    public List<Match> findByAttrStadium(Long stadium_id) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_STADIUM, Match.class).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    public List<Match> findByAttrTime(Long timeslotId) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_TIME, Match.class).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    public List<Match> findByAttrDate(String date) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_DATE, Match.class).getResultList();
        return matches;
    }
}