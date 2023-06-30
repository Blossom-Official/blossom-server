package com.seoultech.blossom.domain.domain.flowersearch.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.seoultech.blossom.domain.domain.flowersearch.FlowerDocument;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FlowerSearchQueryRepository {

	private final ElasticsearchOperations operations;
	private static final List<String> indexNames = List.of(
		"koreanName", "englishName", "familyName", "flowerTags", "flowerLanguages");

	public List<FlowerDocument> searchFlowerDocuments(String searchText) {
		SearchHits<FlowerDocument> searchHits = operations.search(
			prefixOrFuzzyAnyIndexQuery(searchText), FlowerDocument.class);
		return searchHits.stream()
			.map(SearchHit::getContent)
			.collect(Collectors.toList());
	}

	private NativeSearchQuery prefixOrFuzzyAnyIndexQuery(String searchText) {
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		String[] searchTerms = trimAndSplitBySpaces(searchText);
		for (String term : searchTerms) {
			for (String indexName : indexNames) {
				boolQuery.should(QueryBuilders.prefixQuery(indexName, term));
				boolQuery.should(QueryBuilders.fuzzyQuery(indexName, term).fuzziness(Fuzziness.ONE));
			}
		}
		return new NativeSearchQueryBuilder()
			.withQuery(boolQuery)
			.build();
	}

	private String[] trimAndSplitBySpaces(String input) {
		if (StringUtils.hasText(input)) {
			return input.trim().split("\\s+");
		}
		return new String[0];
	}
}
