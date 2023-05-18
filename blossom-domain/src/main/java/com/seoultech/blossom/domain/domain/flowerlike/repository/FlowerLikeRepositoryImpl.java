package com.seoultech.blossom.domain.domain.flowerlike.repository;

import static com.seoultech.blossom.domain.domain.flowerlike.QFlowerLike.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;
import com.seoultech.blossom.domain.domain.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlowerLikeRepositoryImpl implements FlowerLikeRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public FlowerLike findFlowerLikeByUserAndFlower(User user, Flower flower) {
		return queryFactory
			.selectFrom(flowerLike)
			.where(
				flowerLike.user.eq(user),
				flowerLike.flower.eq(flower))
			.fetchOne();
	}
}
