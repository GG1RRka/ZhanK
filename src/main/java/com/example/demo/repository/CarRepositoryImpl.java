package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CarRepositoryImpl {

    private Log log = LogFactory.getLog(CarRepositoryImpl.class);
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(Car car) {
        em.persist(car);
    }

    @Transactional
    public void delete(Long id) {
        Car car = em.find(Car.class, id);
        if (car != null) {
            em.remove(car);
        }
    }

    @Transactional(readOnly = true)
    public Car findCarById(Long id) {
        return em.find(Car.class, id);
    }

    @Transactional(readOnly = true)
    public List<Car> findByName(String name) {
        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.name = :name", Car.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Car> findByCountry(String country) {
        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.country = :country", Car.class);
        query.setParameter("country", country);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Car> findByEarnings(Long earnings) {
        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.earnings = :earnings", Car.class);
        query.setParameter("earnings", earnings);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Car> findByCurrency(String currency) {
        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.currency = :currency", Car.class);
        query.setParameter("currency", currency);
        return query.getResultList();
    }
}
