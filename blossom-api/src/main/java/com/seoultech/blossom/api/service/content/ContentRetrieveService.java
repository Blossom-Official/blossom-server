package com.seoultech.blossom.api.service.content;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.content.dto.response.ContentResponse;
import com.seoultech.blossom.domain.domain.content.Content;
import com.seoultech.blossom.domain.domain.content.repository.ContentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ContentRetrieveService {

	private final ContentRepository contentRepository;

	public ContentResponse getContentById(Long contentId) {
		Content content = ContentServiceUtils.findContentById(contentRepository, contentId);
		return ContentResponse.of(content);
	}
}
