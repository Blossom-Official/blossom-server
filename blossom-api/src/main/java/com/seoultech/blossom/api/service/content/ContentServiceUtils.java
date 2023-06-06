package com.seoultech.blossom.api.service.content;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import com.seoultech.blossom.common.exception.NotFoundException;
import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.content.repository.ContentRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentServiceUtils {

	public static Content findContentById(ContentRepository contentRepository, Long contentId) {
		Content content = contentRepository.findContentById(contentId);
		if (content == null) {
			throw new NotFoundException(String.format("존재하지 않는 컨텐츠 (%s) 입니다", contentId), NOT_FOUND_CONTENT_EXCEPTION);
		}
		return content;
	}
}
