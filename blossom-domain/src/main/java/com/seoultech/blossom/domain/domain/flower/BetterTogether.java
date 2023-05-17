package com.seoultech.blossom.domain.domain.flower;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "BETTER_TOGETHER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class BetterTogether {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BETTER_TOGETHER_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FLOWER_ID", nullable = false)
	private Flower flower;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BETTER_TOGETHER_FLOWER_ID", nullable = false)
	private Flower betterTogetherFlower;
}
