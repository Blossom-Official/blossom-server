package com.seoultech.blossom.api.service.flowersearch;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flowersearch.dto.response.AutocompleteResponse;
import com.seoultech.blossom.api.service.flowersearch.dto.response.FlowerSearchResponse;
import com.seoultech.blossom.api.service.flowersearch.dto.response.PopularResponse;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerTag;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerRepository;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerDocument;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerHit;
import com.seoultech.blossom.domain.domain.flowersearch.repository.FlowerHitRepository;
import com.seoultech.blossom.domain.domain.flowersearch.repository.FlowerSearchQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FlowerSearchRetrieveService {

	private final FlowerRepository flowerRepository;
	private final FlowerHitRepository flowerHitRepository;
	private final FlowerSearchQueryRepository flowerSearchQueryRepository;

	@Transactional
	public FlowerSearchResponse searchFlowers(String searchText) {
		List<FlowerDocument> flowerDocuments = flowerSearchQueryRepository.searchFlowerDocuments(searchText);
		List<Flower> flowers = flowerDocuments
			.stream()
			.map(flowerDocument -> flowerRepository.findFlowerById(flowerDocument.getId()))
			.collect(Collectors.toList());
		flowers.forEach(flower -> {
			if (flower != null) {
				FlowerHit flowerHit = flowerHitRepository.findFlowerHitByFlowerForUpdate(flower);
				if (flowerHit == null) {
					flowerHitRepository.save(FlowerHit.newInstance(flower));
				} else {
					flowerHit.increase();
				}
			}
		});
		return FlowerSearchResponse.of(flowerDocuments);
	}

	public PopularResponse getPopular() {
		List<FlowerHit> flowerHits = flowerHitRepository.findFlowerHitsOrderByCountAndModifiedAt();
		List<String> tags = flowerHits.stream()
			.flatMap(flowerHit -> flowerHit.getFlower().getFlowerTags().stream())
			.map(FlowerTag::getName)
			.distinct()
			.limit(3)
			.collect(Collectors.toList());
		return PopularResponse.of(tags);
	}

	public AutocompleteResponse getAutocomplete(String searchText) {
		List<String> autocompletes = flowerSearchQueryRepository.searchAutocompletes(searchText);
		return AutocompleteResponse.of(autocompletes);
	}
}
