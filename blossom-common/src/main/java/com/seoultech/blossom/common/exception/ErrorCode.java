package com.seoultech.blossom.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

	// Validation Exception
	VALIDATION_EXCEPTION("V001", "잘못된 요청입니다."),
	METHOD_NOT_ALLOWED_EXCEPTION("V002", "지원하지 않는 메소드입니다."),
	UNSUPPORTED_MEDIA_TYPE("V003", "허용하지 않는 미디어 타입입니다."),
	VALIDATION_INVALID_TOKEN_EXCEPTION("V004", "잘못된 토큰입니다."),
	VALIDATION_DELETE_FLOWER_LIKE_EXCEPTION("V005", "잘못된 꽃 좋아요 삭제 요청입니다."),
	VALIDATION_FILE_NAME_EXCEPTION("V006", "잘못된 파일의 originalFilename 입니다."),
	VALIDATION_FILE_TYPE_EXCEPTION("V007", "잘못된 확장자 형식의 파일입니다."),

	// Unauthorized Exception
	UNAUTHORIZED_EXCEPTION("U001", "토큰이 만료되었습니다. 다시 로그인 해주세요."),

	// Forbidden Exception
	FORBIDDEN_EXCEPTION("F001", "허용하지 않는 접근입니다."),

	// NotFound Exception
	NOT_FOUND_EXCEPTION("N001", "존재하지 않습니다."),
	NOT_FOUND_USER_EXCEPTION("N002", "탈퇴했거나 존재하지 않는 유저입니다."),
	NOT_FOUND_FLOWER_EXCEPTION("N003", "존재하지 않는 꽃입니다."),
	NOT_FOUND_CONTENT_EXCEPTION("N004", "존재하지 않는 컨텐츠입니다."),

	// Conflict Exception
	CONFLICT_EXCEPTION("C001", "이미 존재합니다."),
	CONFLICT_USER_EXCEPTION("C002", "이미 해당 계정으로 회원가입하셨습니다.\n로그인 해주세요."),
	CONFLICT_FLOWER_LIKE_EXCEPTION("C003", "꽃 좋아요 상태가 요청하신 상태와 충돌합니다."),

	// Unsupported Media Type Exception

	// Internal Server Exception
	INTERNAL_SERVER_EXCEPTION("I001", "서버 내부에서 에러가 발생하였습니다."),

	// Bad Gateway Exception
	BAD_GATEWAY_EXCEPTION("B001", "외부 연동 중 에러가 발생하였습니다.");

	private final String code;
	private final String message;

}
