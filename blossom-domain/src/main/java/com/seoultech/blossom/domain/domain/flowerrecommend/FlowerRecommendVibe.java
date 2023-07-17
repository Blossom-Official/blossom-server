package com.seoultech.blossom.domain.domain.flowerrecommend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.seoultech.blossom.domain.domain.common.BaseEntity;
import com.seoultech.blossom.domain.domain.flower.Flower;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "FLOWER_RECOMMEND_VIBE")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class FlowerRecommendVibe extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLOWER_RECOMMEND_VIBE_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FLOWER_ID", nullable = false)
	private Flower flower;

	@Column(name = "VIBE", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private FlowerVibe vibe;
}
