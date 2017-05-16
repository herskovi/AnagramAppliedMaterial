package com.amat.utils;

import java.util.Arrays;

import com.amat.consts.Consts;

public class SortUtils 
{
	
	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Receive text and sort it by Lexicographical  order   
	 * 				 
	 * @Date:        16-May-2017
	 */
	
	public static String convertStringToLexicographical(String text)
	{
		String lexicographicalStr = null;
		if (text != null)
		{
			char [] textChar = text.toCharArray();
			Arrays.sort(textChar);
			lexicographicalStr =  new String(textChar);
		}
		return lexicographicalStr;
	}
}
