package com.seoultech.blossom.api.service.flowersearch.dto.response;

import java.util.List;

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
public class PopularResponse {

	@Schema(description = "인기 검색어")
	private List<String> populars;

	public static PopularResponse of(List<String> populars) {
		return PopularResponse.builder()
			.populars(populars)
			.build();
	}
}
