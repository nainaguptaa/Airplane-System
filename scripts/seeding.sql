-- Use the 'airline' database
USE airline;

-- Insert data into 'users'
INSERT INTO users (username, password, first_name, last_name, address, email, role, member) VALUES
('user1', 'password1', 'user', 'one', '123 main st.', 'user1@email.com', 2, TRUE),
('user2', 'password2', 'user', 'two', '345 main st.', 'user2@email.com', 3, FALSE),
('admin1', 'password1', 'admin', 'one', '214 main st.', 'admin1@email.com', 4, TRUE);

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
INSERT INTO seats (aircraft_id, seat_number, class) VALUES
(1, '1A', 'First'),
(1, '1B', 'First'),
(2, '10A', 'Economy'),
(2, '10B', 'Economy');

-- Insert data into 'flights'
INSERT INTO flights (aircraft_id, departure_time, arrival_time, departure_airport_id, arrival_airport_id, price) VALUES
(1, '2023-12-01 08:00:00', '2023-12-01 12:00:00', 'JFK', 'LAX', 300.00),
(2, '2023-12-02 09:00:00', '2023-12-02 11:00:00', 'SYD', 'LHR', 450.00);

-- Insert data into 'bookings'
INSERT INTO bookings (username, flight_id, seat_id, booking_date, insurance, price, status) VALUES
('user1', 1, 1, '2023-11-24 10:00:00', FALSE, 300.00, 'Confirmed'),
('user2', 2, 3, '2023-11-25 10:00:00', TRUE, 450.00, 'Confirmed');

-- Insert data into 'crew'
INSERT INTO crew (username, flight_id) VALUES
('user1', 1),
('user2', 1),
('user1', 2),
('user2', 2);

INSERT INTO promotion (discount, price_for_discount) VALUES
(0.1, 100),
(0.8, 800),
(0.9, 900),
(1.0, 1000);
