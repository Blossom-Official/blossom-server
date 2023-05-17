package com.seoultech.blossom.api.controller.flower;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.service.flower.FlowerRetrieveService;
import com.seoultech.blossom.api.service.flower.dto.response.FlowerResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Flower")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerRetrieveController {

	private final FlowerRetrieveService flowerRetrieveService;

	@Operation(summary = "꽃 상세 조회")
	@GetMapping("/flower/{flowerId}")
	public ApiResponse<FlowerResponse> getFlowerById(
		@Parameter(description = "조회할 꽃의 id", required = true, example = "1") @PathVariable Long flowerId) {
		return ApiResponse.success(flowerRetrieveService.getFlowerById(flowerId));
	}
}
