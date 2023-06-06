package com.seoultech.blossom.api.controller.content;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoultech.blossom.api.service.content.ContentRetrieveService;
import com.seoultech.blossom.api.service.content.dto.response.ContentResponse;
import com.seoultech.blossom.common.dto.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Content")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ContentRetrieveController {

	private final ContentRetrieveService contentRetrieveService;

	@Operation(summary = "컨텐츠 상세 조회")
	@GetMapping("/content/{contentId}")
	public ApiResponse<ContentResponse> getContentById(
		@Parameter(description = "조회할 컨텐츠의 id", required = true, example = "1") @PathVariable Long contentId) {
		return ApiResponse.success(contentRetrieveService.getContentById(contentId));
	}
}
