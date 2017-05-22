package com.amat.rest;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amat.consts.Consts;
import com.amat.controller.AnagramController;



/**
 * Handles requests for the Employee service.
 */

@RestController
public class AnagramRest
{
//	@Autowired
//	private CandidateService candidateService;

	private static final Logger logger = LoggerFactory.getLogger(AnagramRest.class);
	//Map to store employees, ideally we should use database
	

	

	@RequestMapping(value = Consts.GET_ANAGRAM, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> isAnagram(@PathVariable("word") String anagramText) 
	{
		logger.info("Start anagram ID="+anagramText);
		//String args[0] = anagramText;
		String[] array = anagramText.split(",");
		String responseText = null;
		List<String> anagramWordList  = new ArrayList<String>();
		
		//AnagramMain anagram = new AnagramMain();
		try 
		{
			anagramWordList = (ArrayList<String>) AnagramController.runAnagramService(array);
			for (String anagramWord : anagramWordList)
			{
				System.out.println("List Size "  + anagramWord);
			}
			
		} catch (Exception e) 
		{
			logger.debug("Exception " + e.getMessage());
		}
		logger.debug("responseText " + responseText);
		return anagramWordList;
		
	
	}
	
	/**
	 * 
	 * @param a
	 * @param e
	 * @return
	 */


	static String[] addElement(String[] a, String e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}



}