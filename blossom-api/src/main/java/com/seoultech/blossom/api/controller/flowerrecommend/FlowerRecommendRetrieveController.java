package com.seoultech.blossom.api.controller.flowerrecommend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.config.interceptor.auth.Auth;
import com.seoultech.blossom.api.config.resolver.UserId;
import com.seoultech.blossom.api.service.flowerrecommend.FlowerRecommendRetrieveService;
import com.seoultech.blossom.api.service.flowerrecommend.dto.response.FlowerRecommendResponse;
import com.seoultech.blossom.common.dto.ApiResponse;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerAge;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerColor;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerMind;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRelationship;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerVibe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "FlowerRecommend")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerRecommendRetrieveController {

	private final FlowerRecommendRetrieveService flowerRecommendRetrieveService;

	@Operation(summary = "[인증] 꽃 추천")
	@Auth
	@GetMapping("/flower-recommend/flower")
	public ApiResponse<FlowerRecommendResponse> recommendFlower(
		@Parameter(description = "관계", required = true, example = "FRIEND") @RequestParam FlowerRelationship relationship,
		@Parameter(description = "나이", required = true, example = "TWENTY") @RequestParam FlowerAge age,
		@Parameter(description = "마음", required = true, example = "GREETING") @RequestParam FlowerMind mind,
		@Parameter(description = "색", required = true, example = "RED_ORANGE") @RequestParam FlowerColor color,
		@Parameter(description = "분위기", required = true, example = "COLD_HAUGHTY") @RequestParam FlowerVibe vibe,
		@UserId Long userId
	) {
		return ApiResponse.success(
			flowerRecommendRetrieveService.recommendFlower(relationship, age, mind, color, vibe, userId));
	}
}
