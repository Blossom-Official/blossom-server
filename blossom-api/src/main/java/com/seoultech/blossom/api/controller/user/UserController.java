package com.seoultech.blossom.api.controller.user;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.user.UserService;
import com.seoultech.blossom.api.service.user.dto.request.UpdateNicknameRequest;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

	private final UserService userService;

	@Operation(summary = "[인증] 프로필 사진 업데이트")
	@Auth
	@PutMapping(value = "/user/profile/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> updateProfileImage(
		@Parameter(description = "프로필 이미지", required = true)
		@RequestPart(name = "image") MultipartFile image,
		@UserId Long userId) {
		userService.updateProfileImage(image, userId);
		return ApiResponse.SUCCESS;
	}

	@Operation(summary = "[인증] 프로필 사진 기본이미지로 변경")
	@Auth
	@DeleteMapping("/user/profile/image")
	public ApiResponse<String> deleteProfileImage(@UserId Long userId) {
		userService.deleteProfileImage(userId);
		return ApiResponse.SUCCESS;
	}

	@Operation(summary = "[인증] 닉네임 변경")
	@Auth
	@PutMapping("/user/profile/nickname")
	public ApiResponse<String> updateNickname(
		@Valid @RequestBody UpdateNicknameRequest request,
		@UserId Long userId) {
		userService.updateNickname(request, userId);
		return ApiResponse.SUCCESS;
	}
}
