package com.seoultech.blossom.domain.domain.flowerrecommend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlowerRelationship {

	FRIEND("친구"),
	LOVER("연인"),
	FAMILY("가족"),
	ACQUAINTANCE("지인");

	private final String value;
}
