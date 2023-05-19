package com.seoultech.blossom.api.controller.flowerlike;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.flowerlike.FlowerLikeRetrieveService;
import com.seoultech.blossom.api.service.flowerlike.dto.response.FlowerLikeResponse;
import com.seoultech.blossom.api.service.flowerlike.dto.response.SpecificFlowerLikeResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "FlowerLike")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerLikeRetrieveController {

	private final FlowerLikeRetrieveService flowerLikeRetrieveService;

	@Operation(summary = "[인증] 특정 꽃 좋아요 조회")
	@Auth
	@GetMapping("/flower-like/flower/{flowerId}")
	public ApiResponse<SpecificFlowerLikeResponse> getSpecificFlowerLike(
		@Parameter(description = "좋아요 상태 조회할 꽃의 id", required = true, example = "1") @PathVariable Long flowerId,
		@UserId Long userId) {
		return ApiResponse.success(flowerLikeRetrieveService.getSpecificFlowerLike(flowerId, userId));
	}

	@Operation(summary = "[인증] 전체 꽃 좋아요 조회")
	@Auth
	@GetMapping("/flower-like/flower")
	public ApiResponse<FlowerLikeResponse> getFlowerLike(@UserId Long userId) {
		return ApiResponse.success(flowerLikeRetrieveService.getFlowerLike(userId));
	}
}
