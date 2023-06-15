package com.seoultech.blossom.domain.domain.flower.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.seoultech.blossom.domain.domain.flower.FlowerDocument;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FlowerSearchQueryRepository {

	private final ElasticsearchOperations operations;

	public List<FlowerDocument> findByCondition(String searchText) {
		NativeSearchQuery query = createConditionNativeSearchQuery(searchText);
		SearchHits<FlowerDocument> searchHit = operations.search(query, FlowerDocument.class);
		return searchHit.stream()
			.map(SearchHit::getContent)
			.collect(Collectors.toList());
	}

	private NativeSearchQuery createConditionNativeSearchQuery(String searchText) {
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

		if (StringUtils.hasText(searchText)) {
			String[] searchTerms = searchText.trim().split("\\s+");

			for (String term : searchTerms) {
				boolQuery.should(QueryBuilders.matchPhraseQuery("koreanName", term));
				boolQuery.should(QueryBuilders.matchPhraseQuery("englishName", term));
				boolQuery.should(QueryBuilders.matchPhraseQuery("familyName", term));
				boolQuery.should(QueryBuilders.matchPhraseQuery("flowerTags", term));
				boolQuery.should(QueryBuilders.matchPhraseQuery("flowerLanguages", term));
			}
		}

		return new NativeSearchQueryBuilder()
			.withQuery(boolQuery)
			.build();
	}

}
