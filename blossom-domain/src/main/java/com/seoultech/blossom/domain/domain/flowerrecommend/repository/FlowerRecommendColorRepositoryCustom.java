package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerColor;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendColor;

public interface FlowerRecommendColorRepositoryCustom {

	List<FlowerRecommendColor> findFlowerRecommendColorsByColor(FlowerColor color);
}
