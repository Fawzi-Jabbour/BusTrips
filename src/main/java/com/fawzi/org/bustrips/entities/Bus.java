package com.fawzi.org.bustrips.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "plate_number",nullable = false)
    private Long plateNumber;

    @Column(name = "bus_number",nullable = false)
    private Integer busNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "seat_capacity",nullable = false)
    private int seatCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private BusStatus status;

    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
