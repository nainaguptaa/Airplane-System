-- Use the 'airline' database
USE airline;

-- Insert data into 'users'
INSERT INTO users (username, password, first_name, last_name, address, email, role, member) VALUES
('user1', 'password1', 'Apple', 'Banana', '123 main st.', 'user1@email.com', 2, TRUE),
('agent1', 'password2', 'Ice', 'Spice', '345 main st.', 'user2@email.com', 3, FALSE),
('admin1', 'password3', 'Ben', 'Ten', '214 main st.', 'admin1@email.com', 4, TRUE),
('guest1', 'password4', 'Jane', 'Doe', '678 another st.', 'user3@email.com', 1, FALSE),
('user2', 'password5', 'John', 'Smith', '910 another ave', 'user4@email.com', 2, TRUE),
('admin2', 'password6', 'Alice', 'Johnson', '1011 admin rd.', 'admin2@email.com', 4, FALSE),
('user3', 'password7', 'Emily', 'Brown', '111 Sunset Blvd', 'user5@email.com', 2, TRUE),
('agent2', 'password8', 'Michael', 'Green', '222 Sunrise Ave', 'user6@email.com', 3, FALSE),
('guest2', 'password9', 'Sarah', 'White', '333 Moon St', 'user7@email.com', 1, TRUE),
('agent3', 'password10', 'David', 'Black', '444 Star Rd', 'user8@email.com', 2, FALSE),
('admin3', 'password11', 'Laura', 'Gray', '555 Comet Ln', 'user9@email.com', 4, TRUE);

-- Insert data into 'locations'
INSERT INTO locations (city, state, country, code) VALUES
('New York', 'NY', 'USA', 'JFK'),
('Los Angeles', 'CA', 'USA', 'LAX'),
('London', 'N/A', 'UK', 'LHR'),
('Sydney', 'NSW', 'Australia', 'SYD'),
('Miami', 'FL', 'USA', 'MIA'),
('San Francisco', 'CA', 'USA', 'SFO'),
('Tokyo', 'N/A', 'Japan', 'HND'),
('Paris', 'N/A', 'France', 'CDG');

INSERT INTO locations (code, city, state, country) VALUES
('ATL', 'Atlanta', 'GA', 'USA'),
('PEK', 'Beijing', 'N/A', 'China'),
('FRA', 'Frankfurt', 'N/A', 'Germany'),
('BOM', 'Mumbai', 'MH', 'India'),
('SIN', 'Singapore', 'N/A', 'Singapore'),
('GRU', 'Sao Paulo', 'SP', 'Brazil');


-- Insert data into 'aircraftTypes'
INSERT INTO aircraftTypes (model) VALUES
('Boeing 737'),
('Airbus A320'),
('Boeing 787');

-- Insert data into 'aircrafts'
INSERT INTO aircrafts (model) VALUES
('Boeing 737'),
('Airbus A320'),
('Boeing 737'), 
('Airbus A320'), 
('Boeing 787'),
('Boeing 737'), 
('Airbus A320');

