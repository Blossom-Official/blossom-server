package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendMindRepositoryImpl implements FlowerRecommendMindRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}
