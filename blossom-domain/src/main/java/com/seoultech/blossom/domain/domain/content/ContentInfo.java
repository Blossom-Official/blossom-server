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

@Table(name = "CONTENT_INFO")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ContentInfo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTENT_INFO_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTENT_ID", nullable = false)
	private Content content;

	@Column(name = "CONTENT_IMAGE_URL", nullable = false, length = 300)
	private String contentImageUrl;

	@Column(name = "ORDER", nullable = false)
	private Integer order;

	@Column(name = "LINK_YN", nullable = false)
	private Boolean linkYn;

	@Column(name = "LINK_URL", nullable = true, length = 300)
	private String linkUrl;
}
