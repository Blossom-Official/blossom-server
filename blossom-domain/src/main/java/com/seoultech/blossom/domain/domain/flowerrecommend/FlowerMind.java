package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerMind {

	GREETING("인사"),
	RESPECT("존경"),
	THANKS("감사"),
	LOVE("사랑"),
	CONSOLATION("위로"),
	NONE("딱히 없음");

	private final String value;
}
