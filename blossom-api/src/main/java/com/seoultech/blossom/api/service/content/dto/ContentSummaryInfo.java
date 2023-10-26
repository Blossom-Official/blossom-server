package com.seoultech.blossom.api.service.content.dto;

import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.flowersearch.FlowerDocument;

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

	@Schema(description = "제목")
	private String title;

	@Schema(description = "부제목")
	private String subtitle;

	@Override
	public boolean equals(Object o) {
		return this.contentId.equals(((ContentSummaryInfo)o).contentId);
	}

	@Override
	public int hashCode() {
		return this.contentId.hashCode();
	}

	public static ContentSummaryInfo of(Content content, boolean isThumbnail) {
		return ContentSummaryInfo.builder()
			.contentId(content.getId())
			.imageUrl(isThumbnail ? content.getContentThumbnailUrl() : content.getContentImageUrl())
			.title(content.getTitle())
			.subtitle(content.getSubtitle())
			.build();
	}

	public static ContentSummaryInfo of(FlowerDocument.ContentSummaryInfo contentSummaryInfo) {
		return ContentSummaryInfo.builder()
			.contentId(contentSummaryInfo.getContentId())
			.imageUrl(contentSummaryInfo.getImageUrl())
			.title(contentSummaryInfo.getTitle())
			.subtitle(contentSummaryInfo.getSubtitle())
			.build();
	}
}
