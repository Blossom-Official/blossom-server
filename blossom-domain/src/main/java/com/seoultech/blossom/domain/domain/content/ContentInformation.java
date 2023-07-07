package com.seoultech.blossom.domain.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.seoultech.blossom.domain.domain.common.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "CONTENT_INFORMATION")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ContentInformation extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTENT_INFORMATION_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTENT_ID", nullable = false)
	private Content content;

	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;

	@Column(name = "SUBTITLE", nullable = false, length = 100)
	private String subtitle;

	@Column(name = "DESCRIPTION", nullable = false, length = 1000)
	private String description;

	@Column(name = "CONTENT_IMAGE_URL", nullable = false, length = 300)
	private String contentImageUrl;

	@Column(name = "ORDER", nullable = false)
	private Integer order;

	@Column(name = "LINK_YN", nullable = false)
	private Boolean linkYn;

	@Column(name = "LINK_URL", nullable = true, length = 300)
	private String linkUrl;
}
