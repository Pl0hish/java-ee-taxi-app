drop table if exists orders;
drop table if exists cars;
drop table if exists users;


create table cars (
      id integer not null AUTO_INCREMENT,
      category varchar(255),
      driver varchar(255),
      km_price integer,
      seats integer,
      status varchar(255),
      primary key (id)
);


create table users (
       id integer not null AUTO_INCREMENT,
       email varchar(255),
       first_name varchar(255),
       last_name varchar(255),
       password varchar(255),
       role varchar(255),
       spent_money double precision,
       primary key (id)
);


create table orders (
        id integer not null AUTO_INCREMENT,
        date datetime,
        departure_address varchar(255),
        destination_address varchar(255),
        distance integer,
        passengers integer,
        price double precision (4, 2),
        car_id integer,
        user_id integer,
        primary key (id),
        CONSTRAINT user_id FOREIGN KEY (user_id)
            REFERENCES users(id),
        CONSTRAINT order_id FOREIGN KEY (car_id)
            REFERENCES cars(id)
);

insert into users (email, first_name, last_name, password, role, spent_money)
values ('a', 'admin', 'admin', 'a', 'ADMIN', 0),
       ('u', 'user', 'user', 'u', 'USER', 0),
       ('email@1myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@2myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@3myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@4myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@5myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@6myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@7myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@8myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@9myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@10myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@11myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10),
       ('email@12myEmail.com', 'first_name', 'last_name', 'password', 'USER', 10);


insert into cars (category, driver, km_price, seats, status)
values ('PREMIUM', 'driverName', 20, 3, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 3, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 3, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 5, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 5, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 5, 'AVAILABLE'),
       ('PREMIUM', 'driverName', 20, 7, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 3, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 3, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 3, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 5, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 5, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 5, 'AVAILABLE'),
       ('BUSINESS', 'driverName', 15, 7, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 3, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 3, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 3, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 5, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 5, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 5, 'AVAILABLE'),
       ('COMFORT', 'driverName', 10, 7, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 3, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 3, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 3, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 5, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 5, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 5, 'AVAILABLE'),
       ('STANDARD', 'driverName', 5, 7, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 3, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 3, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 3, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 5, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 5, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 5, 'AVAILABLE'),
       ('ECONOMY', 'driverName', 1, 7, 'AVAILABLE');


insert into orders (date, departure_address, destination_address, distance, passengers, price, car_id, user_id)
values (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1),
       (CURRENT_TIMESTAMP, 'departure_address', 'destination_address', RAND() * (100-5)+5, RAND() * (8-1)+1, RAND() * (100-5)+5, RAND() * (35-1)+1, RAND() * (14-1)+1);