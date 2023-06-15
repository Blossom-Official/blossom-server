package com.seoultech.blossom.domain.domain.flowersearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.seoultech.blossom.domain.domain.flowersearch.FlowerDocument;

public interface FlowerSearchRepository extends ElasticsearchRepository<FlowerDocument, Long> {
}
