package com.seoultech.blossom.api.service.flowerlike;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flower.FlowerServiceUtils;
import com.seoultech.blossom.api.service.flowerlike.dto.response.FlowerLikeResponse;
import com.seoultech.blossom.api.service.flowerlike.dto.response.SpecificFlowerLikeResponse;
import com.seoultech.blossom.api.service.user.UserServiceUtils;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerRepository;
import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;
import com.seoultech.blossom.domain.domain.flowerlike.repository.FlowerLikeRepository;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FlowerLikeRetrieveService {

	private final UserRepository userRepository;
	private final FlowerRepository flowerRepository;
	private final FlowerLikeRepository flowerLikeRepository;

	public SpecificFlowerLikeResponse getSpecificFlowerLike(Long flowerId, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		Flower flower = FlowerServiceUtils.findFlowerById(flowerRepository, flowerId);
		FlowerLike flowerLike = flowerLikeRepository.findFlowerLikeByUserAndFlower(user, flower);
		return SpecificFlowerLikeResponse.of(flowerLike != null);
	}

	public FlowerLikeResponse getFlowerLike(Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		List<FlowerLike> flowerLikes = flowerLikeRepository.findFlowerLikesByUser(user);
		return FlowerLikeResponse.of(flowerLikes
			.stream()
			.map(FlowerLike::getFlower)
			.collect(Collectors.toList()));
	}
}