-- Insert data into 'seats'
INSERT INTO seats (seat_number, aircraft_id, class) VALUES
("A0", 1, 'Business'), ("B0", 1, 'Business'), ("C0", 1, 'Business'), ("D0", 1, 'Business'), ("E0", 1, 'Business'), ("F0", 1, 'Business'),
("A1", 1, 'Business'), ("B1", 1, 'Business'), ("C1", 1, 'Business'), ("D1", 1, 'Business'), ("E1", 1, 'Business'), ("F1", 1, 'Business'),
("A2", 1, 'Comfort'), ("B2", 1, 'Comfort'), ("C2", 1, 'Comfort'), ("D2", 1, 'Comfort'), ("E2", 1, 'Comfort'), ("F2", 1, 'Comfort'),
("A3", 1, 'Comfort'), ("B3", 1, 'Comfort'), ("C3", 1, 'Comfort'), ("D3", 1, 'Comfort'), ("E3", 1, 'Comfort'), ("F3", 1, 'Comfort'),
("A4", 1, 'Comfort'), ("B4", 1, 'Comfort'), ("C4", 1, 'Comfort'), ("D4", 1, 'Comfort'), ("E4", 1, 'Comfort'), ("F4", 1, 'Comfort'),
("A5", 1, 'Ordinary'), ("B5", 1, 'Ordinary'), ("C5", 1, 'Ordinary'), ("D5", 1, 'Ordinary'), ("E5", 1, 'Ordinary'), ("F5", 1, 'Ordinary'),
("A6", 1, 'Ordinary'), ("B6", 1, 'Ordinary'), ("C6", 1, 'Ordinary'), ("D6", 1, 'Ordinary'), ("E6", 1, 'Ordinary'), ("F6", 1, 'Ordinary'),
("A7", 1, 'Ordinary'), ("B7", 1, 'Ordinary'), ("C7", 1, 'Ordinary'), ("D7", 1, 'Ordinary'), ("E7", 1, 'Ordinary'), ("F7", 1, 'Ordinary'),
("A8", 1, 'Ordinary'), ("B8", 1, 'Ordinary'), ("C8", 1, 'Ordinary'), ("D8", 1, 'Ordinary'), ("E8", 1, 'Ordinary'), ("F8", 1, 'Ordinary'),
("A9", 1, 'Ordinary'), ("B9", 1, 'Ordinary'), ("C9", 1, 'Ordinary'), ("D9", 1, 'Ordinary'), ("E9", 1, 'Ordinary'), ("F9", 1, 'Ordinary'),
("A10", 1, 'Ordinary'), ("B10", 1, 'Ordinary'), ("C10", 1, 'Ordinary'), ("D10", 1, 'Ordinary'), ("E10", 1, 'Ordinary'), ("F10", 1, 'Ordinary'),
("A0", 2, 'Business'), ("B0", 2, 'Business'), ("C0", 2, 'Business'), ("D0", 2, 'Business'), ("E0", 2, 'Business'), ("F0", 2, 'Business'),
("A1", 2, 'Business'), ("B1", 2, 'Business'), ("C1", 2, 'Business'), ("D1", 2, 'Business'), ("E1", 2, 'Business'), ("F1", 2, 'Business'),
("A2", 2, 'Comfort'), ("B2", 2, 'Comfort'), ("C2", 2, 'Comfort'), ("D2", 2, 'Comfort'), ("E2", 2, 'Comfort'), ("F2", 2, 'Comfort'),
("A3", 2, 'Comfort'), ("B3", 2, 'Comfort'), ("C3", 2, 'Comfort'), ("D3", 2, 'Comfort'), ("E3", 2, 'Comfort'), ("F3", 2, 'Comfort'),
("A4", 2, 'Comfort'), ("B4", 2, 'Comfort'), ("C4", 2, 'Comfort'), ("D4", 2, 'Comfort'), ("E4", 2, 'Comfort'), ("F4", 2, 'Comfort'),
("A5", 2, 'Ordinary'), ("B5", 2, 'Ordinary'), ("C5", 2, 'Ordinary'), ("D5", 2, 'Ordinary'), ("E5", 2, 'Ordinary'), ("F5", 2, 'Ordinary'),
("A6", 2, 'Ordinary'), ("B6", 2, 'Ordinary'), ("C6", 2, 'Ordinary'), ("D6", 2, 'Ordinary'), ("E6", 2, 'Ordinary'), ("F6", 2, 'Ordinary'),
("A7", 2, 'Ordinary'), ("B7", 2, 'Ordinary'), ("C7", 2, 'Ordinary'), ("D7", 2, 'Ordinary'), ("E7", 2, 'Ordinary'), ("F7", 2, 'Ordinary'),
("A8", 2, 'Ordinary'), ("B8", 2, 'Ordinary'), ("C8", 2, 'Ordinary'), ("D8", 2, 'Ordinary'), ("E8", 2, 'Ordinary'), ("F8", 2, 'Ordinary'),
("A9", 2, 'Ordinary'), ("B9", 2, 'Ordinary'), ("C9", 2, 'Ordinary'), ("D9", 2, 'Ordinary'), ("E9", 2, 'Ordinary'), ("F9", 2, 'Ordinary'),
("A10", 2, 'Ordinary'), ("B10", 2, 'Ordinary'), ("C10", 2, 'Ordinary'), ("D10", 2, 'Ordinary'), ("E10", 2, 'Ordinary'), ("F10", 2, 'Ordinary'),
("A0", 3, 'Business'), ("B0", 3, 'Business'), ("C0", 3, 'Business'), ("D0", 3, 'Business'), ("E0", 3, 'Business'), ("F0", 3, 'Business'),
("A1", 3, 'Business'), ("B1", 3, 'Business'), ("C1", 3, 'Business'), ("D1", 3, 'Business'), ("E1", 3, 'Business'), ("F1", 3, 'Business'),
("A2", 3, 'Comfort'), ("B2", 3, 'Comfort'), ("C2", 3, 'Comfort'), ("D2", 3, 'Comfort'), ("E2", 3, 'Comfort'), ("F2", 3, 'Comfort'),
("A3", 3, 'Comfort'), ("B3", 3, 'Comfort'), ("C3", 3, 'Comfort'), ("D3", 3, 'Comfort'), ("E3", 3, 'Comfort'), ("F3", 3, 'Comfort'),
("A4", 3, 'Comfort'), ("B4", 3, 'Comfort'), ("C4", 3, 'Comfort'), ("D4", 3, 'Comfort'), ("E4", 3, 'Comfort'), ("F4", 3, 'Comfort'),
("A5", 3, 'Ordinary'), ("B5", 3, 'Ordinary'), ("C5", 3, 'Ordinary'), ("D5", 3, 'Ordinary'), ("E5", 3, 'Ordinary'), ("F5", 3, 'Ordinary'),
("A6", 3, 'Ordinary'), ("B6", 3, 'Ordinary'), ("C6", 3, 'Ordinary'), ("D6", 3, 'Ordinary'), ("E6", 3, 'Ordinary'), ("F6", 3, 'Ordinary'),
("A7", 3, 'Ordinary'), ("B7", 3, 'Ordinary'), ("C7", 3, 'Ordinary'), ("D7", 3, 'Ordinary'), ("E7", 3, 'Ordinary'), ("F7", 3, 'Ordinary'),
("A8", 3, 'Ordinary'), ("B8", 3, 'Ordinary'), ("C8", 3, 'Ordinary'), ("D8", 3, 'Ordinary'), ("E8", 3, 'Ordinary'), ("F8", 3, 'Ordinary'),
("A9", 3, 'Ordinary'), ("B9", 3, 'Ordinary'), ("C9", 3, 'Ordinary'), ("D9", 3, 'Ordinary'), ("E9", 3, 'Ordinary'), ("F9", 3, 'Ordinary'),
("A10", 3, 'Ordinary'), ("B10", 3, 'Ordinary'), ("C10", 3, 'Ordinary'), ("D10", 3, 'Ordinary'), ("E10", 3, 'Ordinary'), ("F10", 3, 'Ordinary'),
("A0", 4, 'Business'), ("B0", 4, 'Business'), ("C0", 4, 'Business'), ("D0", 4, 'Business'), ("E0", 4, 'Business'), ("F0", 4, 'Business'),
("A1", 4, 'Business'), ("B1", 4, 'Business'), ("C1", 4, 'Business'), ("D1", 4, 'Business'), ("E1", 4, 'Business'), ("F1", 4, 'Business'),
("A2", 4, 'Comfort'), ("B2", 4, 'Comfort'), ("C2", 4, 'Comfort'), ("D2", 4, 'Comfort'), ("E2", 4, 'Comfort'), ("F2", 4, 'Comfort'),
("A3", 4, 'Comfort'), ("B3", 4, 'Comfort'), ("C3", 4, 'Comfort'), ("D3", 4, 'Comfort'), ("E3", 4, 'Comfort'), ("F3", 4, 'Comfort'),
("A4", 4, 'Comfort'), ("B4", 4, 'Comfort'), ("C4", 4, 'Comfort'), ("D4", 4, 'Comfort'), ("E4", 4, 'Comfort'), ("F4", 4, 'Comfort'),
("A5", 4, 'Ordinary'), ("B5", 4, 'Ordinary'), ("C5", 4, 'Ordinary'), ("D5", 4, 'Ordinary'), ("E5", 4, 'Ordinary'), ("F5", 4, 'Ordinary'),
("A6", 4, 'Ordinary'), ("B6", 4, 'Ordinary'), ("C6", 4, 'Ordinary'), ("D6", 4, 'Ordinary'), ("E6", 4, 'Ordinary'), ("F6", 4, 'Ordinary'),
("A7", 4, 'Ordinary'), ("B7", 4, 'Ordinary'), ("C7", 4, 'Ordinary'), ("D7", 4, 'Ordinary'), ("E7", 4, 'Ordinary'), ("F7", 4, 'Ordinary'),
("A8", 4, 'Ordinary'), ("B8", 4, 'Ordinary'), ("C8", 4, 'Ordinary'), ("D8", 4, 'Ordinary'), ("E8", 4, 'Ordinary'), ("F8", 4, 'Ordinary'),
("A9", 4, 'Ordinary'), ("B9", 4, 'Ordinary'), ("C9", 4, 'Ordinary'), ("D9", 4, 'Ordinary'), ("E9", 4, 'Ordinary'), ("F9", 4, 'Ordinary'),
("A10", 4, 'Ordinary'), ("B10", 4, 'Ordinary'), ("C10", 4, 'Ordinary'), ("D10", 4, 'Ordinary'), ("E10", 4, 'Ordinary'), ("F10", 4, 'Ordinary'),
("A0", 5, 'Business'), ("B0", 5, 'Business'), ("C0", 5, 'Business'), ("D0", 5, 'Business'), ("E0", 5, 'Business'), ("F0", 5, 'Business'),
("A1", 5, 'Business'), ("B1", 5, 'Business'), ("C1", 5, 'Business'), ("D1", 5, 'Business'), ("E1", 5, 'Business'), ("F1", 5, 'Business'),
("A2", 5, 'Comfort'), ("B2", 5, 'Comfort'), ("C2", 5, 'Comfort'), ("D2", 5, 'Comfort'), ("E2", 5, 'Comfort'), ("F2", 5, 'Comfort'),
("A3", 5, 'Comfort'), ("B3", 5, 'Comfort'), ("C3", 5, 'Comfort'), ("D3", 5, 'Comfort'), ("E3", 5, 'Comfort'), ("F3", 5, 'Comfort'),
("A4", 5, 'Comfort'), ("B4", 5, 'Comfort'), ("C4", 5, 'Comfort'), ("D4", 5, 'Comfort'), ("E4", 5, 'Comfort'), ("F4", 5, 'Comfort'),
("A5", 5, 'Ordinary'), ("B5", 5, 'Ordinary'), ("C5", 5, 'Ordinary'), ("D5", 5, 'Ordinary'), ("E5", 5, 'Ordinary'), ("F5", 5, 'Ordinary'),
("A6", 5, 'Ordinary'), ("B6", 5, 'Ordinary'), ("C6", 5, 'Ordinary'), ("D6", 5, 'Ordinary'), ("E6", 5, 'Ordinary'), ("F6", 5, 'Ordinary'),
("A7", 5, 'Ordinary'), ("B7", 5, 'Ordinary'), ("C7", 5, 'Ordinary'), ("D7", 5, 'Ordinary'), ("E7", 5, 'Ordinary'), ("F7", 5, 'Ordinary'),
("A8", 5, 'Ordinary'), ("B8", 5, 'Ordinary'), ("C8", 5, 'Ordinary'), ("D8", 5, 'Ordinary'), ("E8", 5, 'Ordinary'), ("F8", 5, 'Ordinary'),
("A9", 5, 'Ordinary'), ("B9", 5, 'Ordinary'), ("C9", 5, 'Ordinary'), ("D9", 5, 'Ordinary'), ("E9", 5, 'Ordinary'), ("F9", 5, 'Ordinary'),
("A10", 5, 'Ordinary'), ("B10", 5, 'Ordinary'), ("C10", 5, 'Ordinary'), ("D10", 5, 'Ordinary'), ("E10", 5, 'Ordinary'), ("F10", 5, 'Ordinary'),
("A0", 6, 'Business'), ("B0", 6, 'Business'), ("C0", 6, 'Business'), ("D0", 6, 'Business'), ("E0", 6, 'Business'), ("F0", 6, 'Business'),
("A1", 6, 'Business'), ("B1", 6, 'Business'), ("C1", 6, 'Business'), ("D1", 6, 'Business'), ("E1", 6, 'Business'), ("F1", 6, 'Business'),
("A2", 6, 'Comfort'), ("B2", 6, 'Comfort'), ("C2", 6, 'Comfort'), ("D2", 6, 'Comfort'), ("E2", 6, 'Comfort'), ("F2", 6, 'Comfort'),
("A3", 6, 'Comfort'), ("B3", 6, 'Comfort'), ("C3", 6, 'Comfort'), ("D3", 6, 'Comfort'), ("E3", 6, 'Comfort'), ("F3", 6, 'Comfort'),
("A4", 6, 'Comfort'), ("B4", 6, 'Comfort'), ("C4", 6, 'Comfort'), ("D4", 6, 'Comfort'), ("E4", 6, 'Comfort'), ("F4", 6, 'Comfort'),
("A5", 6, 'Ordinary'), ("B5", 6, 'Ordinary'), ("C5", 6, 'Ordinary'), ("D5", 6, 'Ordinary'), ("E5", 6, 'Ordinary'), ("F5", 6, 'Ordinary'),
("A6", 6, 'Ordinary'), ("B6", 6, 'Ordinary'), ("C6", 6, 'Ordinary'), ("D6", 6, 'Ordinary'), ("E6", 6, 'Ordinary'), ("F6", 6, 'Ordinary'),
("A7", 6, 'Ordinary'), ("B7", 6, 'Ordinary'), ("C7", 6, 'Ordinary'), ("D7", 6, 'Ordinary'), ("E7", 6, 'Ordinary'), ("F7", 6, 'Ordinary'),
("A8", 6, 'Ordinary'), ("B8", 6, 'Ordinary'), ("C8", 6, 'Ordinary'), ("D8", 6, 'Ordinary'), ("E8", 6, 'Ordinary'), ("F8", 6, 'Ordinary'),
("A9", 6, 'Ordinary'), ("B9", 6, 'Ordinary'), ("C9", 6, 'Ordinary'), ("D9", 6, 'Ordinary'), ("E9", 6, 'Ordinary'), ("F9", 6, 'Ordinary'),
("A10", 6, 'Ordinary'), ("B10", 6, 'Ordinary'), ("C10", 6, 'Ordinary'), ("D10", 6, 'Ordinary'), ("E10", 6, 'Ordinary'), ("F10", 6, 'Ordinary'),
("A0", 7, 'Business'), ("B0", 7, 'Business'), ("C0", 7, 'Business'), ("D0", 7, 'Business'), ("E0", 7, 'Business'), ("F0", 7, 'Business'),
("A1", 7, 'Business'), ("B1", 7, 'Business'), ("C1", 7, 'Business'), ("D1", 7, 'Business'), ("E1", 7, 'Business'), ("F1", 7, 'Business'),
("A2", 7, 'Comfort'), ("B2", 7, 'Comfort'), ("C2", 7, 'Comfort'), ("D2", 7, 'Comfort'), ("E2", 7, 'Comfort'), ("F2", 7, 'Comfort'),
("A3", 7, 'Comfort'), ("B3", 7, 'Comfort'), ("C3", 7, 'Comfort'), ("D3", 7, 'Comfort'), ("E3", 7, 'Comfort'), ("F3", 7, 'Comfort'),
("A4", 7, 'Comfort'), ("B4", 7, 'Comfort'), ("C4", 7, 'Comfort'), ("D4", 7, 'Comfort'), ("E4", 7, 'Comfort'), ("F4", 7, 'Comfort'),
("A5", 7, 'Ordinary'), ("B5", 7, 'Ordinary'), ("C5", 7, 'Ordinary'), ("D5", 7, 'Ordinary'), ("E5", 7, 'Ordinary'), ("F5", 7, 'Ordinary'),
("A6", 7, 'Ordinary'), ("B6", 7, 'Ordinary'), ("C6", 7, 'Ordinary'), ("D6", 7, 'Ordinary'), ("E6", 7, 'Ordinary'), ("F6", 7, 'Ordinary'),
("A7", 7, 'Ordinary'), ("B7", 7, 'Ordinary'), ("C7", 7, 'Ordinary'), ("D7", 7, 'Ordinary'), ("E7", 7, 'Ordinary'), ("F7", 7, 'Ordinary'),
("A8", 7, 'Ordinary'), ("B8", 7, 'Ordinary'), ("C8", 7, 'Ordinary'), ("D8", 7, 'Ordinary'), ("E8", 7, 'Ordinary'), ("F8", 7, 'Ordinary'),
("A9", 7, 'Ordinary'), ("B9", 7, 'Ordinary'), ("C9", 7, 'Ordinary'), ("D9", 7, 'Ordinary'), ("E9", 7, 'Ordinary'), ("F9", 7, 'Ordinary'),
("A10", 7, 'Ordinary'), ("B10", 7, 'Ordinary'), ("C10", 7, 'Ordinary'), ("D10", 7, 'Ordinary'), ("E10", 7, 'Ordinary'), ("F10", 7, 'Ordinary');

