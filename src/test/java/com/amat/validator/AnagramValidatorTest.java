package com.amat.validator;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.amat.controller.AnagramController;
import com.amat.validation.AnagramValidator;

public class AnagramValidatorTest 
{	
	
	
	@Test
    public void testStringNull() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator(null);
		anagramValidator.isStringBlankOrEmpty();
		assertFalse(anagramValidator.isValidationPass());	
    }
	
	@Test
    public void testStringAsNull() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator(null);
		anagramValidator.isStringOnlyIncludeCharacters();
		assertFalse(anagramValidator.isValidationPass());	
    }
	
	@Test
    public void testStringDoesNotIncludeUniqueCharacters() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator("@#$");
		anagramValidator.isStringOnlyIncludeCharacters();
		assertFalse(anagramValidator.isValidationPass());	
    }
	
	@Test
    public void testStringOnlyIncludeCharacters() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator("AbRs");
		anagramValidator.isStringOnlyIncludeCharacters();
		assertTrue(anagramValidator.isValidationPass());	
    }
	
	@Test
    public void testStringLengthIsGreaterThanMaximum() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		anagramValidator.isStringExceedMaximumNumberOfLetters();
		assertFalse(anagramValidator.isValidationPass());	
    }
	
	@Test
    public void testStringLengthLessThanMinimum() throws Exception 
	{
		AnagramValidator anagramValidator = new AnagramValidator("");
		anagramValidator.isStringBelowMinimumNumberOfLetters();
		//The word a consider as word in the dictionary
		assertTrue(anagramValidator.isValidationPass());	
    }
	


}
