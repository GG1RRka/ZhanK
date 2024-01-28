package com.example.demo.repository;

import com.example.demo.domain.Car;
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
    public List<Car> findAll() {
        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t", Car.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Car findCarById(Long id) {
        return em.find(Car.class, id);
    }

    @Transactional
    public void update(Long id, Car car) {
        Car oldCar = findCarById(id);
        if (oldCar == null) return;
        em.merge(car);
    }

//    @Transactional(readOnly = true)
//    public List<Car> findByMake(String make) {
//        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.make = :make", Car.class);
//        query.setParameter("make", make);
//        return query.getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    public List<Car> findByModel(String model) {
//        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.model = :model", Car.class);
//        query.setParameter("model", model);
//        return query.getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    public List<Car> findByRelease_year(Long release_year) {
//        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.release_year = :release_year", Car.class);
//        query.setParameter("release_year", release_year);
//        return query.getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    public List<Car> findByPrice(Long price) {
//        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.price = :price", Car.class);
//        query.setParameter("price", price);
//        return query.getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    public List<Car> findBySeller_id(Long seller_id) {
//        TypedQuery<Car> query = em.createQuery("SELECT t FROM Car t WHERE t.seller_id = :seller_id", Car.class);
//        query.setParameter("seller_id", seller_id);
//        return query.getResultList();
//    }

}
