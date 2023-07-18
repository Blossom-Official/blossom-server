package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendVibe;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerVibe;

public interface FlowerRecommendVibeRepositoryCustom {

	List<FlowerRecommendVibe> findFlowerRecommendVibesByVibe(FlowerVibe vibe);
}
