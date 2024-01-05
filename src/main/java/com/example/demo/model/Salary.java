package com.example.demo.model;
import jakarta.persistence.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table(name = "salaries")
@NamedQueries({
//        @NamedQuery(name=Salary.INSERT, query="INSERT INTO Salary (id, value, currency, team_id) VALUES (?, ?, ?, ?)"),
//        @NamedQuery(name=Salary.DELETE, query="DELETE FROM Salary WHERE id = ?"),
        @NamedQuery(name=Salary.FIND_ALL, query="SELECT s FROM Salary s"),
        @NamedQuery(name=Salary.FIND_BY_ID, query="SELECT s FROM Salary s WHERE s.id = :id"),
        @NamedQuery(name=Salary.FIND_BY_VALUE, query="SELECT s FROM Salary s WHERE s.value = :value"),
        @NamedQuery(name=Salary.FIND_BY_CURRENCY, query="SELECT s FROM Salary s WHERE s.currency = :currency"),
        @NamedQuery(name=Salary.FIND_BY_TEAM, query="SELECT s FROM Salary s WHERE s.team_id = :team_id")
})
@SqlResultSetMapping(
        name="salaryResult",
        entities=@EntityResult(entityClass=Salary.class)
)
public class Salary {
    public static final String INSERT = "Salary.insert";
    public static final String DELETE = "Salary.delete";
    public static final String FIND_ALL = "Salary.findAll";
    public static final String FIND_BY_ID = "Salary.findById";
    public static final String FIND_BY_VALUE = "Salary.findByAttrValue";
    public static final String FIND_BY_CURRENCY = "Salary.findByAttrCurrency";
    public static final String FIND_BY_TEAM = "Salary.findByAttrTeam";

    @Id
    @GeneratedValue
    private Long id;
    private Long value;
    private String currency;
    private Long team_id;
}