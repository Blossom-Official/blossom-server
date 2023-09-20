package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendSeason.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendSeason;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerSeason;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendSeasonRepositoryImpl implements FlowerRecommendSeasonRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendSeason> findFlowerRecommendSeasonsBySeason(FlowerSeason season) {
		return queryFactory
			.selectFrom(flowerRecommendSeason)
			.where(flowerRecommendSeason.season.eq(season))
			.fetch();
	}
}
