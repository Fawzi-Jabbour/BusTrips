package com.fawzi.org.bustrips.repositories;

import com.fawzi.org.bustrips.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus,Integer> {

    boolean existsByPlateNumber(Long plateNumber);

    boolean existsByBusNumber(int busNumber);

    Optional<Bus> findByPlateNumber(Long plateNumber);

    boolean existsByBusNumberAndIdNot(Integer busNumber, Integer id);
}
