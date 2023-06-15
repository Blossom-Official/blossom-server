package com.seoultech.blossom.domain.domain.flowersearch.repository;

import static com.seoultech.blossom.domain.domain.flowersearch.QFlowerHit.*;

import java.util.List;

import javax.persistence.LockModeType;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerHitRepositoryImpl implements FlowerHitRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public FlowerHit findFlowerHitByFlower(Flower flower) {
		return queryFactory
			.selectFrom(flowerHit)
			.where(flowerHit.flower.eq(flower))
			.setLockMode(LockModeType.PESSIMISTIC_WRITE)
			.fetchOne();
	}

	@Override
	public List<FlowerHit> findFlowerHitsOrderByCountAndModifiedAt() {
		return queryFactory
			.selectFrom(flowerHit)
			.orderBy(flowerHit.count.desc(), flowerHit.modifiedAt.desc())
			.fetch();
	}
}
