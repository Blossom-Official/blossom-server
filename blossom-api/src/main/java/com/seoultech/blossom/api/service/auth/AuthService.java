package com.seoultech.blossom.api.service.auth;

import com.seoultech.blossom.api.service.auth.dto.request.LoginRequestDto;
import com.seoultech.blossom.api.service.auth.dto.request.SignUpRequestDto;

public interface AuthService {

	Long signUp(SignUpRequestDto request);

	Long login(LoginRequestDto request);
}
