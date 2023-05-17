package com.seoultech.blossom.api.service.flower;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flower.dto.response.FlowerResponse;
import com.seoultech.blossom.domain.domain.flower.Flower;
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

}
