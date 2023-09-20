package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendSeason;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerSeason;

public interface FlowerRecommendSeasonRepositoryCustom {

	List<FlowerRecommendSeason> findFlowerRecommendSeasonsBySeason(FlowerSeason season);
}
