package com.seoultech.blossom.domain.domain.flowersearch.repository;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;

public interface FlowerHitRepositoryCustom {
	
	FlowerHit findFlowerHitByFlower(Flower flower);
}
