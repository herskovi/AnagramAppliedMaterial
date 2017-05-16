package com.amat.main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.amat.controller.AnagramController;
import com.amat.interfaces.IValidator;
import com.amat.services.AnagramService;

public class AnagramMain 
{
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

		}else if (args.length == 1)
		{
			args = args[0].split(",");
		}
		
		
		addAnotherTaskToExecutor(args, exec, anagramService);	
		
		
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

	private static void addAnotherTaskToExecutor(String[] args, final ExecutorService exec,
			AnagramService anagramService) {
		anagramService.anagramService(exec,args);
	}

}
