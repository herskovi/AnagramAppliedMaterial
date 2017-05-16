package com.amat.utils;

public class StringUtils 
{
	
	public static boolean isStringWithOnlyCharacters(String text)
	{
		return  (!text.matches("[a-zA-Z]*") ? false : true);
	}
	
	public static boolean isStringBlank(String text)
	{
		return org.apache.commons.lang3.StringUtils.isBlank(text);				
	}

}
