package com.seoultech.blossom.api.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.user.dto.response.ProfileResponse;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserRetrieveService {

	private final UserRepository userRepository;

	public ProfileResponse getProfile(Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		return ProfileResponse.of(user);
	}
}
