package com.example.Prueba.Autos.controller;

import com.example.Prueba.Autos.dto.car.CarRequestDto;
import com.example.Prueba.Autos.dto.car.CarResponseDto;
import com.example.Prueba.Autos.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/all")
    public List<CarResponseDto> getAll(){
        return carService.getAllCars();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCar(@Valid @RequestBody CarRequestDto requestDto){
        carService.createCar(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@Valid @PathVariable Long id, @RequestBody CarRequestDto requestDto){
        carService.updateCar(id,requestDto);
        return ResponseEntity.ok(Map.of("message","Updated correctly"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return ResponseEntity.ok(Map.of("message","Deleted correctly"));

    }


}
