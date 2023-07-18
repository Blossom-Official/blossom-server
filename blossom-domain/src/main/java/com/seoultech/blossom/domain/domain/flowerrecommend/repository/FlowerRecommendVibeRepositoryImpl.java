package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendVibe.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendVibe;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerVibe;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendVibeRepositoryImpl implements FlowerRecommendVibeRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendVibe> findFlowerRecommendVibesByVibe(FlowerVibe vibe) {
		return queryFactory
			.selectFrom(flowerRecommendVibe)
			.where(flowerRecommendVibe.vibe.eq(vibe))
			.fetch();
	}
}
