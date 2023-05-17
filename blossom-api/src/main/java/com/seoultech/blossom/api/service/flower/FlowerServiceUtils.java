package com.seoultech.blossom.api.service.flower;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import com.seoultech.blossom.common.exception.NotFoundException;
import com.seoultech.blossom.domain.domain.flower.Flower;
import com.seoultech.blossom.domain.domain.flower.repository.FlowerRepository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowerServiceUtils {

	public static Flower findFlowerById(FlowerRepository flowerRepository, Long flowerId) {
		Flower flower = flowerRepository.findFlowerById(flowerId);
		if (flower == null) {
			throw new NotFoundException(String.format("존재하지 않는 꽃 (%s) 입니다", flowerId), NOT_FOUND_FLOWER_EXCEPTION);
		}
		return flower;
	}
}
