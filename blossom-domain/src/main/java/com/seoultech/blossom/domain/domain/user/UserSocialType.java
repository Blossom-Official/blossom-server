package com.seoultech.blossom.domain.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserSocialType {
	KAKAO("카카오톡");

	private final String value;
}
