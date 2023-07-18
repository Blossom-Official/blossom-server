package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendMind;

public interface FlowerRecommendMindRepository extends JpaRepository<FlowerRecommendMind, Long>,
	FlowerRecommendMindRepositoryCustom {
}
