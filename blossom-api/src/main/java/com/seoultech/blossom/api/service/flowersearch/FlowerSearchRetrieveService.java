package com.seoultech.blossom.api.service.flowersearch;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flowersearch.dto.response.FlowerSearchResponse;
import com.seoultech.blossom.domain.domain.flower.FlowerDocument;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerSearchQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FlowerSearchRetrieveService {

	private final FlowerSearchQueryRepository flowerSearchQueryRepository;

	public FlowerSearchResponse searchFlowers(String searchText) {
		List<FlowerDocument> flowerDocuments = flowerSearchQueryRepository.findByCondition(searchText);
		return FlowerSearchResponse.of(flowerDocuments);
	}

}
