package com.seoultech.blossom.api.service.auth;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.user.UserServiceUtils;
import com.seoultech.blossom.common.util.JwtUtils;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class CommonAuthService {

	private final UserRepository userRepository;

	private final JwtUtils jwtUtils;

	public void logout(Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		jwtUtils.expireRefreshToken(user.getId());
	}
}
