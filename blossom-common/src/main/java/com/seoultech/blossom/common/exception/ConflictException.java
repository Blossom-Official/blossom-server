package com.seoultech.blossom.common.exception;

public class ConflictException extends BlossomException {

	public ConflictException(String message) {
		super(message, ErrorCode.CONFLICT_EXCEPTION);
	}

	public ConflictException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
