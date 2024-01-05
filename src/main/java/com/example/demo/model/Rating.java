package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ratings")
@NamedQueries({
//        @NamedQuery(name=Rating.INSERT, query="INSERT INTO Rating (id, value, assignTime, team_id) VALUES (?, ?, ?, ?)"),
//        @NamedQuery(name=Rating.DELETE, query="DELETE FROM Rating WHERE id = ?"),
        @NamedQuery(name=Rating.FIND_ALL, query="SELECT r FROM Rating r"),
        @NamedQuery(name=Rating.FIND_BY_ID, query="SELECT r FROM Rating r WHERE r.id = :id"),
        @NamedQuery(name=Rating.FIND_BY_VALUE, query="SELECT r FROM Rating r WHERE r.value = :value"),
        @NamedQuery(name=Rating.FIND_BY_TIME, query="SELECT r FROM Rating r WHERE r.assignTime = :assignTime"),
        @NamedQuery(name=Rating.FIND_BY_TEAM, query="SELECT r FROM Rating r WHERE r.team_id = :team_id"),
        @NamedQuery(name=Rating.CHANGE_VALUE, query="UPDATE Rating SET value = :value WHERE id = :id"),
        @NamedQuery(name=Rating.CHANGE_TIME, query="UPDATE Rating SET assignTime = :assignTime WHERE id = :id")
})
@SqlResultSetMapping(
        name="ratingResult",
        entities=@EntityResult(entityClass=Rating.class)
)
public class Rating {
    public static final String INSERT = "Rating.insert";
    public static final String DELETE = "Rating.delete";
    public static final String FIND_ALL = "Rating.findAll";
    public static final String FIND_BY_ID = "Rating.findRatingById";
    public static final String FIND_BY_VALUE = "Rating.findByAttrValue";
    public static final String FIND_BY_TIME = "Rating.findByAttrAssignTime";
    public static final String FIND_BY_TEAM = "Rating.findByAttrTeam";
    public static final String CHANGE_VALUE = "Rating.changeValue";
    public static final String CHANGE_TIME = "Rating.changeAssignTime";
    @Id
    @GeneratedValue
    private Long id;
    private Long value;
    private Long assignTime;
    private Long team_id;
}