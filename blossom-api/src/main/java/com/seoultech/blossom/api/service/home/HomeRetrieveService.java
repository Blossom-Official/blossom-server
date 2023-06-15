package com.seoultech.blossom.api.service.home;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.home.dto.response.HomeResponse;
import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.content.repository.ContentRepository;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;
import com.seoultech.blossom.domain.domain.flowersearch.repository.FlowerHitRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class HomeRetrieveService {

	private final ContentRepository contentRepository;
	private final FlowerHitRepository flowerHitRepository;

	public HomeResponse getHomeInfo() {
		List<Content> recentContents = contentRepository.findRecentContents();
		List<FlowerHit> flowerHits = flowerHitRepository.findFlowerHitsOrderByCountAndModifiedAt();
		List<Flower> popularFlowers = flowerHits.stream()
			.map(FlowerHit::getFlower)
			.limit(3)
			.collect(Collectors.toList());
		return HomeResponse.of(recentContents, popularFlowers);
	}
}
