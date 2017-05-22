package com.amat.controller;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.amat.consts.Consts;
import com.amat.interfaces.IValidator;
import com.amat.services.AnagramService;
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
	
	/**
	 * 
	 * @param args
	 * @return
	 */
	
	public static List runAnagramService(String args[])
	{
		List anagramWordList =  null;
		final ExecutorService exec = Executors.newFixedThreadPool(2);
		AnagramService anagramService = new AnagramService();
		if(args == null || args.length == 0 )
		{	
			return null;
		}else{
			//anagramWord = addAnotherTaskToExecutor(args, exec, anagramService);
			anagramWordList = anagramService.anagramService(exec,args);
		}
		return anagramWordList;
		
		
	}





}
