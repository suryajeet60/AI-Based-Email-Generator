package com.AIBased.Email_Generator.service.impl;

import com.AIBased.Email_Generator.dto.LoginRequest;
import com.AIBased.Email_Generator.dto.LoginResponse;
import com.AIBased.Email_Generator.dto.RegisterRequest;
import com.AIBased.Email_Generator.dto.RegisterResponse;
import com.AIBased.Email_Generator.entity.User;
import com.AIBased.Email_Generator.repository.UserRepository;
import com.AIBased.Email_Generator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{

    private final UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest request)
    {

        if (userRepository.existsByEmail(request.getEmail()))
        {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponse.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .message("Registration Successful")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request)
    {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword()))
        {
            throw new RuntimeException("Invalid Password");
        }

        return LoginResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .message("Login Successful")
                .build();
    }

    @Override
    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
