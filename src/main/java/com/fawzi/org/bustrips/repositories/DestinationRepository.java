package com.fawzi.org.bustrips.repositories;

import com.fawzi.org.bustrips.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination,Integer> {
    Optional<Destination> findByCode(String code);

    boolean existsByCode(String code);
}
