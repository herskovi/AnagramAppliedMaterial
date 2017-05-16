package com.amat.controller;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class AnagramTest 
{

    @Test
    public void testNoMatches() {
        AnagramController detector = new AnagramController();
        String str = detector.isStringAnagram("ABCDEFGHIJK");
        assertTrue(str==null);
    }

    @Test
    public void testIdenticalWordIsAnagram() 
    {
    	 AnagramController detector = new AnagramController();
    	 String str = detector.isStringAnagram("you");
         assertTrue(str!=null&&str.length()>0);
    }

    @Test
    public void testAngramDoesNotConfuseWithDuplicatesLetters() {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram("see");
    	assertTrue(str!=null&&str.length()>0);    	
    }

    

    @Test
    public void testAnagramsWithLargeNumbeOfLetters() 
    {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    	assertTrue(str==null);
    }

    @Test
    public void testAnagramsWhichExceedNumberLettersInOneWord() 
    {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
    	assertTrue(str==null); 	
    }
    
    @Test
    public void testAnagramsWithNull() 
    {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram(null);
    	assertTrue(str==null); 	
    }
    
    @Test
    public void testAnagramsWithEmptyValue() 
    {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram("");
    	assertTrue(str==null);
    	
    }
    
    @Test
    public void testAnagramsAcceptOnlyLetters() 
    {
    	AnagramController detector = new AnagramController();
    	String str = detector.isStringAnagram("@##$$@no");
    	assertTrue(str==null);
    }


    @Test
    public void testAnagramSubsets() 
    {
    	AnagramController detector = new AnagramController();
    	//i.e. sea, search,seat
    	String str = detector.isStringAnagram("sea");
    	assertTrue(str!=null&&str.length()>0);   
    }
    
    @Test
    public void testAnagramSubsetsWithSpaceAsPrefix() 
    {
    	AnagramController detector = new AnagramController();
    	//i.e. sea, search,seat
    	String str = detector.isStringAnagram(" sea");
    	assertTrue(str==null);
    }


    
    @Test
    public void testAnagramsAreCaseInsensitive() 
    {
    	AnagramController detector = new AnagramController();
    	//i.e. Sea appears as small letter
    	String str = detector.isStringAnagram("Sea");
    	assertTrue(str!=null&&str.length()>0);   
 
    }

}
