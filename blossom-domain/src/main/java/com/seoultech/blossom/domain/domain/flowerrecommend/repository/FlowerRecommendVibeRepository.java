package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendVibe;

public interface FlowerRecommendVibeRepository extends JpaRepository<FlowerRecommendVibe, Long>,
	FlowerRecommendVibeRepositoryCustom {
}
