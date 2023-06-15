package com.seoultech.blossom.api.service.flowersearch.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.flower.dto.FlowerInfo;
import com.seoultech.blossom.domain.domain.flower.FlowerDocument;

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

	@Schema(description = "총 개수")
	private int totalCount;

	@Schema(description = "꽃")
	private List<FlowerInfo> flowers;

	public static FlowerSearchResponse of(List<FlowerDocument> flowers) {
		return FlowerSearchResponse.builder()
			.totalCount(flowers.size())
			.flowers(flowers
				.stream()
				.map(FlowerInfo::of)
				.collect(Collectors.toList()))
			.build();
	}
}
