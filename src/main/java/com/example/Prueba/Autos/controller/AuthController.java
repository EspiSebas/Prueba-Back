package com.example.Prueba.Autos.controller;

import com.example.Prueba.Autos.dto.auth.AuthResponse;
import com.example.Prueba.Autos.dto.auth.LoginDto;
import com.example.Prueba.Autos.dto.auth.RegisterDto;
import com.example.Prueba.Autos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterDto req){
        authService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginDto req){
        String token = authService.login(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
