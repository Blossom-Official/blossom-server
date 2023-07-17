package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendVibeRepositoryImpl implements FlowerRecommendVibeRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}
