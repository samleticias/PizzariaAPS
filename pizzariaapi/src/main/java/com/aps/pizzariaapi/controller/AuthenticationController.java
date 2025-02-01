package com.aps.pizzariaapi.controller;

import com.aps.pizzariaapi.dto.AuthenticationDTO;
import com.aps.pizzariaapi.dto.LoginResponseDTO;
import com.aps.pizzariaapi.dto.UserRegisterDTO;
import com.aps.pizzariaapi.entity.User;
import com.aps.pizzariaapi.entity.UserRole;
import com.aps.pizzariaapi.service.TokenJWTService;
import com.aps.pizzariaapi.service.UserService;
import com.aps.pizzariaapi.service.exception.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenJWTService tokenJWTService;
    private UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenJWTService tokenJWTService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenJWTService = tokenJWTService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authenticate = this.authenticationManager.authenticate(usernamePassword);
        String token = this.tokenJWTService.generateToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterDTO request) throws UserAlreadyExistsException {
        String password = new BCryptPasswordEncoder().encode(request.password());
        User user = new User(request.username(), password, UserRole.ADMIN);
        user = this.userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }
}
