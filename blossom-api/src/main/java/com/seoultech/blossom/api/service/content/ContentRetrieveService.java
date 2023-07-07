package com.seoultech.blossom.api.service.content;

import java.util.Collections;
import java.util.List;

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
		List<Content> moreContents = contentRepository.findAll();
		moreContents.remove(content);
		Collections.shuffle(moreContents);
		return ContentResponse.of(content, moreContents);
	}
}
