package com.example.demo.repository;

import com.example.demo.model.Result;
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
public class ResultRepository {
    final static String ALL_RESULT_NATIVE_QUERY =
            "select id, team1_score, team2_score, winner_id from results";

    private Log log = LogFactory.getLog(ResultRepository.class);

    @PersistenceContext
    private EntityManager em;

    //@Transactional(readOnly = true)
    public List<Result> findAll() {
        List<Result> matches = em.createQuery(Result.FIND_ALL, Result.class).getResultList();
        return matches;
    }

    @Transactional
    public void insert(Result result) {
        em.createNamedQuery(Result.INSERT, Result.class).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Result.DELETE, Result.class).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Result findById(Long id) {
        Result result = em.createNamedQuery(Result.FIND_BY_ID, Result.class).getSingleResult();
        return result;
    }

    @Transactional(readOnly = true)
    public List<Result> findByAttrMinScore(Long score) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_MIN_SCORE, Result.class).getResultList();
        return results;
    }

    @Transactional(readOnly = true)
    public List<Result> findByAttrMaxScore(Long score) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_MAX_SCORE, Result.class).getResultList();
        return results;
    }

    @Transactional(readOnly = true)
    public List<Result> findByAttrWinner(Long winner_id) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_WINNER, Result.class).getResultList();
        return results;
    }
}