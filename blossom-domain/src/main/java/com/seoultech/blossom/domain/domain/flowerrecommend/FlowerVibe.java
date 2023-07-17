package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerVibe {

	COLD_HAUGHTY("차갑고 도도한"),
	BRIGHT_LOVELY("밝고 사랑스러움"),
	QUIET_CALM("조용하고 차분한"),
	ACTIVE("활동적인");

	private final String value;
}
