-- Create database
CREATE DATABASE IF NOT EXISTS airline;
-- Use the 'airline' database
USE airline;
-- Drop 'tickets' table if it exists
DROP TABLE IF EXISTS tickets;
-- Drop 'bookings' table if it exists
DROP TABLE IF EXISTS bookings;
-- Drop 'flights' table if it exists
DROP TABLE IF EXISTS flights;
-- Drop 'seats' table if it exists
DROP TABLE IF EXISTS seats;
-- Drop 'aircrafts' table if it exists
DROP TABLE IF EXISTS aircrafts;
-- Drop 'airports' table if it exists
DROP TABLE IF EXISTS airports;
-- Drop 'locations' table if it exists
DROP TABLE IF EXISTS locations;
-- Drop 'users' table if it exists
DROP TABLE IF EXISTS users;
-- Now recreate the tables in the correct order
-- Create 'users' table
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    role INT NOT NULL,
    member BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Create 'locations' table
CREATE TABLE locations (
    code VARCHAR(100) PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);
-- Create 'aircrafts' table
CREATE TABLE aircrafts (
    aircraft_id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);
-- Create 'seats' table
CREATE TABLE seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    aircraft_id INT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    class VARCHAR(50) NOT NULL,
    available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(aircraft_id) ON DELETE CASCADE
);

INSERT INTO seats (seat_id, aircraft_id, class) VALUES
("A0", 1, 'Business Class'), ("B0", 1, 'Business Class'), ("C0", 1, 'Business Class'), ("D0", 1, 'Business Class'), ("E0", 1, 'Business Class'), ("F0", 1, 'Business Class'),
("A1", 1, 'Business Class'), ("B1", 1, 'Business Class'), ("C1", 1, 'Business Class'), ("D1", 1, 'Business Class'), ("E1", 1, 'Business Class'), ("F1", 1, 'Business Class'),
("A2", 1, 'Comfort'), ("B2", 1, 'Comfort'), ("C2", 1, 'Comfort'), ("D2", 1, 'Comfort'), ("E2", 1, 'Comfort'), ("F2", 1, 'Comfort'),
("A3", 1, 'Comfort'), ("B3", 1, 'Comfort'), ("C3", 1, 'Comfort'), ("D3", 1, 'Comfort'), ("E3", 1, 'Comfort'), ("F3", 1, 'Comfort'),
("A4", 1, 'Comfort'), ("B4", 1, 'Comfort'), ("C4", 1, 'Comfort'), ("D4", 1, 'Comfort'), ("E4", 1, 'Comfort'), ("F4", 1, 'Comfort'),
("A5", 1, 'Ordinary'), ("B5", 1, 'Ordinary'), ("C5", 1, 'Ordinary'), ("D5", 1, 'Ordinary'), ("E5", 1, 'Ordinary'), ("F5", 1, 'Ordinary'),
("A6", 1, 'Ordinary'), ("B6", 1, 'Ordinary'), ("C6", 1, 'Ordinary'), ("D6", 1, 'Ordinary'), ("E6", 1, 'Ordinary'), ("F6", 1, 'Ordinary'),
("A7", 1, 'Ordinary'), ("B7", 1, 'Ordinary'), ("C7", 1, 'Ordinary'), ("D7", 1, 'Ordinary'), ("E7", 1, 'Ordinary'), ("F7", 1, 'Ordinary'),
("A8", 1, 'Ordinary'), ("B8", 1, 'Ordinary'), ("C8", 1, 'Ordinary'), ("D8", 1, 'Ordinary'), ("E8", 1, 'Ordinary'), ("F8", 1, 'Ordinary'),
("A9", 1, 'Ordinary'), ("B9", 1, 'Ordinary'), ("C9", 1, 'Ordinary'), ("D9", 1, 'Ordinary'), ("E9", 1, 'Ordinary'), ("F9", 1, 'Ordinary'),
("A10", 1, 'Ordinary'), ("B10", 1, 'Ordinary'), ("C10", 1, 'Ordinary'), ("D10", 1, 'Ordinary'), ("E10", 1, 'Ordinary'), ("F10", 1, 'Ordinary');

-- Create 'flights' table
CREATE TABLE flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    aircraft_id INT NOT NULL,
    departure_time DATETIME NOT NULL,
    arrival_time DATETIME NOT NULL,
    departure_airport_id VARCHAR(100) NOT NULL,
    arrival_airport_id VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(aircraft_id) ON DELETE CASCADE,
    FOREIGN KEY (departure_airport_id) REFERENCES locations(code) ON DELETE CASCADE,
    FOREIGN KEY (arrival_airport_id) REFERENCES locations(code) ON DELETE CASCADE
);
-- Create 'bookings' table
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    flight_id INT NOT NULL,
    seat_id INT NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    insurance BOOLEAN DEFAULT FALSE,
    price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (seat_id) REFERENCES seats(seat_id)
);

