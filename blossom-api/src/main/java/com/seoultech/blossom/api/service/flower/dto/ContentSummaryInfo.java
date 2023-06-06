package com.seoultech.blossom.api.service.flower.dto;

import java.util.Comparator;

import com.seoultech.blossom.domain.domain.content.Content;
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
public class ContentSummaryInfo {

	@Schema(description = "컨텐츠 id")
	private Long contentId;

	@Schema(description = "썸네일")
	private String imageUrl;

	public static ContentSummaryInfo of(Content content) {
		return ContentSummaryInfo.builder()
			.contentId(content.getId())
			.imageUrl(content.getContentInfos()
				.stream()
				.min(Comparator.comparing(ContentInfo::getOrder))
				.get()
				.getContentImageUrl())
			.build();
	}
}