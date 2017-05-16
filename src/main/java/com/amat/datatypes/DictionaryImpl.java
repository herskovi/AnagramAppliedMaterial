package com.amat.datatypes;

import java.util.ArrayList;
import java.util.HashMap;

import com.amat.consts.Consts;
import com.amat.interfaces.IDictionary;

public class DictionaryImpl implements IDictionary 
{
	private  ArrayList<String>  dictionary = new ArrayList<String>();
    private  String languagesName = Consts.DEAFUALT_LANGUAGE_IS_ENGLISH;
    
    
	public ArrayList<String> getDictionary() {
		return dictionary;
	}
	public void setDictionary(ArrayList<String> dictionary) {
		this.dictionary = dictionary;
	}
	public String getLanguagesName() {
		return languagesName;
	}
	public void setLanguagesName(String languagesName) {
		this.languagesName = languagesName;
	}
	
    
    
    

}
