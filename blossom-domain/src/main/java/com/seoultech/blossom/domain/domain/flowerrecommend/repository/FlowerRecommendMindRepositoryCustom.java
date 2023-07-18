package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerMind;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendMind;

public interface FlowerRecommendMindRepositoryCustom {

	List<FlowerRecommendMind> findFlowerRecommendMindsByMind(FlowerMind mind);
}
