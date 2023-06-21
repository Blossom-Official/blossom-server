package com.seoultech.blossom.api.service.flowersearch.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.content.dto.ContentSummaryInfo;
import com.seoultech.blossom.api.service.flower.dto.FlowerInfo;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerDocument;

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
public class FlowerSearchResponse {

	@Schema(description = "꽃 태그")
	private List<String> flowerTags;

	@Schema(description = "꽃")
	private List<FlowerInfo> flowers;

	@Schema(description = "컨텐츠")
	private List<ContentSummaryInfo> contentSummaryInfos;

	public static FlowerSearchResponse of(List<FlowerDocument> flowers) {
		return FlowerSearchResponse.builder()
			.flowerTags(flowers
				.stream()
				.flatMap(flower -> flower.getFlowerTags().stream())
				.distinct()
				.limit(5)
				.collect(Collectors.toList()))
			.flowers(flowers
				.stream()
				.map(FlowerInfo::of)
				.collect(Collectors.toList()))
			.contentSummaryInfos(flowers
				.stream()
				.flatMap(flower -> flower.getContentSummaryInfos()
					.stream()
					.map(ContentSummaryInfo::of))
				.distinct()
				.collect(Collectors.toList()))
			.build();
	}
}
