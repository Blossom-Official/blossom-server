package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendColor.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerColor;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendColor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendColorRepositoryImpl implements FlowerRecommendColorRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendColor> findFlowerRecommendColorsByColor(FlowerColor color) {
		return queryFactory
			.selectFrom(flowerRecommendColor)
			.where(flowerRecommendColor.color.eq(color))
			.fetch();
	}
}
