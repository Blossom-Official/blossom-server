package com.seoultech.blossom.api.service.content.dto.response;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.api.service.content.dto.ContentDetailInfo;
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

	@Schema(description = "컨텐츠 내용")
	private List<ContentDetailInfo> contentDetailInfos;

	public static ContentResponse of(Content content) {
		return ContentResponse.builder()
			.contentId(content.getId())
			.contentDetailInfos(content.getContentInformations()
				.stream()
				.sorted(Comparator.comparingInt(ContentInformation::getOrder))
				.map(ContentDetailInfo::of)
				.collect(Collectors.toList()))
			.build();
	}
}
