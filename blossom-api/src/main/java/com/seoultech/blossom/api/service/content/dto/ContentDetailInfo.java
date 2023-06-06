package com.seoultech.blossom.api.service.content.dto;

import com.seoultech.blossom.domain.domain.content.ContentInfo;

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
public class ContentDetailInfo {

	@Schema(description = "이미지 url")
	private String contentImageUrl;

	@Schema(description = "링크 여부")
	private Boolean hasLink;

	@Schema(description = "링크 url")
	private String linkUrl;

	public static ContentDetailInfo of(ContentInfo contentInfo) {
		return ContentDetailInfo.builder()
			.contentImageUrl(contentInfo.getContentImageUrl())
			.hasLink(contentInfo.getLinkYn())
			.linkUrl(contentInfo.getLinkUrl())
			.build();
	}
}
