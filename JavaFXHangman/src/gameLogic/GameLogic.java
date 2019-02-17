//Created by Terry Dorsey//

package gameLogic;

import java.util.ArrayList;
import java.util.Random;

import fileIO.*;

public class GameLogic 
{
	static ArrayList<String> wordBank = new ArrayList<String>();
	
	public static String getRandomWord()
	{	
		wordBank = FileInstantiation.getRandomWordArrList();
		
		Random randomNumGen = new Random();
		int randomWordIndex = randomNumGen.nextInt(wordBank.size()) + 0;
		
		return wordBank.get(randomWordIndex);
		
	}
	
	public static boolean[] checkArrayForMatches(String currentWord, char charToTest)//generates a boolean array in response to the user's guess against the current word
	{
		String upperCaseCurretWord = currentWord.toUpperCase();
		char[] currentWordArray = upperCaseCurretWord.toCharArray();
		boolean[] returnArray = new boolean[currentWordArray.length];
		
		for(int x = 0; x < returnArray.length; x++)
		{
			char characterInArray = currentWordArray[x];
			if(characterInArray == charToTest)
			{
				returnArray[x] = true;
			}
			else 
			{
				returnArray[x] = false;
			}		
		}
 		return returnArray;
	}
	
	public static boolean doesArrayContainATrue(boolean[] someBoolArray)
	{
		for (boolean x : someBoolArray)
		{
			if(x == true) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean doesArrayContainUnderscores(char[] someCharArray)
	{
		for(char x : someCharArray)
		{
			if(x == '_')
			{
				return true;
			}	
		}
		return false;
	}
}