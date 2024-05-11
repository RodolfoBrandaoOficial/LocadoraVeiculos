package com.rodolfobrandao.aulajavacollectionsproject.controllers;

import com.rodolfobrandao.aulajavacollectionsproject.config.TokenService;
import com.rodolfobrandao.aulajavacollectionsproject.models.user.*;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutheticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (data.password() == null || data.password().isEmpty()) {
            return ResponseEntity.badRequest().body("A senha não pode ser nula ou vazia");
        }

        if (this.repository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
//        User newUser = new User(data.login(), encryptedPassword, UserRole.USER); // ou UserRole.ADMIN, dependendo do caso

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
