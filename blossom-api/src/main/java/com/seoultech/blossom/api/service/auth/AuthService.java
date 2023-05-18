package com.seoultech.blossom.api.service.auth;

import com.seoultech.blossom.api.service.auth.dto.request.LoginRequest;
import com.seoultech.blossom.api.service.auth.dto.request.SignUpRequest;

public interface AuthService {

	Long signUp(SignUpRequest request);

	Long login(LoginRequest request);
}
