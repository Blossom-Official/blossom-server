package com.seoultech.blossom.domain.domain.content.repository;

import java.util.List;

import com.seoultech.blossom.domain.domain.content.Content;

public interface ContentRepositoryCustom {

	Content findContentById(Long id);

	List<Content> findRecentContents();
}
