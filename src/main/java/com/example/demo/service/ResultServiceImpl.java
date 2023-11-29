package com.example.demo.service;

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

@Service("jpaResultService")
@Repository
@Transactional
public class ResultServiceImpl implements ResultService {
    final static String ALL_RESULT_NATIVE_QUERY =
            "select id, team1_score, team2_score, winner_id from results";

    private Log log = LogFactory.getLog(ResultServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Result> getResults() {
        List<Result> results = em.createNamedQuery(Result.FIND_ALL, Result.class).getResultList();
        return results;
    }

    @Transactional(readOnly = true)
    @Override
    public Result findResultById(Long id) {
        Result result = em.createNamedQuery(Result.FIND_BY_ID, Result.class).setParameter("id", id).getSingleResult();
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Result> findResultsByMinScore(Long score) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_MIN_SCORE, Result.class).getResultList();
        return results;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Result> findResultsByMaxScore(Long score) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_MAX_SCORE, Result.class).getResultList();
        return results;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Result> findResultsByWinner(Long winner_id) {
        List<Result> results = em.createNamedQuery(Result.FIND_BY_WINNER, Result.class).getResultList();
        return results;
    }
}