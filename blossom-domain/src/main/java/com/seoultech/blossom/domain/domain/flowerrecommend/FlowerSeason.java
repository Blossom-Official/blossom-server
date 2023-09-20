package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerSeason {

	SPRING("봄"),
	SUMMER("여름"),
	AUTUMN("가을"),
	WINTER("겨울");

	private final String value;
}
