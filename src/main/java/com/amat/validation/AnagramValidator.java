package com.amat.validation;

import com.amat.singletone.Anagram;
import com.amat.utils.StringUtils;

public class AnagramValidator extends Validator
{
	private String text = "";

	public AnagramValidator(String text) 
	{
		super();
		this.text = text;
	}
	public AnagramValidator() 
	{
		super();
	}
	
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Perform Validation on String    
	 * @Date:        16-May-2017
	 */
	
	@Override
	public void validate() throws Exception 
	{
		isStringBlankOrEmpty();
		isStringOnlyIncludeCharacters();

	}

	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Validate on is String Only Include Characters    
	 */
	
	public void isStringOnlyIncludeCharacters()
	{
		if  (StringUtils.isStringBlank(text) || !(StringUtils.isStringWithOnlyCharacters(text))) 
			setValidationPass(false); 
	}
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: is String Blank Or Empty    
	 */
	
	public void isStringBlankOrEmpty()
	{
		if (StringUtils.isStringBlank(text)) 
			setValidationPass(false); 
	}
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: is String exceed Maximum Number Of Letters     
	 */
	
	public void isStringExceedMaximumNumberOfLetters()
	{
		if (text!= null && Anagram.getInstance().getMaxLettersInDictionary() < text.length())
			setValidationPass(false); 
	}
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: is String below Minimum Number Of Letters     
	 */
	
	public void isStringBelowMinimumNumberOfLetters()
	{
		if (text!= null && Anagram.getInstance().getMinLettersInDictionary() > text.length())
			setValidationPass(false); 
	}




	public String getText() 
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}




}
