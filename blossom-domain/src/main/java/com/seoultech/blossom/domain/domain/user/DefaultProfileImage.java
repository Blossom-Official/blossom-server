package com.seoultech.blossom.domain.domain.user;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DefaultProfileImage {

	ONE("기본이미지 1", "DEV IMAGE URL 1", "PROD IMAGE URL 1"),
	TWO("기본이미지 2", "DEV IMAGE URL 2", "PROD IMAGE URL 2"),
	THREE("기본이미지 3", "DEV IMAGE URL 3", "PROD IMAGE URL 3");

	private final String description;
	private final String devImageUrl;
	private final String prodImageUrl;

	public static List<DefaultProfileImage> getList() {
		return List.of(ONE, TWO, THREE);
	}

	public static List<String> getUrlList() {
		return List.of(
			ONE.devImageUrl, TWO.devImageUrl, THREE.devImageUrl,
			ONE.prodImageUrl, TWO.prodImageUrl, THREE.prodImageUrl);
	}
}
