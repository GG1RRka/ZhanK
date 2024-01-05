drop table if exists teams;
drop table if exists salaries;
drop table if exists ratings;

CREATE TABLE teams (
                      id INT PRIMARY KEY,
                      name VARCHAR(255),
                      country VARCHAR(255),
                      totalEarnings INT,
                      currency VARCHAR(255)
);

CREATE TABLE salaries (
                      id INT PRIMARY KEY,
                      theValue INT,
                      currency VARCHAR(255),
                      team_id INT
);

CREATE TABLE ratings (
                      id INT PRIMARY KEY,
                      theValue DOUBLE,
                      assignTime DOUBLE,
                      team_id INT
);