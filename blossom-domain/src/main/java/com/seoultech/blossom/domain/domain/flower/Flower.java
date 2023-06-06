package com.seoultech.blossom.domain.domain.flower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Table(name = "FLOWER")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Flower extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLOWER_ID")
	private Long id;

	@Column(name = "KOREAN_NAME", nullable = false, length = 30)
	private String koreanName;

	@Column(name = "ENGLISH_NAME", nullable = false, length = 100)
	private String englishName;

	@Column(name = "CATEGORY", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private FlowerCategory category;

	@Column(name = "FAMILY_NAME", nullable = false, length = 30)
	private String familyName;

	@Column(name = "ADDITIONAL_INFORMATION", nullable = false, length = 100)
	private String additionalInformation;

	@Column(name = "FIT_NAME", nullable = false, length = 30)
	private String fitName;

	@Column(name = "FIT_INFORMATION", nullable = false, length = 100)
	private String fitInformation;

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerImage> flowerImages = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerTag> flowerTags = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerLanguage> flowerLanguages = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerTime> flowerTimes = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerCare> flowerCares = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<BetterTogether> betterTogethers = new ArrayList<>();

	@OneToMany(mappedBy = "flower", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<FlowerContent> flowerContents = new ArrayList<>();
}
