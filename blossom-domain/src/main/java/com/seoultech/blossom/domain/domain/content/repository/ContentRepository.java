package com.seoultech.blossom.domain.domain.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seoultech.blossom.domain.domain.content.Content;

public interface ContentRepository extends JpaRepository<Content, Long>, ContentRepositoryCustom {
}
