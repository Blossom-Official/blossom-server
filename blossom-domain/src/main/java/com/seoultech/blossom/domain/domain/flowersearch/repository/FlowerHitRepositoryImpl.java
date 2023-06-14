package com.seoultech.blossom.domain.domain.flowersearch.repository;

import static com.seoultech.blossom.domain.domain.flowersearch.QFlowerHit.*;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerHitRepositoryImpl implements FlowerHitRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public FlowerHit findFlowerHitByFlower(Flower flower) {
		return queryFactory
			.selectFrom(flowerHit)
			.where(flowerHit.flower.eq(flower))
			.fetchOne();
	}
}
