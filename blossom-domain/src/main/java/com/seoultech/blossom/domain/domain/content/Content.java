package com.seoultech.blossom.domain.domain.content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.seoultech.blossom.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "CONTENT")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Content extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTENT_ID")
	private Long id;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "SUBTITLE", nullable = false, length = 100)
	private String subtitle;

	@Column(name = "DESCRIPTION", nullable = false, length = 1000)
	private String description;

	@Column(name = "CONTENT_THUMBNAIL_URL", nullable = false, length = 300)
	private String contentThumbnailUrl;

	@Column(name = "CONTENT_IMAGE_URL", nullable = false, length = 300)
	private String contentImageUrl;

	@Column(name = "POSTED_AT", nullable = false, length = 300)
	private LocalDate postedAt;

	@OneToMany(mappedBy = "content", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<ContentInformation> contentInformations = new ArrayList<>();
}
