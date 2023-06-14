package com.seoultech.blossom.api.service.flower.dto;

import java.util.Comparator;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerDocument;
import com.seoultech.blossom.domain.domain.flower.FlowerImage;

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
public class FlowerInfo {

	@Schema(description = "꽃 id")
	private Long flowerId;

	@Schema(description = "한글 이름")
	private String koreanName;

	@Schema(description = "영어 이름")
	private String englishName;

	@Schema(description = "썸네일")
	private String imageUrl;

	public static FlowerInfo of(Flower flower) {
		return FlowerInfo.builder()
			.flowerId(flower.getId())
			.koreanName(flower.getKoreanName())
			.englishName(flower.getEnglishName())
			.imageUrl(flower.getFlowerImages()
				.stream()
				.min(Comparator.comparing(FlowerImage::getOrder))
				.get()
				.getFlowerImageUrl())
			.build();
	}

	public static FlowerInfo of(FlowerDocument flowerDocument) {
		return FlowerInfo.builder()
			.flowerId(flowerDocument.getId())
			.koreanName(flowerDocument.getKoreanName())
			.englishName(flowerDocument.getEnglishName())
			.imageUrl(flowerDocument.getFlowerImageUrl())
			.build();
	}
}
