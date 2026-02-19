package com.fawzi.org.bustrips.repositories;

import com.fawzi.org.bustrips.entities.Trip;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Integer> {
    @EntityGraph(attributePaths = {"origin", "destination", "bus"})
    List<Trip> findAll();
}
