package com.amat.services;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

import org.apache.commons.lang3.ArrayUtils;

import com.amat.controller.AnagramController;
import com.amat.singletone.Anagram;

public class AnagramService 
{

	public List<String> anagramService(final Executor exec, String[] args) 
	{
		

		if (!(ArrayUtils.isEmpty(args)))
		{
			List list = new ArrayList<String>(args.length);
			Anagram.getInstance();//initialize the singletone;
			int size = args.length;
			CompletionService<String> completionService = new ExecutorCompletionService<>(exec);
			
			for (int i = 0; i < size; i++) 
			{
				
				final String word = args[i].toLowerCase(); 
				final StringBuffer sb = new StringBuffer("The word @@@@@@ ");
				Callable<String> task = new Callable<String>() {

					@Override
					public String call() {
						try {
							AnagramController anagramController = new AnagramController(); 
							String isStringAnagram = anagramController.isStringAnagram(word);  
							//System.out.println("Ended: "+  Thread.currentThread() + " at " + new Date());
							sb.append(word);
							sb.append(" @@@@@@@@@@@@@ is "); 
							sb.append( isStringAnagram==null ? " NOT an ANAGRAM " : " an ANAGRAM for the word @@@@@ " + isStringAnagram + " @@@@@@@");
							
							//sb.append(" Time was taken for the algorithm " + (endTime - startTime));
							
							//System.out.println( "Can the word " + word + " considered as Anagram? " + isStringAnagram );
						} catch (Exception e) {
							e.printStackTrace();
						}
						return sb.toString();
					}
				};

				// Submitting the task to the CompletionService
				completionService.submit(task);
			}

			// Waiting for the results and printing them
			for (int i = 0; i < size; i++) {
				Future<String> f;
				try {
					f = completionService.take();
					System.out.println( f.get());
					list.add(f.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			return list;
			
		}
		return null;
		
	}
}