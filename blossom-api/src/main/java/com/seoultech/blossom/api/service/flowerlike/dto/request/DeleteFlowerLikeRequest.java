package com.seoultech.blossom.api.service.flowerlike.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteFlowerLikeRequest {

	@Schema(description = "꽃 좋아요를 삭제할 꽃 id 리스트")
	@NotNull(message = "{flowerLike.flowerIds.notNull}")
	@Size(min = 1, message = "{flowerLike.flowerIds.size}")
	private List<Long> flowerIds;
}
