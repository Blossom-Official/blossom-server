package com.seoultech.blossom.api.service.user.dto.request;

import com.seoultech.blossom.domain.domain.user.UserSocialType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class CreateUserRequestDto {

	private String socialId;
	private UserSocialType socialType;

	public static CreateUserRequestDto of(String socialId, UserSocialType socialType) {
		return CreateUserRequestDto.builder()
			.socialId(socialId)
			.socialType(socialType)
			.build();
	}
}
