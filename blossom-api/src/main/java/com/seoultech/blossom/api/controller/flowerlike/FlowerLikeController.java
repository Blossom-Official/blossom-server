package com.seoultech.blossom.api.controller.flowerlike;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.flowerlike.FlowerLikeService;
import com.seoultech.blossom.api.service.flowerlike.dto.request.CheckFlowerLikeRequest;
import com.seoultech.blossom.api.service.flowerlike.dto.request.DeleteFlowerLikeRequest;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "FlowerLike")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerLikeController {

	private final FlowerLikeService flowerLikeService;

	@Operation(summary = "[인증] 꽃 좋아요 체크/해제")
	@Auth
	@PostMapping("/flower-like/flower/{flowerId}")
	public ApiResponse<String> checkFlowerLike(
		@Valid @RequestBody CheckFlowerLikeRequest request,
		@Parameter(description = "체크/해제 할 꽃의 id", required = true, example = "1") @PathVariable Long flowerId,
		@UserId Long userId) {
		flowerLikeService.checkFlowerLike(request, flowerId, userId);
		return ApiResponse.SUCCESS;
	}

	@Operation(summary = "[인증] 꽃 좋아요 다중 삭제")
	@Auth
	@DeleteMapping("/flower-like/flower")
	public ApiResponse<String> deleteFlowerLike(
		@Valid @RequestBody DeleteFlowerLikeRequest request,
		@UserId Long userId) {
		flowerLikeService.deleteFlowerLike(request, userId);
		return ApiResponse.SUCCESS;
	}
}
