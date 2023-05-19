package com.seoultech.blossom.api.service.flowerlike;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import java.util.List;
import java.util.stream.Collectors;

import com.seoultech.blossom.common.exception.ConflictException;
import com.seoultech.blossom.common.exception.ValidationException;
import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowerLikeServiceUtils {

	public static void validateCheckFlowerLikeRequest(FlowerLike flowerLike, Boolean isCheck) {
		if (flowerLike == null && !isCheck) {
			throw new ConflictException("꽃 좋아요 상태 충돌입니다.", CONFLICT_FLOWER_LIKE_EXCEPTION);
		}
		if (flowerLike != null && isCheck) {
			throw new ConflictException("꽃 좋아요 상태 충돌입니다.", CONFLICT_FLOWER_LIKE_EXCEPTION);
		}
	}

	public static void validateDeleteFlowerLikeRequest(List<FlowerLike> flowerLikes, List<Long> flowerIds) {
		List<Long> flowerLikeFlowerIds = flowerLikes
			.stream()
			.map(flowerLike -> flowerLike.getFlower().getId())
			.collect(Collectors.toList());
		for (Long id : flowerIds) {
			if (!flowerLikeFlowerIds.contains(id)) {
				throw new ValidationException("잘못된 꽃 좋아요 삭제 요청입니다.", VALIDATION_DELETE_FLOWER_LIKE_EXCEPTION);
			}
		}
	}
}
