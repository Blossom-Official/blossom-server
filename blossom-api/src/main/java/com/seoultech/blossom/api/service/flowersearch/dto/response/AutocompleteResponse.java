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
public class AutocompleteResponse {

	@Schema(description = "자동완성 검색어")
	private List<String> autocompletes;

	public static AutocompleteResponse of(List<String> autocompletes) {
		return AutocompleteResponse.builder()
			.autocompletes(autocompletes)
			.build();
	}
}
