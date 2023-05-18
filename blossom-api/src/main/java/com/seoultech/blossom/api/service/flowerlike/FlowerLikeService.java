package com.seoultech.blossom.api.service.flowerlike;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flower.FlowerServiceUtils;
import com.seoultech.blossom.api.service.flowerlike.dto.CheckFlowerLikeRequest;
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
@Transactional
public class FlowerLikeService {

	private final UserRepository userRepository;
	private final FlowerRepository flowerRepository;
	private final FlowerLikeRepository flowerLikeRepository;

	public void checkFlowerLike(CheckFlowerLikeRequest request, Long flowerId, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);
		Flower flower = FlowerServiceUtils.findFlowerById(flowerRepository, flowerId);
		FlowerLike flowerLike = flowerLikeRepository.findFlowerLikeByUserAndFlower(user, flower);
		FlowerLikeServiceUtils.validateFlowerLikeRequest(flowerLike, request.getIsCheck());

		if (request.getIsCheck()) { // 좋아요 생성
			flowerLikeRepository.save(FlowerLike.newInstance(user, flower));
		}

		if (!request.getIsCheck()) { // 좋아요 해제
			flowerLikeRepository.delete(flowerLike);
		}
	}
}
