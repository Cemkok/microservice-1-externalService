package com.Bit.microservice1externalService.core.results;
	
public class SuccessResult extends Result{
	
	public SuccessResult() {
		super(true);
	} 
		/**
		 * 
		 * @param message
		 */
	public SuccessResult(String message) {
		super(true,message);
	}  

}
