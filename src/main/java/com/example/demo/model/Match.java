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
@Table(name = "matches")
@NamedQueries({
        @NamedQuery(name=Match.FIND_ALL, query="SELECT s FROM Match s"),
        @NamedQuery(name=Match.FIND_BY_ID, query="SELECT s FROM Match s WHERE s.id = :id"),
        @NamedQuery(name=Match.FIND_BY_TEAM, query="SELECT s FROM Match s WHERE s.team1_id = :team_id OR s.team2_id = :team_id"),
        @NamedQuery(name=Match.FIND_BY_STADIUM, query="SELECT s FROM Match s WHERE s.stadium_id = :stadium_id"),
        @NamedQuery(name=Match.FIND_BY_TIME, query="SELECT s FROM Match s WHERE s.timeslot_id = :timeslot_id"),
        @NamedQuery(name=Match.FIND_BY_DATE, query="SELECT s FROM Match s WHERE s.match_date = :match_date")
})
@SqlResultSetMapping(
        name="matchResult",
        entities=@EntityResult(entityClass=Match.class)
)
public class Match {
    public static final String FIND_ALL = "Match.findAll";
    public static final String FIND_BY_ID = "Match.findById";
    public static final String FIND_BY_TEAM = "Match.findByAttrTeam";
    public static final String FIND_BY_STADIUM = "Match.findByAttrStadium";
    public static final String FIND_BY_TIME = "Match.findByAttrTime";
    public static final String FIND_BY_DATE = "Match.findByAttrDate";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long team1_id;
    private long team2_id;
    private long stadium_id;
    private long timeslot_id;
    private String match_date;
}