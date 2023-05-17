package com.seoultech.blossom.api.service.flower;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flower.dto.response.FlowerCategoryResponse;
import com.seoultech.blossom.api.service.flower.dto.response.FlowerResponse;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerCategory;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FlowerRetrieveService {

	private final FlowerRepository flowerRepository;

	public FlowerResponse getFlowerById(Long flowerId) {
		Flower flower = FlowerServiceUtils.findFlowerById(flowerRepository, flowerId);
		return FlowerResponse.of(flower);
	}

	public FlowerCategoryResponse getFlowersByCategory(FlowerCategory category) {
		List<Flower> flowers = flowerRepository.findFlowersByCategory(category);
		return FlowerCategoryResponse.of(flowers);
	}
}
