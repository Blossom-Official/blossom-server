package com.seoultech.blossom.api.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.user.dto.request.CreateUserRequestDto;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public Long registerUser(CreateUserRequestDto request) {
		UserServiceUtils.validateNotExistsUser(userRepository, request.getSocialId(), request.getSocialType());
		User user = userRepository.save(User.newInstance(request.getSocialId(), request.getSocialType()));
		return user.getId();
	}
}
