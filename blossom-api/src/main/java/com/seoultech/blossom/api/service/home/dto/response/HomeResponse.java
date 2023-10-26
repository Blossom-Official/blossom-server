package com.seoultech.blossom.api.service.home.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.content.dto.ContentSummaryInfo;
import com.seoultech.blossom.api.service.flower.dto.FlowerInfo;
import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.flower.Flower;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class HomeResponse {

	@Schema(description = "컨텐츠")
	private List<ContentSummaryInfo> contents;

	@Schema(description = "인기 꽃")
	private List<FlowerInfo> flowers;

	public static HomeResponse of(List<Content> contents, List<Flower> flowers) {
		return HomeResponse.builder()
			.contents(contents
				.stream()
				.map(content -> ContentSummaryInfo.of(content, true))
				.collect(Collectors.toList()))
			.flowers(flowers
				.stream()
				.map(FlowerInfo::of)
				.collect(Collectors.toList()))
			.build();
	}
}
