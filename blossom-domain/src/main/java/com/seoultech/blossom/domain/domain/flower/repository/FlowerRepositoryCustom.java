package com.seoultech.blossom.domain.domain.flower.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerCategory;

public interface FlowerRepositoryCustom {

	Flower findFlowerById(Long id);

	List<Flower> findFlowersByCategory(FlowerCategory category);
}