-- Insert data into 'flights'
INSERT INTO flights (aircraft_id, departure_time, arrival_time, departure_airport_id, arrival_airport_id, price) VALUES
(1, '2023-12-01 08:00:00', '2023-12-01 12:00:00', 'JFK', 'LAX', 300.00),
(2, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'SYD', 'LHR', 450.00),
(2, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'LAX', 'LHR', 675.00),
(1, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'LHR', 'LAX', 200.00),
(3, '2023-12-03 07:00:00', '2023-12-03 09:00:00', 'MIA', 'SFO', 350.00),
(3, '2023-12-04 08:00:00', '2023-12-04 10:00:00', 'HND', 'CDG', 500.00),
(4, '2023-12-05 06:00:00', '2023-12-05 08:00:00', 'ATL', 'PEK', 800.00),
(5, '2023-12-06 07:00:00', '2023-12-06 09:00:00', 'FRA', 'BOM', 600.00),
(4, '2023-12-07 08:00:00', '2023-12-07 10:00:00', 'SIN', 'GRU', 650.00);

-- Insert data into 'bookings'
INSERT INTO bookings (username, flight_id, seat_id, booking_date, insurance, price, status) VALUES
('user1', 1, 1, '2023-11-24 10:00:00', FALSE, 300.00, 'Confirmed'),
('user2', 2, 3, '2023-11-25 10:00:00', TRUE, 450.00, 'Confirmed'),
('user3', 3, 2, '2023-11-26 11:00:00', TRUE, 350.00, 'Confirmed'),
('user1', 4, 4, '2023-11-27 12:00:00', FALSE, 500.00, 'Confirmed'),
('user2', 5, 6, '2023-11-28 13:00:00', TRUE, 550.00, 'Confirmed'),
('user3', 6, 7, '2023-11-29 14:00:00', FALSE, 600.00, 'Confirmed'),
('user1', 7, 8, '2023-11-30 15:00:00', TRUE, 650.00, 'Confirmed');

-- Insert data into 'crew'
INSERT INTO crew (username, flight_id) VALUES
('agent1', 1),
('agent2', 1),
('agent3', 2),
('agent1', 2),
('agent3', 3),
('agent2', 4),
('agent1', 5), 
('agent2', 6), 
('agent3', 7),
('agent1', 5), 
('agent2', 6);

INSERT INTO promotion (discount, price_for_discount) VALUES
(0.1, 100),
(0.8, 800),
(0.9, 900),
(1.0, 1000);
