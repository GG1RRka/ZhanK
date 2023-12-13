package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "players")
@NamedQueries({
        @NamedQuery(name=Player.FIND_ALL, query="SELECT s FROM Player s"),
        @NamedQuery(name=Player.INSERT, query="INSERT INTO Player (id, name, surname, country) VALUES (?, ?, ?, ?)"),
        @NamedQuery(name=Player.DELETE, query="DELETE FROM Player WHERE id = ?"),
        @NamedQuery(name=Player.FIND_BY_ID, query="SELECT s FROM Player s WHERE s.id = :id"),
        @NamedQuery(name=Player.FIND_BY_NAME, query="SELECT s FROM Player s WHERE s.name = :name"),
        @NamedQuery(name=Player.FIND_BY_SURNAME, query="SELECT s FROM Player s WHERE s.surname = :surname"),
        @NamedQuery(name=Player.FIND_BY_COUNTRY, query="SELECT s FROM Player s WHERE s.country = :country")
})
@SqlResultSetMapping(
        name="playerResult",
        entities=@EntityResult(entityClass=Player.class)
)
public class Player {
    public static final String FIND_ALL = "Player.getPlayers";
    public static final String INSERT = "Player.insert";
    public static final String DELETE = "Player.delete";
    public static final String FIND_BY_ID = "Player.findPlayerById";
    public static final String FIND_BY_NAME = "Player.findPlayersByAttrName";
    public static final String FIND_BY_SURNAME = "Player.findPlayersByAttrSurname";
    public static final String FIND_BY_COUNTRY = "Player.findPlayersByAttrCountry";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String country;
}