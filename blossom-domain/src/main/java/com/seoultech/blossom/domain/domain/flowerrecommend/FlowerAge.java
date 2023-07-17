package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerAge {

	TWENTY("20대"),
	THIRTY("30대"),
	FORTY("40대"),
	ABOVE("그 이상");

	private final String value;
}
