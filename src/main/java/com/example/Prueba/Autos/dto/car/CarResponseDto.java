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
    private int model;
    private String year;
    private String  numberPlate;
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CarResponseDto(Long id, String brand, int model, String year, String numberPlate, String color) {
    }
}
