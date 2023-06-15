package com.seoultech.blossom.api.controller.flowersearch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.service.flowersearch.FlowerSearchRetrieveService;
import com.seoultech.blossom.api.service.flowersearch.dto.response.FlowerSearchResponse;
import com.seoultech.blossom.api.service.flowersearch.dto.response.PopularResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "FlowerSearch")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerSearchRetrieveController {

	private final FlowerSearchRetrieveService flowerSearchRetrieveService;

	@Operation(summary = "꽃 검색")
	@GetMapping("/flower-search/flowers")
	public ApiResponse<FlowerSearchResponse> searchFlowers(
		@Parameter(description = "검색어", required = false, example = "꽃") @RequestParam String searchText
	) {
		return ApiResponse.success(flowerSearchRetrieveService.searchFlowers(searchText));
	}

	@Operation(summary = "인기 검색어 조회")
	@GetMapping("/flower-search/popular")
	public ApiResponse<PopularResponse> getPopular() {
		return ApiResponse.success(flowerSearchRetrieveService.getPopular());
	}
}
