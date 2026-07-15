package com.AIBased.Email_Generator.service;

import com.AIBased.Email_Generator.dto.LoginRequest;
import com.AIBased.Email_Generator.dto.LoginResponse;
import com.AIBased.Email_Generator.dto.RegisterRequest;
import com.AIBased.Email_Generator.dto.RegisterResponse;
import com.AIBased.Email_Generator.entity.User;

public interface UserService
{

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    User getUserById(Long id);
}
