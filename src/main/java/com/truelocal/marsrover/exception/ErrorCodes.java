package com.truelocal.marsrover.exception;

public enum ErrorCodes {
	ERROR_READING_FILE("An error occurred while reading input file"),
	INPUT_INVALID("Please provide a valid input: {0}"),
	GENERIC_ERROR("There is an error occurred");
	private String errorMessage;
	
	private ErrorCodes(String errorMessage){
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
