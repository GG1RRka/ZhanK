drop table if exists teams;
drop table if exists players;
drop table if exists staduims;
drop table if exists timeslots;

CREATE TABLE teams (
                       id INT PRIMARY KEY,
                       name VARCHAR(255),
                       country VARCHAR(255)
);

CREATE TABLE players (
                      id INT PRIMARY KEY,
                      name VARCHAR(255),
                      surname VARCHAR(255),
                      country VARCHAR(255)
);

CREATE TABLE stadiums (
                      id INT PRIMARY KEY,
                      name VARCHAR(255),
                      city VARCHAR(255),
                      country VARCHAR(255)
);

CREATE TABLE timeslots (
                      id INT PRIMARY KEY,
                      starttime VARCHAR(255)
);
CREATE TABLE matches (
    id INT PRIMARY KEY,
    team1_id INT,
    team2_id INT,
    stadium_id INT,
    timeslot_id INT,
    match_date DATE
);
CREATE TABLE results (
    match_id INT PRIMARY KEY,
    team1_score INT,
    team2_score INT,
    winner_id INT
);
CREATE TABLE coaches (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    team_id INT,
    country VARCHAR(255)
);