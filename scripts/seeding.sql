-- Use the 'airline' database
USE airline;

-- Insert data into 'users'
INSERT INTO users (username, password, email, role, member) VALUES
('user1', 'password1', 'user1@email.com', 2, TRUE),
('user2', 'password2', 'user2@email.com', 3, FALSE),
('admin1', 'password1', 'admin1@email.com', 4, TRUE);

-- Insert data into 'locations'
INSERT INTO locations (city, state, country, code) VALUES
('New York', 'NY', 'USA', 'JFK'),
('Los Angeles', 'CA', 'USA', 'LAX'),
('London', 'N/A', 'UK', 'LHR'),
('Sydney', 'NSW', 'Australia', 'SYD');

-- Insert data into 'aircraftTypes'
INSERT INTO aircraftTypes (model, capacity) VALUES
('Boeing 737', 190),
('Airbus A320', 150),
('Boeing 787', 240);

-- Insert data into 'aircrafts'
INSERT INTO aircrafts (model) VALUES
('Boeing 737'),
('Airbus A320');

-- Insert data into 'seats'
INSERT INTO seats (seat_number, aircraft_id, class) VALUES
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
-- Insert data into 'flights'
INSERT INTO flights (aircraft_id, departure_time, arrival_time, departure_airport_id, arrival_airport_id, price) VALUES
(1, '2023-12-01 08:00:00', '2023-12-01 12:00:00', 'JFK', 'LAX', 300.00),
(2, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'SYD', 'LHR', 450.00),
(2, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'LAX', 'LHR', 600.00),
(1, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'LHR', 'LAX', 200.00);

-- Insert data into 'bookings'
INSERT INTO bookings (username, flight_id, seat_id, booking_date, insurance, price, status) VALUES
('user1', 1, 1, '2023-11-24 10:00:00', FALSE, 300.00, 'Confirmed'),
('user2', 2, 3, '2023-11-25 10:00:00', TRUE, 450.00, 'Confirmed');

-- Insert data into 'crew'
INSERT INTO crew (username, flight_id) VALUES
('user1', 1),
('user2', 3),
('user1', 2),
('user2', 4);
