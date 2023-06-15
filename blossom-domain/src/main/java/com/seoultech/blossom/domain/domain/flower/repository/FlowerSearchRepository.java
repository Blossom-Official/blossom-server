package com.seoultech.blossom.domain.domain.flower.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.seoultech.blossom.domain.domain.flower.FlowerDocument;

public interface FlowerSearchRepository extends ElasticsearchRepository<FlowerDocument, Long> {
}
