package com.seoultech.blossom.domain.domain.user.repository;

import static com.seoultech.blossom.domain.domain.user.QUser.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.UserSocialType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public boolean existsBySocialIdAndSocialType(String socialId, UserSocialType socialType) {
		return queryFactory.selectOne()
			.from(user)
			.where(
				user.socialInfo.socialId.eq(socialId),
				user.socialInfo.socialType.eq(socialType)
			)
			.fetchFirst() != null;
	}

	@Override
	public User findUserById(Long id) {
		return queryFactory
			.selectFrom(user)
			.where(user.id.eq(id))
			.fetchOne();
	}

	@Override
	public User findUserBySocialIdAndSocialType(String socialId, UserSocialType socialType) {
		return queryFactory
			.selectFrom(user)
			.where(
				user.socialInfo.socialId.eq(socialId),
				user.socialInfo.socialType.eq(socialType)
			)
			.fetchOne();
	}
}
