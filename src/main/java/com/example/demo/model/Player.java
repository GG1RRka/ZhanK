package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "player")
@NamedQueries({
        @NamedQuery(name=Player.FIND_ALL, query="SELECT s FROM Player s"),
        @NamedQuery(name=Player.FIND_BY_ID, query="SELECT s FROM Player s WHERE s.id = :id"),
        @NamedQuery(name=Player.FIND_BY_NAME, query="SELECT s FROM Player s WHERE s.name = :name")
})
@SqlResultSetMapping(
        name="playerResult",
        entities=@EntityResult(entityClass=Player.class)
)
public class Player {
    public static final String FIND_ALL = "Player.findAll";
    public static final String FIND_BY_ID = "Player.findById";
    public static final String FIND_BY_NAME = "Player.findByAttrName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String country;
}