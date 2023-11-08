package com.example.demo.repository;

import com.example.demo.model.Stadium;
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
public class StadiumRepository {
    @Autowired
    private DataSource dataSource;

    public List<Stadium> findAll() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  stadiums");
        List<Stadium> stadiums = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String city = result.getString("city");
            String country = result.getString("country");
            Stadium stadium = Stadium.builder()
                    .id(id).name(name).city(city).country(country)
                    .build();
            stadiums.add(stadium);
        }
        return stadiums;
    }

    public void insert(Stadium stadium) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("INSERT INTO stadiums (id, name, city, country) VALUES (?, ?, ?, ?)");
        statement.setLong(1, stadium.getId());
        statement.setString(2, stadium.getName());
        statement.setString(3, stadium.getCity());
        statement.setString(4, stadium.getCountry());
        statement.execute();
    }

    public void delete(Long id) throws SQLException {
        PreparedStatement statement = dataSource.getConnection().prepareStatement("DELETE FROM stadiums WHERE id = ?");
        statement.setLong(1, id);
        statement.execute();
    }

    public Stadium findById(Long findId) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  stadiums");
        List<Stadium> stadiums = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String city = result.getString("city");
            String country = result.getString("country");
            Stadium stadium = Stadium.builder()
                    .id(id).name(name).city(city).country(country)
                    .build();
            if (id == findId) return stadium;
        }
        return new Stadium();
    }

    public List<Stadium> findByAttrName(String findName) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  stadiums");
        List<Stadium> stadiums = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String city = result.getString("city");
            String country = result.getString("country");
            Stadium stadium = Stadium.builder()
                    .id(id).name(name).city(city).country(country)
                    .build();
            if (Objects.equals(name, findName)) stadiums.add(stadium);
        }
        return stadiums;
    }

    public List<Stadium> findByAttrCity(String findCity) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  stadiums");
        List<Stadium> stadiums = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String city = result.getString("city");
            String country = result.getString("country");
            Stadium stadium = Stadium.builder()
                    .id(id).name(name).city(city).country(country)
                    .build();
            if (Objects.equals(city, findCity)) stadiums.add(stadium);
        }
        return stadiums;
    }

    public List<Stadium> findByAttrCountry(String findCountry) throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from  stadiums");
        List<Stadium> stadiums = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong("id");
            String name = result.getString("name");
            String city = result.getString("city");
            String country = result.getString("country");
            Stadium stadium = Stadium.builder()
                    .id(id).name(name).city(city).country(country)
                    .build();
            if (Objects.equals(country, findCountry)) stadiums.add(stadium);
        }
        return stadiums;
    }
}