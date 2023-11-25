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
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    role INT NOT NULL,
    member BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create 'locations' table
CREATE TABLE locations (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);
 
-- Create 'airports' table
CREATE TABLE airports (
    airport_id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(10) NOT NULL,
    FOREIGN KEY (location_id) REFERENCES locations(location_id)
);

-- Create 'aircrafts' table
CREATE TABLE aircrafts (
    aircraft_id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);

-- Create 'seats' table
CREATE TABLE seats (
    seat_id VARCHAR(10) NOT NULL,
    aircraft_id INT NOT NULL,
    class VARCHAR(50) NOT NULL,
    available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(aircraft_id)
);

INSERT INTO seats (seat_id, aircraft_id, class) VALUES
("A0", 1, 'Business-Class'),
("A1", 1, 'Business-Class'),
("A2", 1, 'Comfort'),
("A3", 1, 'Comfort'),
("A4", 1, 'Ordinary'),
("A5", 1, 'Ordinary'),
("A6", 1, 'Ordinary'),
("A7", 1, 'Ordinary'),
("A8", 1, 'Ordinary'),
("A9", 1, 'Ordinary'),
("A10", 1, 'Ordinary'),
("B0", 1, 'Business-Class'),
("B1", 1, 'Business-Class'),
("B2", 1, 'Comfort'),
("B3", 1, 'Comfort'),
("B4", 1, 'Ordinary'),
("B5", 1, 'Ordinary'),
("B6", 1, 'Ordinary'),
("B7", 1, 'Ordinary'),
("B8", 1, 'Ordinary'),
("B9", 1, 'Ordinary'),
("B10", 1, 'Ordinary'),
("C0", 1, 'Business-Class'),
("C1", 1, 'Business-Class'),
("C2", 1, 'Comfort'),
("C3", 1, 'Comfort'),
("C4", 1, 'Ordinary'),
("C5", 1, 'Ordinary'),
("C6", 1, 'Ordinary'),
("C7", 1, 'Ordinary'),
("C8", 1, 'Ordinary'),
("C9", 1, 'Ordinary'),
("C10", 1, 'Ordinary'),
("D0", 1, 'Business-Class'),
("D1", 1, 'Business-Class'),
("D2", 1, 'Comfort'),
("D3", 1, 'Comfort'),
("D4", 1, 'Ordinary'),
("D5", 1, 'Ordinary'),
("D6", 1, 'Ordinary'),
("D7", 1, 'Ordinary'),
("D8", 1, 'Ordinary'),
("D9", 1, 'Ordinary'),
("D10", 1, 'Ordinary'),
("E0", 1, 'Business-Class'),
("E1", 1, 'Business-Class'),
("E2", 1, 'Comfort'),
("E3", 1, 'Comfort'),
("E4", 1, 'Ordinary'),
("E5", 1, 'Ordinary'),
("E6", 1, 'Ordinary'),
("E7", 1, 'Ordinary'),
("E8", 1, 'Ordinary'),
("E9", 1, 'Ordinary'),
("E10", 1, 'Ordinary'),
("F0", 1, 'Business-Class'),
("F1", 1, 'Business-Class'),
("F2", 1, 'Comfort'),
("F3", 1, 'Comfort'),
("F4", 1, 'Ordinary'),
("F5", 1, 'Ordinary'),
("F6", 1, 'Ordinary'),
("F7", 1, 'Ordinary'),
("F8", 1, 'Ordinary'),
("F9", 1, 'Ordinary'),
("F10", 1, 'Ordinary'),
("A0", 2, 'Business-Class'),
("A1", 2, 'Business-Class'),
("A2", 2, 'Comfort'),
("A3", 2, 'Comfort'),
("A4", 2, 'Ordinary'),
("A5", 2, 'Ordinary'),
("A6", 2, 'Ordinary'),
("A7", 2, 'Ordinary'),
("A8", 2, 'Ordinary'),
("A9", 2, 'Ordinary'),
("A10", 2, 'Ordinary'),
("B0", 2, 'Business-Class'),
("B1", 2, 'Business-Class'),
("B2", 2, 'Comfort'),
("B3", 2, 'Comfort'),
("B4", 2, 'Ordinary'),
("B5", 2, 'Ordinary'),
("B6", 2, 'Ordinary'),
("B7", 2, 'Ordinary'),
("B8", 2, 'Ordinary'),
("B9", 2, 'Ordinary'),
("B10", 2, 'Ordinary'),
("C0", 2, 'Business-Class'),
("C1", 2, 'Business-Class'),
("C2", 2, 'Comfort'),
("C3", 2, 'Comfort'),
("C4", 2, 'Ordinary'),
("C5", 2, 'Ordinary'),
("C6", 2, 'Ordinary'),
("C7", 2, 'Ordinary'),
("C8", 2, 'Ordinary'),
("C9", 2, 'Ordinary'),
("C10", 2, 'Ordinary'),
("D0", 2, 'Business-Class'),
("D1", 2, 'Business-Class'),
("D2", 2, 'Comfort'),
("D3", 2, 'Comfort'),
("D4", 2, 'Ordinary'),
("D5", 2, 'Ordinary'),
("D6", 2, 'Ordinary'),
("D7", 2, 'Ordinary'),
("D8", 2, 'Ordinary'),
("D9", 2, 'Ordinary'),
("D10", 2, 'Ordinary'),
("E0", 2, 'Business-Class'),
("E1", 2, 'Business-Class'),
("E2", 2, 'Comfort'),
("E3", 2, 'Comfort'),
("E4", 2, 'Ordinary'),
("E5", 2, 'Ordinary'),
("E6", 2, 'Ordinary'),
("E7", 2, 'Ordinary'),
("E8", 2, 'Ordinary'),
("E9", 2, 'Ordinary'),
("E10", 2, 'Ordinary'),
("F0", 2, 'Business-Class'),
("F1", 2, 'Business-Class'),
("F2", 2, 'Comfort'),
("F3", 2, 'Comfort'),
("F4", 2, 'Ordinary'),
("F5", 2, 'Ordinary'),
("F6", 2, 'Ordinary'),
("F7", 2, 'Ordinary'),
("F8", 2, 'Ordinary'),
("F9", 2, 'Ordinary'),
("F10", 2, 'Ordinary'),
("A0", 3, 'Business-Class'),
("A1", 3, 'Business-Class'),
("A2", 3, 'Comfort'),
("A3", 3, 'Comfort'),
("A4", 3, 'Ordinary'),
("A5", 3, 'Ordinary'),
("A6", 3, 'Ordinary'),
("A7", 3, 'Ordinary'),
("A8", 3, 'Ordinary'),
("A9", 3, 'Ordinary'),
("A10", 3, 'Ordinary'),
("B0", 3, 'Business-Class'),
("B1", 3, 'Business-Class'),
("B2", 3, 'Comfort'),
("B3", 3, 'Comfort'),
("B4", 3, 'Ordinary'),
("B5", 3, 'Ordinary'),
("B6", 3, 'Ordinary'),
("B7", 3, 'Ordinary'),
("B8", 3, 'Ordinary'),
("B9", 3, 'Ordinary'),
("B10", 3, 'Ordinary'),
("C0", 3, 'Business-Class'),
("C1", 3, 'Business-Class'),
("C2", 3, 'Comfort'),
("C3", 3, 'Comfort'),
("C4", 3, 'Ordinary'),
("C5", 3, 'Ordinary'),
("C6", 3, 'Ordinary'),
("C7", 3, 'Ordinary'),
("C8", 3, 'Ordinary'),
("C9", 3, 'Ordinary'),
("C10", 3, 'Ordinary'),
("D0", 3, 'Business-Class'),
("D1", 3, 'Business-Class'),
("D2", 3, 'Comfort'),
("D3", 3, 'Comfort'),
("D4", 3, 'Ordinary'),
("D5", 3, 'Ordinary'),
("D6", 3, 'Ordinary'),
("D7", 3, 'Ordinary'),
("D8", 3, 'Ordinary'),
("D9", 3, 'Ordinary'),
("D10", 3, 'Ordinary'),
("E0", 3, 'Business-Class'),
("E1", 3, 'Business-Class'),
("E2", 3, 'Comfort'),
("E3", 3, 'Comfort'),
("E4", 3, 'Ordinary'),
("E5", 3, 'Ordinary'),
("E6", 3, 'Ordinary'),
("E7", 3, 'Ordinary'),
("E8", 3, 'Ordinary'),
("E9", 3, 'Ordinary'),
("E10", 3, 'Ordinary'),
("F0", 3, 'Business-Class'),
("F1", 3, 'Business-Class'),
("F2", 3, 'Comfort'),
("F3", 3, 'Comfort'),
("F4", 3, 'Ordinary'),
("F5", 3, 'Ordinary'),
("F6", 3, 'Ordinary'),
("F7", 3, 'Ordinary'),
("F8", 3, 'Ordinary'),
("F9", 3, 'Ordinary'),
("F10", 3, 'Ordinary');

-- Create 'flights' table
CREATE TABLE flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    aircraft_id INT NOT NULL,
    departure_time DATETIME NOT NULL,
    arrival_time DATETIME NOT NULL,
    departure_airport_id INT NOT NULL,
    arrival_airport_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(aircraft_id),
    FOREIGN KEY (departure_airport_id) REFERENCES airports(airport_id),
    FOREIGN KEY (arrival_airport_id) REFERENCES airports(airport_id)
);

-- Create 'bookings' table
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    flight_id INT NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id)
);

-- Create 'tickets' table
CREATE TABLE tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    seat_id INT NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
    FOREIGN KEY (seat_id) REFERENCES seats(seat_id)
);
