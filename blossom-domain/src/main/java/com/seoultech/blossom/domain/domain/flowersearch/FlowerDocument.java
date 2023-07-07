package com.seoultech.blossom.domain.domain.flowersearch;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerImage;
import com.seoultech.blossom.domain.domain.flower.FlowerLanguage;
import com.seoultech.blossom.domain.domain.flower.FlowerTag;

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

	private List<ContentSummaryInfo> contentSummaryInfos;

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@Builder(access = AccessLevel.PRIVATE)
	public static class ContentSummaryInfo {
		private Long contentId;
		private String imageUrl;
		private String title;
		private String subtitle;

		private static ContentSummaryInfo of(Content content) {
			return ContentSummaryInfo.builder()
				.contentId(content.getId())
				.imageUrl(content.getContentImageUrl())
				.title(content.getTitle())
				.subtitle(content.getSubtitle())
				.build();
		}
	}

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
			.contentSummaryInfos(flower.getFlowerContents()
				.stream()
				.map(flowerContent -> ContentSummaryInfo.of(flowerContent.getContent()))
				.collect(Collectors.toList()))
			.build();
	}
}
