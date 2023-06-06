package com.seoultech.blossom.api.service.user.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.flower.dto.FlowerInfo;
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
public class ProfileResponse {

	@Schema(description = "닉네임")
	private String nickname;

	@Schema(description = "프로필 이미지")
	private String profileImageUrl;

	@Schema(description = "꽃 좋아요")
	private List<FlowerInfo> flowers;

	public static ProfileResponse of(User user) {
		return ProfileResponse.builder()
			.nickname(user.getNickname())
			.profileImageUrl(user.getProfileImageUrl())
			.flowers(user.getFlowerLikes()
				.stream()
				.map(flowerLike -> FlowerInfo.of(flowerLike.getFlower()))
				.collect(Collectors.toList()))
			.build();
	}
}
