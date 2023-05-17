package com.seoultech.blossom.api.controller.auth;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.auth.AuthService;
import com.seoultech.blossom.api.service.auth.AuthServiceProvider;
import com.seoultech.blossom.api.service.auth.CommonAuthService;
import com.seoultech.blossom.api.service.auth.CreateTokenService;
import com.seoultech.blossom.api.service.auth.dto.request.LoginRequestDto;
import com.seoultech.blossom.api.service.auth.dto.request.SignUpRequestDto;
import com.seoultech.blossom.api.service.auth.dto.request.TokenRequestDto;
import com.seoultech.blossom.api.service.auth.dto.response.TokenResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Auth")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

	private final AuthServiceProvider authServiceProvider;
	private final CreateTokenService createTokenService;
	private final CommonAuthService commonAuthService;

	@Operation(summary = "카카오 소셜 회원가입")
	@PostMapping("/auth/signup")
	public ApiResponse<TokenResponse> signUp(@Valid @RequestBody SignUpRequestDto request) {
		AuthService authService = authServiceProvider.getAuthService(request.getSocialType());
		Long userId = authService.signUp(request);
		TokenResponse tokenInfo = createTokenService.createTokenInfo(userId);
		return ApiResponse.success(tokenInfo);
	}

	@Operation(summary = "카카오 소셜 로그인")
	@PostMapping("/auth/login")
	public ApiResponse<TokenResponse> login(@Valid @RequestBody LoginRequestDto request) {
		AuthService authService = authServiceProvider.getAuthService(request.getSocialType());
		Long userId = authService.login(request);
		TokenResponse tokenInfo = createTokenService.createTokenInfo(userId);
		return ApiResponse.success(tokenInfo);
	}

	@Operation(summary = "[인증] 로그아웃")
	@Auth
	@PostMapping("/auth/logout")
	public ApiResponse<String> logout(@UserId Long userId) {
		commonAuthService.logout(userId);
		return ApiResponse.SUCCESS;
	}

	@Operation(summary = "JWT 토큰 갱신")
	@PostMapping("/auth/reissue")
	public ApiResponse<TokenResponse> reissue(@Valid @RequestBody TokenRequestDto request) {
		return ApiResponse.success(createTokenService.reissueToken(request));
	}
}
