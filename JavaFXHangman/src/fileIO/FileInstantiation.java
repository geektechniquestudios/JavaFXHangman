package fileIO;


import java.util.ArrayList;

public class FileInstantiation 
{
	FileManagement someFileManagement;
	
	public static void writeNewWord(String wordToAdd)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.writeToFile(wordToAdd);
	}
	
	public static ArrayList<String> getRandomWordArrList()
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openFile();
		ArrayList<String> arrayListToReturn = someFileManagement.readFile();
		someFileManagement.closeFile();
		
			return arrayListToReturn;
	}
	
	public static void deleteSomeWord(int indexOfWordToDelete)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openFile();
		ArrayList<String> listOfCurrentFile = someFileManagement.readFile();
		listOfCurrentFile.remove(indexOfWordToDelete);	
		someFileManagement.writeCleanToFile(listOfCurrentFile);
		someFileManagement.closeFile();
	}
}