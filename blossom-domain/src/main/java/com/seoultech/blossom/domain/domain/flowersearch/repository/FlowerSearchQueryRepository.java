package com.seoultech.blossom.domain.domain.flowersearch.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

	public List<String> searchAutocompletes(String searchText) {
		Set<String> result = new HashSet<>();
		String prefix = trimAndReduceSpaces(searchText);
		SearchHits<FlowerDocument> searchHits = operations.search(
			matchPhrasePrefixAnyIndexQuery(prefix), FlowerDocument.class);
		searchHits.stream()
			.map(SearchHit::getContent)
			.forEach(flowerDocument -> {
				if (flowerDocument.getKoreanName().startsWith(prefix)) {
					result.add(flowerDocument.getKoreanName());
				}
				if (flowerDocument.getEnglishName().startsWith(prefix)) {
					result.add(flowerDocument.getEnglishName());
				}
				if (flowerDocument.getFamilyName().startsWith(prefix)) {
					result.add(flowerDocument.getFamilyName());
				}
				for (String flowerTag : flowerDocument.getFlowerTags()) {
					if (flowerTag.startsWith(prefix)) {
						result.add(flowerTag);
					}
				}
				for (String flowerLanguage : flowerDocument.getFlowerLanguages()) {
					if (flowerLanguage.startsWith(prefix)) {
						result.add(flowerLanguage);
					}
				}
			});
		return result.stream().sorted().collect(Collectors.toList());
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

	private NativeSearchQuery matchPhrasePrefixAnyIndexQuery(String searchText) {
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		for (String indexName : indexNames) {
			boolQuery.should(QueryBuilders.matchPhrasePrefixQuery(indexName, searchText));
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

	private String trimAndReduceSpaces(String input) {
		String result = "";
		if (StringUtils.hasText(input)) {
			result = input.trim().replaceAll("\\s+", " ");
		}
		return result;
	}
}
