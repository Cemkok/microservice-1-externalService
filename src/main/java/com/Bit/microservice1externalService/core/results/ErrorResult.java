package com.Bit.microservice1externalService.core.results;

public class ErrorResult  extends Result{
	public ErrorResult() {
		super(false);
	} 
	/**
	 * 
	 * @param message
	 */
	public ErrorResult(String message) {
		super(false,message);
	} 



}