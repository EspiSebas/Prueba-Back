package com.example.Prueba.Autos.service;

import com.example.Prueba.Autos.dto.car.CarRequestDto;
import com.example.Prueba.Autos.dto.car.CarResponseDto;
import com.example.Prueba.Autos.entity.Car;
import com.example.Prueba.Autos.entity.User;
import com.example.Prueba.Autos.repository.CarRepository;
import com.example.Prueba.Autos.repository.UserRepository;
import com.example.Prueba.Autos.security.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public void createCar(CarRequestDto request){

        String email = SecurityUtils.getEmail();

        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));



        Car carEntity = new Car();
        carEntity.setBrand(request.getBrand());
        carEntity.setModel(request.getModel());
        carEntity.setYear(request.getYear());
        carEntity.setNumberPlate(request.getNumberPlate());
        carEntity.setColor(request.getColor());
        carEntity.setUser(user);
        carRepository.save(carEntity);

    }


    public List<CarResponseDto> getAllCars(){
        String email = SecurityUtils.getEmail();

        User user = userRepository.findByEmail(email).orElseThrow();

        return carRepository.findAllByUserId(user.getId())
                .stream()
                .map(this::mapToDto)
                .toList();

    }

    public void deleteCar(Long id){
        String email = SecurityUtils.getEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();


        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Car not found"
        ));

        if (!car.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "You cannot update this car"
            );
        }
        carRepository.deleteById(id);
    }

    public void updateCar(Long id, CarRequestDto request){

        String email = SecurityUtils.getEmail();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();


        Car car = carRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"The car not found"));

        if (!car.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "You cannot update this car"
            );
        }

        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setColor(request.getColor());
        car.setNumberPlate(request.getNumberPlate());


        carRepository.save(car);

    }

    private CarResponseDto mapToDto(Car car){

        CarResponseDto dto = new CarResponseDto();

        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setColor(car.getColor());
        dto.setYear(car.getYear());
        dto.setNumberPlate(car.getNumberPlate());

        return dto;
    }

}



