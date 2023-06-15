package com.seoultech.blossom.api.controller.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.service.home.HomeRetrieveService;
import com.seoultech.blossom.api.service.home.dto.response.HomeResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Home")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HomeRetrieveController {

	private final HomeRetrieveService homeRetrieveService;

	@Operation(summary = "홈 조회")
	@GetMapping("/home")
	public ApiResponse<HomeResponse> getHomeInfo() {
		return ApiResponse.success(homeRetrieveService.getHomeInfo());
	}
}
