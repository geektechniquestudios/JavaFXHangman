package fileIO;


import java.util.ArrayList;

public class FileInstantiation
{
	private static String wordListType;

	public static void setWordList(String whichWordList)
	{
		wordListType = whichWordList;
	}
	
	public static void writeNewWord(String wordToAdd)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.writeToFile(wordToAdd);
	}

	public static ArrayList<String> getRandomWordArrList()
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setWordList(wordListType);
		someFileManagement.openFile();
		ArrayList<String> arrayListToReturn = someFileManagement.readFile();
		someFileManagement.closeFile();

		return arrayListToReturn;
	}

	public static void deleteSomeWord(int indexOfWordToDelete)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setWordList(wordListType);
		someFileManagement.openFile();
		ArrayList<String> listOfCurrentFile = someFileManagement.readFile();
		listOfCurrentFile.remove(indexOfWordToDelete);
		someFileManagement.writeCleanToFile(listOfCurrentFile);
		someFileManagement.closeFile();
	}

	public static boolean getToggleState()
	{
		boolean boolToReturn = true;//acts as exception protection, and suppresses warnings

		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openMemoryFile();
		String stateToReturn = someFileManagement.readMemoryFile();
		if(stateToReturn.equals("toggleOn"))
		{
			boolToReturn = true;
		}
		else if (stateToReturn.equals("toggleOff"))
		{
			boolToReturn = false;
		}
		return boolToReturn;
	}

	public static void setToggleState(boolean toggleState)
	{
		String stringToPass;
		if(toggleState)
		{
			stringToPass = "toggleOn";
		}
		else
		{
			stringToPass = "toggleOff";
		}
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.setToggleState(stringToPass);
		someFileManagement.writeToMemoryFile(stringToPass);
	}
}