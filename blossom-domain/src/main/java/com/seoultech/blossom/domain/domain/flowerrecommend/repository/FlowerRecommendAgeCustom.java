package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerAge;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendAge;

public interface FlowerRecommendAgeCustom {

	List<FlowerRecommendAge> findFlowerRecommendAgesByAge(FlowerAge age);
}
