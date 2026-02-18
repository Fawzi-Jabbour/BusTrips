package com.fawzi.org.bustrips.repositories;

import com.fawzi.org.bustrips.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    boolean existsByBusIdAndSeatNumber(Integer busId, Integer seatNumber);
}
