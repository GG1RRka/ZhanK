package com.example.demo.service;

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
import java.sql.Date;

@Service("matchService")
@Repository
@Transactional
public class MatchServiceImpl implements MatchService {
    final static String ALL_MATCH_NATIVE_QUERY =
            "select id, team1_id, team2_id, stadium_id, timeslot_id, match_date from matches";

    private Log log = LogFactory.getLog(MatchServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Match> getMatches() {
        List<Match> matches = em.createNamedQuery(Match.FIND_ALL, Match.class).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    @Override
    public Match findMatchById(Long id) {
        Match match = em.createNamedQuery(Match.FIND_BY_ID, Match.class).setParameter("id", id).getSingleResult();
        return match;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Match> findMatchesByTeam(Long teamId) {
        List<Match> matches1 = em.createNamedQuery(Match.FIND_BY_TEAM, Match.class).setParameter("team1_id", teamId).getResultList();
        List<Match> matches2 = em.createNamedQuery(Match.FIND_BY_TEAM, Match.class).setParameter("team2_id", teamId).getResultList();
        for (int i = 0; i < matches2.size(); i++) matches1.add(matches2.get(i));
        return matches1;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Match> findMatchesByStadium(Long stadiumId) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_STADIUM, Match.class).setParameter("stadium_id", stadiumId).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Match> findMatchesByTimeslot(Long timeslotId) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_TIME, Match.class).setParameter("timeslot_id", timeslotId).getResultList();
        return matches;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Match> findMatchesByDate(String date) {
        List<Match> matches = em.createNamedQuery(Match.FIND_BY_DATE, Match.class).setParameter("date", date).getResultList();
        return matches;
    }
}