package com.seoultech.blossom.common.exception;

public class BadGatewayException extends BlossomException {

	public BadGatewayException(String message) {
		super(message, ErrorCode.BAD_GATEWAY_EXCEPTION);
	}

}
