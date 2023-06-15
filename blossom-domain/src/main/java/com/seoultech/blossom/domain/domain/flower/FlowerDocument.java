package com.seoultech.blossom.domain.domain.flower;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(indexName = "flower")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class FlowerDocument {

	@Id
	@Field(type = FieldType.Keyword)
	private Long id;

	@Field(type = FieldType.Text)
	private String koreanName;

	@Field(type = FieldType.Text)
	private String englishName;

	@Field(type = FieldType.Text)
	private String familyName;

	private String flowerImageUrl;

	@Field(type = FieldType.Text)
	private List<String> flowerTags;

	@Field(type = FieldType.Text)
	private List<String> flowerLanguages;

	public static FlowerDocument of(Flower flower) {
		return FlowerDocument.builder()
			.id(flower.getId())
			.koreanName(flower.getKoreanName())
			.englishName(flower.getEnglishName())
			.familyName(flower.getFamilyName())
			.flowerImageUrl(flower.getFlowerImages()
				.stream()
				.min(Comparator.comparing(FlowerImage::getOrder))
				.get()
				.getFlowerImageUrl())
			.flowerTags(flower.getFlowerTags()
				.stream()
				.map(FlowerTag::getName)
				.collect(Collectors.toList()))
			.flowerLanguages(flower.getFlowerLanguages()
				.stream()
				.map(FlowerLanguage::getName)
				.collect(Collectors.toList()))
			.build();
	}
}
