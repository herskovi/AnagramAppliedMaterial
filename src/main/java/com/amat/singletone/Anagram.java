package com.amat.singletone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.amat.consts.Consts;
import com.amat.datatypes.DictionaryImpl;
import com.amat.interfaces.IAnagram;
import com.amat.utils.FileUtils;
import com.amat.utils.SortUtils;




public class Anagram  implements IAnagram
{
	private DictionaryImpl  dictionary = new DictionaryImpl(); 
	private ConcurrentMap<String,String>  lexicographicalDictionary = new ConcurrentHashMap<String,String>();

    private static Anagram instance;
    private static int maxLettersInEntireDictionary = 0;
    private static int minLettersInEntireDictionary = 5;
    
    
    private Anagram()
    {
    	loadDictionaryFromFile(Consts.FILE_NAME);
    	populateLexicographicalMap();
    }


    /**
	 * @author:      Moshe Herskovits
	 * @Descreption: Create only one instance of this object.   
	 * 				 
	 * @Date:        16-May-2017
	 */

	public static Anagram getInstance()
	{
		if(instance == null){
            instance = new Anagram();
        }
        return instance;
    }

	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Give File Name Read Dictionary from file  
	 * 				 by lexicographical order.
	 * @Date:        16-May-2017
	 */

	
	private void loadDictionaryFromFile(String fileName) 
	{
		FileUtils fileUtils = new FileUtils();
        dictionary.setDictionary(fileUtils.readFromFile(fileName));
	}



	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Sort Original Dictionary andpopulate hashmap  with String that is sorted 
	 * 				 by lexicographical order.
	 * @Date:        16-May-2017
	 */
	
	
	private void populateLexicographicalMap() 
    {
		for (String word : dictionary.getDictionary())
    	{
    		if (word !=null)
    		{
    			
	    		char [] p = word.toLowerCase().toCharArray();//handle case insensitive
	    		Arrays.sort(p);
	    		lexicographicalDictionary.put(new String(p), word);
	    		setMaximumOrMinimum(p);
    		}
    	}
		
	}
	

	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Capture the word with Maximum or Minimum length at entire Dictionary 
	 * @Date:        16-May-2017
	 */
	


	private void setMaximumOrMinimum(char[] p) {
		if (p.length > maxLettersInEntireDictionary)
		{
			maxLettersInEntireDictionary = p.length;
		}else if (p.length < minLettersInEntireDictionary)
		{
			minLettersInEntireDictionary = p.length;
		}
	}
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Receive String and sort it by lexicographical order.
	 * 				 Check if  word exist on the dictionary
	 * @Date:        16-May-2017
	 */
    
    public String isWordExistsInLexicographicalDictionary(String text)
    {
    	return lexicographicalDictionary.get(SortUtils.convertStringToLexicographical(text));
    }
    
    /**
	 * @author:      Moshe Herskovits
	 * @Descreption: Receive String and sort it by lexicographical order.
	 * 				 Check if  word exist on the dictionary
	 * @Date:        16-May-2017
	 */
    
    public String getOriginalWordByLexicographicalDictionary(String lexicographical)
    {
    	return lexicographicalDictionary.get(lexicographical);
    }
    
    /**
	 * @author:      Moshe Herskovits
	 * @Descreption: Receive the maximum characters in one  word on entire dictionary. 
	 * 				 
	 * @Date:        16-May-2017
	 */
    
    
    public int getMaxLettersInDictionary()
    {
    	return maxLettersInEntireDictionary;
    }
    
    
    /**
	 * @author:      Moshe Herskovits
	 * @Descreption: Receive the minimum characters in one word on entire dictionary. 
	 * @Date:        16-May-2017
	 */
    
    public int getMinLettersInDictionary()
    {
    	return minLettersInEntireDictionary;
    }




}
