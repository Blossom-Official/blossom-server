package com.seoultech.blossom.api.service.flower.dto.response;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.content.dto.ContentSummaryInfo;
import com.seoultech.blossom.api.service.flower.dto.FlowerInfo;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerCare;
import com.seoultech.blossom.domain.domain.flower.FlowerImage;
import com.seoultech.blossom.domain.domain.flower.FlowerLanguage;
import com.seoultech.blossom.domain.domain.flower.FlowerTag;
import com.seoultech.blossom.domain.domain.flower.FlowerTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class FlowerResponse {

	@Schema(description = "한글 이름")
	private String koreanName;

	@Schema(description = "영어 이름")
	private String englishName;

	@Schema(description = "이미지")
	private List<String> images;

	@Schema(description = "과명")
	private String familyName;

	@Schema(description = "개화시기")
	private List<Integer> times;

	@Schema(description = "꽃말")
	private List<String> languages;

	@Schema(description = "태그")
	private List<String> tags;

	@Schema(description = "부가 설명")
	private String additionalInformation;

	@Schema(description = "잘 어울리는")
	private String fitName;

	@Schema(description = "잘 어울리는 설명")
	private String fitInformation;

	@Schema(description = "관리 방법")
	private List<String> cares;

	@Schema(description = "함께 어울리는 꽃")
	private List<FlowerInfo> betterTogethers;

	@Schema(description = "컨텐츠")
	private List<ContentSummaryInfo> contents;

	public static FlowerResponse of(Flower flower) {
		return FlowerResponse.builder()
			.koreanName(flower.getKoreanName())
			.englishName(flower.getEnglishName())
			.images(flower.getFlowerImages()
				.stream()
				.sorted(Comparator.comparing(FlowerImage::getOrder))
				.map(FlowerImage::getFlowerImageUrl)
				.collect(Collectors.toList()))
			.familyName(flower.getFamilyName())
			.times(flower.getFlowerTimes()
				.stream()
				.sorted(Comparator.comparing(FlowerTime::getMonth))
				.map(FlowerTime::getMonth)
				.collect(Collectors.toList()))
			.languages(flower.getFlowerLanguages()
				.stream()
				.map(FlowerLanguage::getName)
				.collect(Collectors.toList()))
			.tags(flower.getFlowerTags()
				.stream()
				.map(FlowerTag::getName)
				.collect(Collectors.toList()))
			.additionalInformation(flower.getAdditionalInformation())
			.fitName(flower.getFitName())
			.fitInformation(flower.getFitInformation())
			.cares(flower.getFlowerCares()
				.stream()
				.sorted(Comparator.comparing(FlowerCare::getOrder))
				.map(FlowerCare::getInformation)
				.collect(Collectors.toList()))
			.betterTogethers(flower.getBetterTogethers()
				.stream()
				.map(betterTogether -> FlowerInfo.of(betterTogether.getBetterTogetherFlower()))
				.collect(Collectors.toList()))
			.contents(flower.getFlowerContents()
				.stream()
				.map(flowerContent -> ContentSummaryInfo.of(flowerContent.getContent()))
				.collect(Collectors.toList()))
			.build();
	}
}
