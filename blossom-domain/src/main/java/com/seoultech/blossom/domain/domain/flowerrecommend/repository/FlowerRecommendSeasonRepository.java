package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendSeason;

public interface FlowerRecommendSeasonRepository extends JpaRepository<FlowerRecommendSeason, Long>,
	FlowerRecommendSeasonRepositoryCustom {
}
