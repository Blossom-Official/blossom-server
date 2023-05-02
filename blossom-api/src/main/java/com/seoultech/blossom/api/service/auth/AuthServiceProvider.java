package com.seoultech.blossom.api.service.auth;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.seoultech.blossom.api.service.auth.impl.KakaoAuthService;
import com.seoultech.blossom.domain.domain.user.UserSocialType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthServiceProvider {

	private static final Map<UserSocialType, AuthService> authServiceMap = new HashMap<>();

	private final KakaoAuthService kakaoAuthService;

	@PostConstruct
	void initializeAuthServicesMap() {
		authServiceMap.put(UserSocialType.KAKAO, kakaoAuthService);
	}

	public AuthService getAuthService(UserSocialType socialType) {
		return authServiceMap.get(socialType);
	}
}
