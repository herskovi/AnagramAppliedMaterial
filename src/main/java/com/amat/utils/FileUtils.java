package com.amat.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.amat.consts.Consts;

public class FileUtils 
{

	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Check that File Can be read and convert into ArrayList   
	 * 				 
	 * @Date:        16-May-2017
	 */


	public   ArrayList<String> readFromFile(String fileName) 
	{
		ArrayList<String> dictionary = new ArrayList<String>();
		BufferedReader br = null;
		readFromFile(dictionary, br);
		return dictionary;
	}


	/**
	 * @author:      Moshe Herskovits
	 * @Descreption: Each Line represent a word   
	 * 				 
	 * @Date:        16-May-2017
	 */


	private  void readFromFile(ArrayList<String> dictionary, BufferedReader br) 
	{
		String line =null;

		try
		{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(Consts.FILE_NAME)));

			while ((line = br.readLine()) != null) 
			{
				dictionary.add(line);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}



