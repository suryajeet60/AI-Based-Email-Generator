package com.AIBased.Email_Generator.controller;

import com.AIBased.Email_Generator.dto.LoginRequest;
import com.AIBased.Email_Generator.dto.LoginResponse;
import com.AIBased.Email_Generator.dto.RegisterRequest;
import com.AIBased.Email_Generator.dto.RegisterResponse;
import com.AIBased.Email_Generator.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController
{

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request)
    {

        RegisterResponse response =
                userService.register(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request)
    {

        LoginResponse response = userService.login(request);

        return ResponseEntity.ok(response);
    }
}
