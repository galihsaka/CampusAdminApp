package com.enigmacamp.campusadminapp.service;

import com.enigmacamp.campusadminapp.dto.request.LoginRequest;
import com.enigmacamp.campusadminapp.dto.request.RegisterRequest;
import com.enigmacamp.campusadminapp.dto.response.LoginResponse;
import com.enigmacamp.campusadminapp.dto.response.RegisterResponse;

public interface AuthService {
    public RegisterResponse register(RegisterRequest request);
    public LoginResponse login(LoginRequest request);
}
