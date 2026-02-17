package com.fawzi.org.bustrips.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "departure_date",nullable = false)
    private LocalDateTime departureDate;

    @Column(name = "seats_available",nullable = false)
    private Integer seatsAvailable;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private TripStatus status;


    @Column(name = "price", precision = 10, scale = 2,nullable = false)
    private BigDecimal price;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_id")
    private Destination origin;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
