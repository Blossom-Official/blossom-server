package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendAgeImpl implements FlowerRecommendAgeCustom {

	private final JPAQueryFactory queryFactory;

}
