package com.amat.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.amat.consts.Consts;
import com.amat.services.AnagramService;

public class AnagramMain 
{
	public static boolean runningWithScanner = true;
	
	public static void main(String[] args) throws Exception 
	{

		
		Scanner scanner = null;
		String word =  null;
		final ExecutorService exec = Executors.newFixedThreadPool(2);
		AnagramService anagramService = new AnagramService();
		
		if(args == null || args.length == 0 )
		{
			// create a scanner so we can read the command-line input
			
			System.out.print("Enter anagram word or 0 to exit: ");
			scanner = new Scanner(System.in);
			word = scanner.next();
			args = word.split(","); 

		}else 
		{
			args = args[0].split(",");
			if (args[args.length-1].equals(Consts.RUNNING_FROM_CLI))
			{
				runningWithScanner = false;
			}
		}
		
		
		addAnotherTaskToExecutor(args, exec, anagramService);	
		runWithScanner(word, exec, anagramService);
	}
	
	/**
	 * 
	 * @param word
	 * @param exec
	 * @param run without Scanner and input will be provided from different client like html.
	 */

	private static void runWithScanner(String word, final ExecutorService exec, AnagramService anagramService) {
		String[] args;
		Scanner scanner;
		if(runningWithScanner)
		{			
		//  prompt for the user's name
			while(!("0".equals(word)))
			{
				System.out.print("Enter anagram word or 0 to exit: ");
				scanner = new Scanner(System.in);
				word = scanner.next();
				if ("0".equals(word))
				 {
					exec.shutdown();
					scanner.close();
				 }else{
					 args = word.split(",");
					 addAnotherTaskToExecutor(args, exec, anagramService);
				 }
			}
		}
	}

	private static void addAnotherTaskToExecutor(String[] args, final ExecutorService exec, AnagramService anagramService) 
	{
		ArrayList<String> anagramWordList = (ArrayList<String>) anagramService.anagramService(exec,args);
	}
	
//	/**
//	 *  Return null in case it is not anagram
//	 *  Return the word in the dictionary in case it is an anagram
//	 */
//	
//	public static String runAnagramService(String args[])
//	{
//		String anagramWord =  null;
//		final ExecutorService exec = Executors.newFixedThreadPool(2);
//		AnagramService anagramService = new AnagramService();
//		if(args == null || args.length == 0 )
//		{	
//			return null;
//		}else{
//			//anagramWord = addAnotherTaskToExecutor(args, exec, anagramService);
//			anagramService.anagramService(exec,args);
//		}
//		return anagramWord;
//		
//		
//	}

}
