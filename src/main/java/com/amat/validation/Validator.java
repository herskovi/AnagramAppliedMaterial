package com.amat.validation;

import com.amat.controller.AnagramController;
import com.amat.interfaces.IValidator;

public abstract class Validator implements IValidator 

{
	private boolean validationPassIndicator = false;
	
	

	
	public Validator() 
	{
		setValidationPass(true);
	}

	
	public abstract void validate() throws Exception; 
	

	@Override
	public boolean isValidationPass()  
	{
		return validationPassIndicator;
	}

	@Override
	public void setValidationPass(boolean validationPassIndicator)  
	{
		this.validationPassIndicator = validationPassIndicator;
		
	}
	
	

}
