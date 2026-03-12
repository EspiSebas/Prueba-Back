package com.example.Prueba.Autos.service;

import com.example.Prueba.Autos.dto.auth.LoginDto;
import com.example.Prueba.Autos.dto.auth.RegisterDto;
import com.example.Prueba.Autos.entity.User;
import com.example.Prueba.Autos.repository.UserRepository;
import com.example.Prueba.Autos.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterDto registerDto){

        User registerUser = new User();
        registerUser.setName(registerDto.getName());
        registerUser.setEmail(registerDto.getEmail());
        registerUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(registerUser);

    }


    public String login(LoginDto loginDto){
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));


        if(!passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials");

        }

        return jwtService.generateToken(user.getEmail());

    }

}
