package com.seoultech.blossom.domain.domain.flower;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerCategory {

	CELEBRATE("축하"),
	THANKS("감사"),
	LOVE("사랑"),
	CHEERING("응원");

	private final String value;
}
