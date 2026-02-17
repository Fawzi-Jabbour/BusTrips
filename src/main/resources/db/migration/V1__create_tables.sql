create table buses
(
    id            int auto_increment
        primary key,
    plate_number  BIGINT                              not null,
    bus_number    int                                not null,
    description   int                                not null,
    seat_capacity int                                not null,
    status        varchar(50)                        not null,
    created_at    datetime default current_timestamp not null
);

CREATE TABLE seats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bus_id INT NOT NULL,
     seat_number INT NOT NULL,

    CONSTRAINT seat_bus_fk
        FOREIGN KEY (bus_id) REFERENCES buses (id)
            ON DELETE CASCADE,

    CONSTRAINT unique_bus_seat
        UNIQUE (bus_id, seat_number)
);
create table destinations
(
    id         int auto_increment
        primary key,
    name       varchar(50)                        not null,
    code       varchar(10)                        not null,
    created_at datetime default current_timestamp not null
);
create table trips
(
    id              int auto_increment
        primary key,
    bus_id          int                                not null,
    origin_id       int                                not null,
    destination_id  int                                not null,
    departure_date  datetime                           not null,
    seats_available int                                not null,
    status          varchar(50)                        not null,
    price           decimal(10,2)                      not null,
    created_at      datetime default current_timestamp not null,

    constraint trips_buses_id_fk
        foreign key (bus_id) references buses (id),
    constraint trips_destinations__fk
        foreign key (destination_id) references destinations (id),
    constraint trips_origin_fk
        foreign key (origin_id) references destinations (id),

    constraint trips_route_check
        check  (origin_id <> destination_id),

    constraint trips_seats_check
        check  (seats_available >= 0)

);
create table membershipplans
(
    id                      int auto_increment
        primary key,
    name                    varchar(255) not null,
    discount_percentage     int          not null,
    regestration_fee        decimal      not null,
    max_active_reservations int          not null
);
create table members (

    id INT AUTO_INCREMENT PRIMARY KEY,

    membership_plan_id INT NOT NULL,

    full_name VARCHAR(255) NOT NULL,

    national_id             VARCHAR(50)    NOT NULL,
    card_number             VARCHAR(50)    NOT NULL,

    age                     INT            NOT NULL,

    has_medical_condition   BOOLEAN        NOT NULL,
    medical_con_description VARCHAR(255),

    phone_number            VARCHAR(20)    NOT NULL,

    balance                 DECIMAL(10, 2) NOT NULL DEFAULT 0.00,

    created_at              DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT members_membershipplans_fk
        FOREIGN KEY (membership_plan_id)
            REFERENCES membershipplans (id),

    CONSTRAINT unique_national_id UNIQUE (national_id),
    CONSTRAINT unique_card_number UNIQUE (card_number),
    CONSTRAINT unique_phone UNIQUE (phone_number),

    CONSTRAINT age_check CHECK (age > 0),

    CONSTRAINT balance_check CHECK (balance >= 0)
);
CREATE TABLE passengers (
     id            BIGINT AUTO_INCREMENT PRIMARY KEY,

     full_name               VARCHAR(255) NOT NULL,

     date_of_birth           DATE         NOT NULL,

     phone_number            VARCHAR(20)  NOT NULL,

     has_medical_condition   BOOLEAN      NOT NULL,
     medical_con_description VARCHAR(255),

     created_at              DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT medical_condition_check
         CHECK (
             (has_medical_condition = 1 AND medical_con_description IS NOT NULL)
                 OR
             (has_medical_condition = 0 AND medical_con_description IS NULL)
             )
);



CREATE TABLE reservations (
      id CHAR(36) PRIMARY KEY DEFAULT (UUID()),

      trip_id        INT         NOT NULL,
      seat_id        INT         NOT NULL,

      member_id      INT      NULL,
      passenger_id   BIGINT      NULL,

      payment_method VARCHAR(50) NOT NULL,
      payment_status VARCHAR(50) NOT NULL,
      status         VARCHAR(50) NOT NULL,

      created_at     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,

      CONSTRAINT reservations_trip_seat_unique
          UNIQUE (trip_id, seat_id),

      CONSTRAINT reservations_member_or_passenger_check
          CHECK (
              (member_id IS NOT NULL AND passenger_id IS NULL)
                  OR
              (member_id IS NULL AND passenger_id IS NOT NULL)
              ),

      CONSTRAINT reservations_seat_fk
          FOREIGN KEY (seat_id) REFERENCES seats (id),

      CONSTRAINT reservations_member_fk
          FOREIGN KEY (member_id) REFERENCES members (id),

      CONSTRAINT reservations_passenger_fk
          FOREIGN KEY (passenger_id) REFERENCES passengers (id),

      CONSTRAINT reservations_trip_fk
          FOREIGN KEY (trip_id) REFERENCES trips (id)
);


