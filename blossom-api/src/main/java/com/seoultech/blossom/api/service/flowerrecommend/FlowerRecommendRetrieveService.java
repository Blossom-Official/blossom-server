package com.seoultech.blossom.api.service.flowerrecommend;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoultech.blossom.api.service.flowerrecommend.dto.response.FlowerRecommendResponse;
import com.seoultech.blossom.api.service.user.UserServiceUtils;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerAge;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerColor;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerMind;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRecommendColor;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerRelationship;
import com.seoultech.blossom.domain.domain.flowerrecommend.FlowerVibe;
import com.seoultech.blossom.domain.domain.flowerrecommend.repository.FlowerRecommendAgeRepository;
import com.seoultech.blossom.domain.domain.flowerrecommend.repository.FlowerRecommendColorRepository;
import com.seoultech.blossom.domain.domain.flowerrecommend.repository.FlowerRecommendMindRepository;
import com.seoultech.blossom.domain.domain.flowerrecommend.repository.FlowerRecommendRelationshipRepository;
import com.seoultech.blossom.domain.domain.flowerrecommend.repository.FlowerRecommendVibeRepository;
import com.seoultech.blossom.domain.domain.user.User;
import com.seoultech.blossom.domain.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FlowerRecommendRetrieveService {

	private final UserRepository userRepository;
	private final FlowerRecommendColorRepository flowerRecommendColorRepository;
	private final FlowerRecommendRelationshipRepository flowerRecommendRelationshipRepository;
	private final FlowerRecommendAgeRepository flowerRecommendAgeRepository;
	private final FlowerRecommendMindRepository flowerRecommendMindRepository;
	private final FlowerRecommendVibeRepository flowerRecommendVibeRepository;

	public FlowerRecommendResponse recommendFlower(
		FlowerRelationship relationship, FlowerAge age, FlowerMind mind,
		FlowerColor color, FlowerVibe vibe, Long userId) {
		User user = UserServiceUtils.findUserById(userRepository, userId);

		// 1. 색으로 필터링
		Set<Flower> flowers = getFlowersFilteredByColor(color);

		// 2. 개화 시기 맞는 꽃 필터링, 없을 경우 그대로 유지
		filterByFlowerTime(flowers, LocalDate.now().getMonthValue());

		// 3. 나머지 4가지 조건에 가장 많이 부합하는 꽃들 필터링
		filterByRelevance(flowers, relationship, age, mind, vibe);

		// 4. 필터링된 꽃들 중 랜덤으로 하나 선택
		Flower flower = getRandomFlower(flowers);

		return FlowerRecommendResponse.of(user, flower);
	}

	private Set<Flower> getFlowersFilteredByColor(FlowerColor color) {
		List<FlowerRecommendColor> flowerRecommendColors = flowerRecommendColorRepository
			.findFlowerRecommendColorsByColor(color);
		return flowerRecommendColors.stream()
			.map(FlowerRecommendColor::getFlower)
			.collect(Collectors.toSet());
	}

	private void filterByFlowerTime(Set<Flower> flowers, int month) {
		Set<Flower> result = new HashSet<>();
		flowers.forEach(flower -> {
			if (flower.getFlowerTimes().stream().anyMatch(flowerTime -> flowerTime.getMonth() == month)) {
				result.add(flower);
			}
		});
		if (!result.isEmpty()) {
			flowers = result;
		}
	}

	private void filterByRelevance(Set<Flower> flowers,
		FlowerRelationship relationship, FlowerAge age, FlowerMind mind, FlowerVibe vibe) {
		Map<Flower, Integer> relevanceCount = getRelevanceCountMap(flowers, relationship, age, mind, vibe);
		int max = relevanceCount.keySet().stream()
			.mapToInt(relevanceCount::get)
			.max().getAsInt();
		flowers = flowers.stream()
			.filter(flower -> relevanceCount.get(flower) == max)
			.collect(Collectors.toSet());
	}

	private Flower getRandomFlower(Set<Flower> flowers) {
		Random random = new Random();
		int randomIndex = random.nextInt(flowers.size());
		return flowers.stream()
			.skip(randomIndex)
			.findFirst()
			.get();
	}

	private void countRelevanceByFlower(Map<Flower, Integer> relevanceCount, Flower flower) {
		if (relevanceCount.containsKey(flower)) {
			relevanceCount.put(flower, relevanceCount.get(flower) + 1);
		}
	}

	private Map<Flower, Integer> getRelevanceCountMap(Set<Flower> flowers,
		FlowerRelationship relationship, FlowerAge age, FlowerMind mind, FlowerVibe vibe) {
		Map<Flower, Integer> relevanceCount = new HashMap<>();
		for (Flower flower : flowers) {
			relevanceCount.put(flower, 0);
		}
		flowerRecommendRelationshipRepository.findFlowerRecommendRelationshipsByRelationship(relationship)
			.forEach(flowerRecommendRelationship -> {
				countRelevanceByFlower(relevanceCount, flowerRecommendRelationship.getFlower());
			});
		flowerRecommendAgeRepository.findFlowerRecommendAgesByAge(age)
			.forEach(flowerRecommendAge -> {
				countRelevanceByFlower(relevanceCount, flowerRecommendAge.getFlower());
			});
		flowerRecommendMindRepository.findFlowerRecommendMindsByMind(mind)
			.forEach(flowerRecommendMind -> {
				countRelevanceByFlower(relevanceCount, flowerRecommendMind.getFlower());
			});
		flowerRecommendVibeRepository.findFlowerRecommendVibesByVibe(vibe)
			.forEach(flowerRecommendVibe -> {
				countRelevanceByFlower(relevanceCount, flowerRecommendVibe.getFlower());
			});
		return relevanceCount;
	}

}
