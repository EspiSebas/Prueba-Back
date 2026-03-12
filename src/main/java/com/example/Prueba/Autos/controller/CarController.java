package com.example.Prueba.Autos.controller;

import com.example.Prueba.Autos.dto.car.CarRequestDto;
import com.example.Prueba.Autos.dto.car.CarResponseDto;
import com.example.Prueba.Autos.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Void> createCar(@RequestBody CarRequestDto requestDto){
        carService.createCar(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCar(@PathVariable Long id, @RequestBody CarRequestDto requestDto){
        carService.updateCar(id,requestDto);
        return ResponseEntity.ok("Updated correctly");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return ResponseEntity.ok("Deleted correctly");

    }


}
