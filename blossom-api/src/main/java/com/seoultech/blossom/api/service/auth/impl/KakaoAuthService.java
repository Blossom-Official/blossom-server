package com.seoultech.blossom.api.service.auth.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.auth.AuthService;
import com.seoultech.blossom.api.service.auth.dto.request.LoginRequest;
import com.seoultech.blossom.api.service.auth.dto.request.SignUpRequest;
import com.seoultech.blossom.api.service.user.UserService;
import com.seoultech.blossom.api.service.user.UserServiceUtils;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.UserSocialType;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;
import com.seoultech.blossom.external.client.auth.kakao.KakaoApiCaller;
import com.seoultech.blossom.external.client.auth.kakao.dto.response.KakaoProfileResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class KakaoAuthService implements AuthService {

	private static final UserSocialType socialType = UserSocialType.KAKAO;

	private final KakaoApiCaller kakaoApiCaller;

	private final UserRepository userRepository;

	private final UserService userService;

	@Override
	public Long signUp(SignUpRequest request) {
		KakaoProfileResponse response = kakaoApiCaller.getProfileInfo(request.getToken());
		return userService.registerUser(request.toCreateUserDto(response.getId()));
	}

	@Override
	public Long login(LoginRequest request) {
		KakaoProfileResponse response = kakaoApiCaller.getProfileInfo(request.getToken());
		User user = UserServiceUtils.findUserBySocialIdAndSocialType(userRepository, response.getId(), socialType);
		return user.getId();
	}
}
