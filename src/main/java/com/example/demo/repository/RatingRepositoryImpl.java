package com.example.demo.repository;

import com.example.demo.model.Rating;
import com.example.demo.model.Salary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RatingRepositoryImpl {
    final static String ALL_RATING_NATIVE_QUERY =
            "select id, \"value\", assignTime, team_id from ratings";

    private Log log = LogFactory.getLog(RatingRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Rating> findAll() {
        List<Rating> ratings = em.createNamedQuery(Rating.FIND_ALL, Rating.class).getResultList();
        return ratings;
    }

    @Transactional
    public void insert(Rating rating) {
        em.createNamedQuery(Rating.INSERT, Rating.class).setParameter("rating", rating).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Rating.DELETE, Rating.class).setParameter("id", id).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Rating findRatingById(Long id) {
        Rating rating = em.createNamedQuery(Rating.FIND_BY_ID, Rating.class).setParameter("id", id).getSingleResult();
        return rating;
    }

    @Transactional(readOnly = true)
    public List<Rating> findByAttrValue(Long value) {
        List<Rating> ratings = em.createNamedQuery(Rating.FIND_BY_VALUE, Rating.class).setParameter("value", value).getResultList();
        return ratings;
    }

    @Transactional(readOnly = true)
    public List<Rating> findByAttrAssignTime(Long assignTime) {
        List<Rating> ratings = em.createNamedQuery(Rating.FIND_BY_TIME, Rating.class).setParameter("assignTime", assignTime).getResultList();
        return ratings;
    }

    @Transactional(readOnly = true)
    public List<Rating> findByAttrTeam(Long team_id) {
        List<Rating> ratings = em.createNamedQuery(Rating.FIND_BY_TEAM, Rating.class).setParameter("team_id", team_id).getResultList();
        return ratings;
    }

    @Transactional(readOnly = true)
    public List<Rating> changeValue(Long value) {
        List<Rating> ratings = em.createNamedQuery(Rating.CHANGE_VALUE, Rating.class).getResultList();
        return ratings;
    }

    @Transactional(readOnly = true)
    public List<Rating> changeAssignTime(Long assignTime) {
        List<Rating> ratings = em.createNamedQuery(Rating.CHANGE_TIME, Rating.class).getResultList();
        return ratings;
    }
}