package com.seoultech.blossom.api.service.auth;

import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.auth.dto.request.TokenRequestDto;
import com.seoultech.blossom.api.service.auth.dto.response.TokenResponse;
import com.seoultech.blossom.api.service.user.UserServiceUtils;
import com.seoultech.blossom.common.constant.RedisKey;
import com.seoultech.blossom.common.exception.UnAuthorizedException;
import com.seoultech.blossom.common.util.JwtUtils;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateTokenService {

	private final UserRepository userRepository;

	private final RedisTemplate redisTemplate;

	private final JwtUtils jwtUtils;

	public TokenResponse createTokenInfo(Long userId) {
		List<String> tokens = jwtUtils.createTokenInfo(userId);
		return TokenResponse.of(tokens.get(0), tokens.get(1));
	}

	public TokenResponse reissueToken(TokenRequestDto request) {
		Long userId = jwtUtils.getUserIdFromJwt(request.getAccessToken());
		User user = UserServiceUtils.findUserById(userRepository, userId);
		if (!jwtUtils.validateToken(request.getRefreshToken())) {
			throw new UnAuthorizedException(String.format("주어진 리프레시 토큰 (%s) 이 유효하지 않습니다.", request.getRefreshToken()));
		}
		String refreshToken = (String)redisTemplate.opsForValue().get(RedisKey.REFRESH_TOKEN + userId);
		if (Objects.isNull(refreshToken)) {
			throw new UnAuthorizedException(String.format("이미 만료된 리프레시 토큰 (%s) 입니다.", request.getRefreshToken()));
		}
		if (!refreshToken.equals(request.getRefreshToken())) {
			jwtUtils.expireRefreshToken(user.getId());
			throw new UnAuthorizedException(
				String.format("해당 리프레시 토큰 (%s) 의 정보가 일치하지 않습니다.", request.getRefreshToken()));
		}
		List<String> tokens = jwtUtils.createTokenInfo(userId);
		return TokenResponse.of(tokens.get(0), tokens.get(1));
	}
}
