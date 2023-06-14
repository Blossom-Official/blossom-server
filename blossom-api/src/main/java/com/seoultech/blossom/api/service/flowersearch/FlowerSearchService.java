package com.seoultech.blossom.api.service.flowersearch;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerDocument;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerRepository;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerSearchRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class FlowerSearchService {

	private final FlowerRepository flowerRepository;
	private final FlowerSearchRepository flowerSearchRepository;

	public void saveFlowerDocuments() {
		flowerSearchRepository.deleteAll();
		List<Flower> flowers = flowerRepository.findAll();
		flowers.forEach(flower -> flowerSearchRepository.save(FlowerDocument.of(flower)));
	}

}
