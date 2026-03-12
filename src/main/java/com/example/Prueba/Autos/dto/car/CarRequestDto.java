package com.example.Prueba.Autos.dto.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CarRequestDto {
    private String brand;
    private int model;
    private String year;
    private String  numberPlate;
    private String color;

}
