package com.seoultech.blossom.common.exception;

public class ValidationException extends BlossomException {

	public ValidationException(String message) {
		super(message, ErrorCode.VALIDATION_EXCEPTION);
	}

	public ValidationException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

}
