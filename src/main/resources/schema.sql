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
