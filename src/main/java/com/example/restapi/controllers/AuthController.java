package com.example.restapi.controllers;

import com.example.restapi.models.User;
import com.example.restapi.repositories.UserRepository;
import com.example.restapi.services.JwtService;
import com.example.restapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService, UserRepository userRepository, JwtService jwtService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User storedUser = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (storedUser == null || !passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
            return ResponseEntity.status(401).body("Credenciais inválidas!");
        }
        String token = jwtService.generateToken(storedUser.getUsername());
        return ResponseEntity.ok(token);
    }
}
