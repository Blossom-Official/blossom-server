package com.seoultech.blossom.domain.config.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.seoultech.blossom.domain.domain.flower.repository.FlowerSearchRepository;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = FlowerSearchRepository.class)
public class ElasticSearchConfig extends AbstractElasticsearchConfig {

	@Override
	public RestHighLevelClient elasticsearchClient() {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
			.connectedTo("localhost:9200")
			.build();
		return RestClients.create(clientConfiguration).rest();
	}
}
