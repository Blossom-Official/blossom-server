package com.seoultech.blossom.api.service.flowerrecommend.dto.response;

import java.util.Comparator;

import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.FlowerImage;
import com.seoultech.blossom.domain.domain.user.User;

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
public class FlowerRecommendResponse {

	@Schema(description = "닉네임")
	private String nickname;

	@Schema(description = "꽃 id")
	private Long flowerId;

	@Schema(description = "한글 이름")
	private String koreanName;

	@Schema(description = "영어 이름")
	private String englishName;

	@Schema(description = "이미지")
	private String imageUrl;

	public static FlowerRecommendResponse of(User user, Flower flower) {
		return FlowerRecommendResponse.builder()
			.nickname(user.getNickname())
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
}
