package com.example.Prueba.Autos.repository;

import com.example.Prueba.Autos.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findByUserId(Long id);
    List<Car> findAllByUserId(Long id);
}
