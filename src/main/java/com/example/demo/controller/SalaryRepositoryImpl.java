package com.example.demo.repository;

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
public class SalaryRepositoryImpl {
    final static String ALL_SALARY_NATIVE_QUERY =
            "select id, theValue, currency, team_id from salaries";

    private Log log = LogFactory.getLog(SalaryRepository.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Salary> findAll() {
        List<Salary> salaries = em.createNamedQuery(Salary.FIND_ALL, Salary.class).getResultList();
        return salaries;
    }

    @Transactional
    public void insert(Salary salary) {
        em.createNamedQuery(Salary.INSERT, Salary.class).setParameter("salary", salary).executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        em.createNamedQuery(Salary.DELETE, Salary.class).setParameter("id", id).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Salary findSalaryById(Long id) {
        Salary salary = em.createNamedQuery(Salary.FIND_BY_ID, Salary.class).setParameter("id", id).getSingleResult();
        return salary;
    }

    @Transactional(readOnly = true)
    public List<Salary> findByAttrValue(Long value) {
        List<Salary> salaries = em.createNamedQuery(Salary.FIND_BY_VALUE, Salary.class).setParameter("value", value).getResultList();
        return salaries;
    }

    @Transactional(readOnly = true)
    public List<Salary> findByAttrCurrency(String currency) {
        List<Salary> salaries = em.createNamedQuery(Salary.FIND_BY_CURRENCY, Salary.class).setParameter("currency", currency).getResultList();
        return salaries;
    }

    @Transactional(readOnly = true)
    public List<Salary> findByAttrTeam(Long team_id) {
        List<Salary> salaries = em.createNamedQuery(Salary.FIND_BY_TEAM, Salary.class).setParameter("team_id", team_id).getResultList();
        return salaries;
    }
}