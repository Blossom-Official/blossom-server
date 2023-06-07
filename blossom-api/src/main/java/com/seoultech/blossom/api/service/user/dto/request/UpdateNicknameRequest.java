package com.seoultech.blossom.api.service.user.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.seoultech.blossom.common.constant.Constraint;

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
public class UpdateNicknameRequest {

	@Schema(description = "닉네임")
	@NotBlank(message = "{user.nickname.notBlank}")
	@Size(max = Constraint.USER_NICKNAME_MAX, message = "{user.nickname.max}")
	private String nickname;
}
