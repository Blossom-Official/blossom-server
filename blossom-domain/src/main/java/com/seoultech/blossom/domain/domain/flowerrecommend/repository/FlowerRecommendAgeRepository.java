package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendAge;

public interface FlowerRecommendAgeRepository
	extends JpaRepository<FlowerRecommendAge, Long>, FlowerRecommendRelationshipCustom {
}
