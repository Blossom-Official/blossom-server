package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import static com.seoultech.blossom.domain.domain.flowerrecommend.QFlowerRecommendRelationship.*;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendRelationship;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRelationship;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRecommendRelationshipImpl implements FlowerRecommendRelationshipCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<FlowerRecommendRelationship> findFlowerRecommendRelationshipsByRelationship(
		FlowerRelationship relationship) {
		return queryFactory
			.selectFrom(flowerRecommendRelationship)
			.where(flowerRecommendRelationship.relationship.eq(relationship))
			.fetch();
	}
}
