package com.seoultech.blossom.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.user.UserRetrieveService;
import com.seoultech.blossom.api.service.user.dto.response.ProfileResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserRetrieveController {

	private final UserRetrieveService userRetrieveService;

	@Operation(summary = "[인증] 프로필 조회")
	@Auth
	@GetMapping("/user/profile")
	public ApiResponse<ProfileResponse> getProfile(@UserId Long userId) {
		return ApiResponse.success(userRetrieveService.getProfile(userId));
	}
}
