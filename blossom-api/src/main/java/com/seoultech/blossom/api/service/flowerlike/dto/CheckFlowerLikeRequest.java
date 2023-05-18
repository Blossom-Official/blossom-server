package com.seoultech.blossom.api.service.flowerlike.dto;

import javax.validation.constraints.NotNull;

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
public class CheckFlowerLikeRequest {

	@Schema(description = "체크 - true, 해제 - false")
	@NotNull(message = "{flowerLike.isCheck.notNull}")
	private Boolean isCheck;
}
