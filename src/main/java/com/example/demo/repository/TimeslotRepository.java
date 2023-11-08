package com.example.demo.repository;

import com.example.demo.model.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TimeslotRepository {
    @Autowired
    private DataSource dataSource;

    public List<Timeslot> findAll() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  timeslots");
        List<Timeslot> timeslots = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String starttime = result.getString("starttime");
            Timeslot timeslot = Timeslot.builder()
                    .id(id).starttime(starttime)
                    .build();
            timeslots.add(timeslot);
        }
        return timeslots;
    }

    public void insert(Timeslot timeslot) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("INSERT INTO timeslots (id, starttime) VALUES (?, ?)");
        statement.setLong(1, timeslot.getId());
        statement.setString(2, timeslot.getStarttime());
        statement.execute();
    }

    public void delete(Long id) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("DELETE FROM timeslots WHERE id = ?");
        statement.setLong(1, id);
        statement.execute();
    }

    public Timeslot findById(Long findId) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  timeslots");
        List<Timeslot> timeslots = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String starttime = result.getString("starttime");
            Timeslot timeslot = Timeslot.builder()
                    .id(id).starttime(starttime)
                    .build();
            if (id == findId) return timeslot;
        }
        return new Timeslot();
    }

    public List<Timeslot> findByAttrTime(String findStarttime) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  timeslots");
        List<Timeslot> timeslots = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String starttime = result.getString("starttime");
            Timeslot timeslot = Timeslot.builder()
                    .id(id).starttime(starttime)
                    .build();
            if (Objects.equals(starttime, findStarttime)) timeslots.add(timeslot);
        }
        return timeslots;
    }
}