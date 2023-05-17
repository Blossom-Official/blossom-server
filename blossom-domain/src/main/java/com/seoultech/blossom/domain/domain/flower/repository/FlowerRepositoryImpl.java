package com.seoultech.blossom.domain.domain.flower.repository;

import static com.seoultech.blossom.domain.domain.flower.QFlower.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flower.Flower;

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
}
