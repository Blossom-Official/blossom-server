package com.seoultech.blossom.api.controller.flowersearch;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.service.flowersearch.FlowerSearchService;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "FlowerSearch")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FlowerSearchController {

	private final FlowerSearchService flowerSearchService;

	@Operation(summary = "[배치] Flower Document 생성")
	@PostMapping("/flower-search/flower-documents")
	public ApiResponse<String> saveFlowerDocuments() {
		flowerSearchService.saveFlowerDocuments();
		return ApiResponse.SUCCESS;
	}

}
