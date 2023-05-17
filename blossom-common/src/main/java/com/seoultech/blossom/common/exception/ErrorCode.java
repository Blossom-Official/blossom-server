package com.seoultech.blossom.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

	// Common
	UNAUTHORIZED_EXCEPTION("C001", "토큰이 만료되었습니다. 다시 로그인 해주세요."),
	NOT_FOUND_EXCEPTION("C002", "존재하지 않습니다."),
	VALIDATION_EXCEPTION("C003", "잘못된 요청입니다."),
	CONFLICT_EXCEPTION("C004", "이미 존재합니다."),
	INTERNAL_SERVER_EXCEPTION("C005", "서버 내부에서 에러가 발생하였습니다."),
	METHOD_NOT_ALLOWED_EXCEPTION("C006", "지원하지 않는 메소드입니다."),
	BAD_GATEWAY_EXCEPTION("C007", "외부 연동 중 에러가 발생하였습니다."),
	FORBIDDEN_EXCEPTION("C008", "허용하지 않는 접근입니다."),
	UNSUPPORTED_MEDIA_TYPE("C009", "허용하지 않는 미디어 타입입니다."),

	// Validation Exception
	VALIDATION_INVALID_TOKEN_EXCEPTION("V001", "잘못된 토큰입니다."),

	// Forbidden Exception

	// NotFound Exception
	NOT_FOUND_USER_EXCEPTION("N001", "탈퇴했거나 존재하지 않는 유저입니다."),
	NOT_FOUND_FLOWER_EXCEPTION("N002", "존재하지 않는 꽃입니다."),

	// Conflict Exception
	CONFLICT_USER_EXCEPTION("C001", "이미 해당 계정으로 회원가입하셨습니다.\n로그인 해주세요.");

	private final String code;
	private final String message;

}
