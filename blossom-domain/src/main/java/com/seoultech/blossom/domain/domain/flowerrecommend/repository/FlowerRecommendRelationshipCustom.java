package com.seoultech.blossom.domain.domain.flowerrecommend.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendRelationship;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRelationship;

public interface FlowerRecommendRelationshipCustom {

	List<FlowerRecommendRelationship> findFlowerRecommendRelationshipsByRelationship(FlowerRelationship relationship);
}
