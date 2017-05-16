package com.amat.controller;
import java.util.*;

import com.amat.consts.Consts;
import com.amat.interfaces.IValidator;
import com.amat.singletone.*;
import com.amat.utils.SortUtils;
import com.amat.validation.AnagramValidator;


public class AnagramController
{

	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Recieve String as input and  return true/false in case word is Anggram    
	 * 				 
	 * @Date:        16-May-2017
	 */

	public String isStringAnagram(String text)
	{
		String str = null;

		if (validateInput(text)) 
		{
			text = text.toLowerCase();
			str = Anagram.getInstance().isWordExistsInLexicographicalDictionary(SortUtils.convertStringToLexicographical(text));
			return (str ==  null ? null : (str.length() > 0 ? str : null)) ;
		}
		return str;

	}



	/**
	 * @author:      Moshe Herskovits
	 * @param text 
	 * @Descreption: Validate on String    
	 * 				 
	 * @Date:        16-May-2017
	 */

	private boolean validateInput(String text) {
		boolean validationPass = true;
		IValidator mValidator = new  AnagramValidator(text);
		try {
			mValidator.validate();
			validationPass = mValidator.isValidationPass();

		} catch (Exception e) 
		{
			System.out.println("Exception was caught at " + e.getMessage());
		}
		return validationPass; 
	}





}
