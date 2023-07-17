package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendRelationship;

public interface FlowerRecommendRelationshipRepository
	extends JpaRepository<FlowerRecommendRelationship, Long>, FlowerRecommendRelationshipCustom {
}
