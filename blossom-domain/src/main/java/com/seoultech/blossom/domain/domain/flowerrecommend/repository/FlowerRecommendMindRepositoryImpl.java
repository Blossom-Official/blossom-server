package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendMind.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerMind;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendMind;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendMindRepositoryImpl implements FlowerRecommendMindRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendMind> findFlowerRecommendMindsByMind(FlowerMind mind) {
		return queryFactory
			.selectFrom(flowerRecommendMind)
			.where(flowerRecommendMind.mind.eq(mind))
			.fetch();
	}
}
