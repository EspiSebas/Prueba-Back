package com.example.Prueba.Autos.dto.car;


import com.example.Prueba.Autos.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String  numberPlate;
    private String color;

}
