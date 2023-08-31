package com.seoultech.blossom.domain.domain.flower.repository;

import static com.seoultech.blossom.domain.domain.flower.QFlower.*;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerCategory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerRepositoryImpl implements FlowerRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Flower findFlowerById(Long id) {
		return queryFactory
			.selectFrom(flower)
			.where(flower.id.eq(id))
			.fetchOne();
	}

	@Override
	public List<Flower> findFlowersByCategory(FlowerCategory category) {
		return queryFactory
			.selectFrom(flower)
			.where(eqCategory(category))
			.fetch();
	}

	private BooleanExpression eqCategory(FlowerCategory category) {
		if (category == FlowerCategory.ALL) {
			return null;
		}
		return flower.category.eq(category);
	}
}
