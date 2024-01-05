package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Table(name = "teams")
@NamedQueries({
        @NamedQuery(name=Team.INSERT, query="INSERT INTO Team (id, name, country, totalEarnings, currency) VALUES (:id, :name, :country, :totalEarnings, :currency)"),
        @NamedQuery(name=Team.DELETE, query="DELETE FROM Team WHERE id = :id"),
        @NamedQuery(name=Team.FIND_ALL, query="SELECT t FROM Team t"),
        @NamedQuery(name=Team.FIND_BY_ID, query="SELECT t FROM Team t WHERE t.id = :id"),
        @NamedQuery(name=Team.FIND_BY_NAME, query="SELECT t FROM Team t WHERE t.name = :name"),
        @NamedQuery(name=Team.FIND_BY_COUNTRY, query="SELECT t FROM Team t WHERE t.country = :country"),
        @NamedQuery(name=Team.FIND_BY_EARNINGS, query="SELECT t FROM Team t WHERE t.totalEarnings = :totalEarnings"),
        @NamedQuery(name=Team.FIND_BY_CURRENCY, query="SELECT t FROM Team t WHERE t.currency = :currency"),
})
@SqlResultSetMapping(
        name="teamResult",
        entities=@EntityResult(entityClass=Team.class)
)
public class Team {
    public static final String INSERT = "Team.insert";
    public static final String DELETE = "Team.delete";
    public static final String FIND_ALL = "Team.findAll";
    public static final String FIND_BY_ID = "Team.findTeamById";
    public static final String FIND_BY_NAME = "Team.findByAttrName";
    public static final String FIND_BY_COUNTRY = "Team.findByAttrCountry";
    public static final String FIND_BY_EARNINGS = "Team.findByAttrEarnings";
    public static final String FIND_BY_CURRENCY = "Team.findByAttrCurrency";
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private Long totalEarnings;
    private String currency;
    @ElementCollection
    public List<Integer> trainings;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public Long getEarnings() {
        return totalEarnings;
    }
    public String getCurrency() {
        return currency;
    }
}