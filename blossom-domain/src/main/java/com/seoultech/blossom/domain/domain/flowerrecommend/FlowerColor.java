package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerColor {

	RED_ORANGE("빨강, 주황"),
	YELLOW("노랑"),
	GREEN("초록"),
	BLUE_PURPLE("파랑, 보라"),
	PINK("분홍"),
	ACHROMATIC("무채색");

	private final String value;
}
