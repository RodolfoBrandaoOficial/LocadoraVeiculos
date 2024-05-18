package com.rodolfobrandao.aulajavacollectionsproject.controllers.auth;

import com.rodolfobrandao.aulajavacollectionsproject.config.auth.TokenService;
import com.rodolfobrandao.aulajavacollectionsproject.models.advice.ErrorResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.user.*;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.status;

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
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            // Tratamento de outros erros. Retornamos um erro genérico em formato JSON.
            ErrorResponse errorResponse = new ErrorResponse("Erro durante a autenticação");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (data.password() == null || data.password().isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("A senha é obrigatória");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        if (this.repository.findByLogin(data.login()) != null) {
            ErrorResponse errorResponse = new ErrorResponse("O usuário " + data.login() + " já existe");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
//        User newUser = new User(data.login(), encryptedPassword, UserRole.USER); // ou UserRole.ADMIN, dependendo do caso

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
