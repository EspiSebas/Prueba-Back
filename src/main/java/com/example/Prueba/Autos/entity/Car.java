package com.example.Prueba.Autos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int model;
    private String year;
    private String  numberPlate;
    private String color;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
