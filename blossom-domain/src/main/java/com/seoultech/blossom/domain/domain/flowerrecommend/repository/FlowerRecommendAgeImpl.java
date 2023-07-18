package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendAge.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerAge;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendAge;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendAgeImpl implements FlowerRecommendAgeCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendAge> findFlowerRecommendAgesByAge(FlowerAge age) {
		return queryFactory
			.selectFrom(flowerRecommendAge)
			.where(flowerRecommendAge.age.eq(age))
			.fetch();
	}
}
