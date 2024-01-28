drop table cars;
drop table users;
drop table sellers;
drop table admins;
drop table images;
drop table transactions;
drop table reviews;
drop table search_queries;

create table cars (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      seller_id INT,
                      rating FLOAT,
                      make VARCHAR(100),
                      model VARCHAR(100),
                      release_year INT,
                      price INT,
                      fuel_type VARCHAR(50),
                      transmission VARCHAR(20),
                      mileage INT,
                      vin_code VARCHAR(17),
                      used BOOLEAN,
                      engine_config VARCHAR(20),
                      working BOOLEAN,
                      color VARCHAR(50),
                      drive_type VARCHAR(50),
                      rudder_side VARCHAR(10),
                      owners_number INT
);

create table users (
                      id INT PRIMARY KEY,
                      username VARCHAR(40),
                      password_hash INT,
                      first_name VARCHAR(255),
                      last_name VARCHAR(255),
                      phone_number VARCHAR(20),
                      email VARCHAR(100),
                      balance FLOAT,
                      logged_in BOOLEAN
);

create table sellers (
                      id INT PRIMARY KEY,
                      user_id INT,
                      sales_number INT,
                      reviews_number INT,
                      rating FLOAT
);

create table admins (
                      id INT PRIMARY KEY,
                      user_id INT
);

create table images (
                      id INT PRIMARY KEY,
                      link VARCHAR(511),
                      car_id INT,
                      side VARCHAR(30)
);

create table transactions (
                      id INT PRIMARY KEY,
                      car_id INT,
                      user_id INT,
                      cost INT,
                      payment_method VARCHAR(100)
);

create table reviews (
                      id INT PRIMARY KEY,
                      car_id INT,
                      user_id INT,
                      rating INT,
                      review_text VARCHAR(1023)
);

create table search_queries (
                      id INT PRIMARY KEY,
                      text VARCHAR(1023),
                      search_date DATE
);