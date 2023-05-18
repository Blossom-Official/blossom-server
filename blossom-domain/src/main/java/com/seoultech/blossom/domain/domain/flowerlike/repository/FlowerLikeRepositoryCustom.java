package com.seoultech.blossom.domain.domain.flowerlike.repository;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;
import com.seoultech.blossom.domain.domain.user.User;

public interface FlowerLikeRepositoryCustom {

	FlowerLike findFlowerLikeByUserAndFlower(User user, Flower flower);
}
