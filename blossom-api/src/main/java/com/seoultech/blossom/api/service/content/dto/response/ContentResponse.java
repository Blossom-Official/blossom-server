package com.seoultech.blossom.api.service.content.dto.response;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.content.dto.ContentDetailInfo;
import com.seoultech.blossom.api.service.content.dto.ContentSummaryInfo;
import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.content.ContentInformation;

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
public class ContentResponse {

	@Schema(description = "컨텐츠 id")
	private Long contentId;

	@Schema(description = "등록일")
	private LocalDate postedAt;

	@Schema(description = "부제목")
	private String subtitle;

	@Schema(description = "제목")
	private String title;

	@Schema(description = "설명")
	private String description;

	@Schema(description = "이미지 url")
	private String contentImageUrl;

	@Schema(description = "총 페이지 수")
	private int totalPage;

	@Schema(description = "컨텐츠 내용")
	private List<ContentDetailInfo> contentDetailInfos;

	@Schema(description = "MORE")
	private List<ContentSummaryInfo> more;

	public static ContentResponse of(Content content, List<Content> moreContents) {
		return ContentResponse.builder()
			.contentId(content.getId())
			.postedAt(content.getPostedAt())
			.subtitle(content.getSubtitle())
			.title(content.getTitle())
			.description(content.getDescription())
			.contentImageUrl(content.getContentImageUrl())
			.totalPage(content.getContentInformations().size() + 1)
			.contentDetailInfos(content.getContentInformations()
				.stream()
				.sorted(Comparator.comparingInt(ContentInformation::getOrder))
				.map(ContentDetailInfo::of)
				.collect(Collectors.toList()))
			.more(moreContents
				.stream()
				.limit(2)
				.map(ContentSummaryInfo::of)
				.collect(Collectors.toList()))
			.build();
	}
}
