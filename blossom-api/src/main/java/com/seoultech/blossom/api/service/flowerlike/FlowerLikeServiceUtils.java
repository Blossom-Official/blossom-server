package com.seoultech.blossom.api.service.flowerlike;

import static com.seoultech.blossom.common.exception.ErrorCode.*;

import com.seoultech.blossom.common.exception.ConflictException;
import com.seoultech.blossom.domain.domain.flowerlike.FlowerLike;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowerLikeServiceUtils {

	public static void validateFlowerLikeRequest(FlowerLike flowerLike, Boolean isCheck) {
		if (flowerLike == null && !isCheck) {
			throw new ConflictException("꽃 좋아요 상태 충돌입니다.", CONFLICT_FLOWER_LIKE_EXCEPTION);
		}
		if (flowerLike != null && isCheck) {
			throw new ConflictException("꽃 좋아요 상태 충돌입니다.", CONFLICT_FLOWER_LIKE_EXCEPTION);
		}
	}
}
