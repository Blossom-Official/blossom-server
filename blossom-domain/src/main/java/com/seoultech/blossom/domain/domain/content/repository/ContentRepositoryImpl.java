package com.seoultech.blossom.domain.domain.content.repository;

import static com.seoultech.blossom.domain.domain.content.QContent.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seoultech.blossom.domain.domain.content.Content;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContentRepositoryImpl implements ContentRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Content findContentById(Long id) {
		return queryFactory
			.selectFrom(content)
			.where(content.id.eq(id))
			.fetchOne();
	}
}
