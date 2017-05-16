package com.amat.interfaces;

public interface IValidator
{
	
	public void validate() throws Exception;
	public boolean isValidationPass() throws Exception;
	public void setValidationPass(boolean validationPassIndicator) throws Exception;
	

}
