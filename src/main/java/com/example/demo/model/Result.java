package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.sql.Date;

@Entity
@Table(name = "Result")
@NamedQueries({
        @NamedQuery(name=Result.FIND_ALL, query="SELECT s FROM Result s"),
        @NamedQuery(name=Result.FIND_BY_ID, query="SELECT s FROM Result s WHERE s.id = :id"),
        @NamedQuery(name=Result.FIND_BY_MIN_SCORE, query="SELECT s FROM Result s WHERE (s.team1_score <= s.team2_score AND s.team1_score = :score) OR (s.team1_score >= s.team2_score AND s.team2_score = :score)"),
        @NamedQuery(name=Result.FIND_BY_MAX_SCORE, query="SELECT s FROM Result s WHERE (s.team1_score >= s.team2_score AND s.team1_score = :score) OR (s.team1_score <= s.team2_score AND s.team2_score = :score)"),
        @NamedQuery(name=Result.FIND_BY_WINNER, query="SELECT s FROM Result s WHERE s.winner_id = :winner_id"),
})
@SqlResultSetMapping(
        name="resultResult",
        entities=@EntityResult(entityClass=Result.class)
)
public class Result {
    public static final String FIND_ALL = "Result.findAll";
    public static final String FIND_BY_ID = "Result.findById";
    public static final String FIND_BY_MIN_SCORE = "Result.findByAttrMin";
    public static final String FIND_BY_MAX_SCORE = "Result.findByAttrMax";
    public static final String FIND_BY_WINNER = "Result.findByAttrWinner";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long team1_score;
    private long team2_score;
    private long winner_id;
}