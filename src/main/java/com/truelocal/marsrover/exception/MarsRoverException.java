package com.truelocal.marsrover.exception;

public class MarsRoverException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCodes errorCode;
	
	public MarsRoverException(ErrorCodes errorCode) {
		this.errorCode = errorCode;		
	}
	
	public MarsRoverException(ErrorCodes errorCode, Exception cause) {
		super(cause);
		this.errorCode = errorCode;		
	}
	
	public MarsRoverException(ErrorCodes errorCode, String message, Exception cause) {
		super(message, cause);
		this.errorCode = errorCode;	
	}
	
	public ErrorCodes getErrorCode() {
		return errorCode;
	}
}
