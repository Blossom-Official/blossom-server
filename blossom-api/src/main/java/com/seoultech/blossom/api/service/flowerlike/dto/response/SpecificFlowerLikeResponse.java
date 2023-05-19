package com.seoultech.blossom.api.service.flowerlike.dto.response;

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
public class SpecificFlowerLikeResponse {

	@Schema(description = "체크 - true, 해제 - false")
	private Boolean isCheck;

	public static SpecificFlowerLikeResponse of(boolean isCheck) {
		return SpecificFlowerLikeResponse.builder()
			.isCheck(isCheck)
			.build();
	}
}
