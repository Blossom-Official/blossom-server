package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendColor;

public interface FlowerRecommendColorRepository
	extends JpaRepository<FlowerRecommendColor, Long>, FlowerRecommendColorRepositoryCustom {
}
