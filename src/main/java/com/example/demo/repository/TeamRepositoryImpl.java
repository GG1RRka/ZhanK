package com.example.demo.repository;

import com.example.demo.model.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TeamRepositoryImpl {
    final static String ALL_TEAM_NATIVE_QUERY =
            "select id, \"value\", currency, team_id from teams";

    private Log log = LogFactory.getLog(TeamRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Team> findAll() {
        List<Team> teams = em.createNamedQuery(Team.FIND_ALL, Team.class).getResultList();
        return teams;
    }

    @Transactional
    public void insert(Team team) {
        em.createNamedQuery(Team.INSERT, Team.class).setParameter("team", team).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Team.DELETE, Team.class).setParameter("id", id).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Team findTeamById(Long id) {
        Team team = em.createNamedQuery(Team.FIND_BY_ID, Team.class).setParameter("id", id).getSingleResult();
        return team;
    }

    @Transactional(readOnly = true)
    public List<Team> findByAttrName(String name) {
        List<Team> teams = em.createNamedQuery(Team.FIND_BY_NAME, Team.class).setParameter("name", name).getResultList();
        return teams;
    }

    @Transactional(readOnly = true)
    public List<Team> findByAttrCountry(String country) {
        List<Team> teams = em.createNamedQuery(Team.FIND_BY_COUNTRY, Team.class).setParameter("country", country).getResultList();
        return teams;
    }
    public void addTraining(Team team, Integer x) {
        team.trainings.add(x);
    }
    public List<Integer> getTrainingList(Team team) {
        return team.trainings;
    }
}