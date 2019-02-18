package application;

import gameLogic.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class HangmanController implements Initializable
{
	@FXML private HBox topBox;
	@FXML private ImageView hangmanImage;
	@FXML private Label wordToGuess;
	@FXML private JFXButton startButton;
	@FXML private HBox startButtonHBox;
	
	private char[] currentWordArray; 
	private char[] toBeBlankArray;
	private Scene minScene;
	private Scene optionsScene;
	private Parent mainSceneParent;
	private String currentWord;
	private String wordToDisplay;
	private String whichHangmanPath;
	private int failCounter = 1;
	private Image imageObject;
	private boolean isGameBeingPlayed;
	
	@FXML
 	private void quitGame()
	{
		System.exit(0);
	}

    public void setMinScene(Scene scene)
    {
        minScene = scene;
    }

    public void setOptionsScene(Scene someScene)
    {
    	optionsScene = someScene;
    }

    public void setMainParent(Parent someSceneParent)//for botton focus
    {
    	mainSceneParent = someSceneParent;
    }

    public void setCurrentWord(String currentWordtoUse)
    {
    	currentWord = currentWordtoUse;
    }

//    public void setWordToDisplay(String wordToSet)
//    {
//    	wordToDisplay = wordToSet;
//    	System.out.println(wordToDisplay);
//    }

    public void openGameScene(ActionEvent actionEvent) //throws IOException
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(minScene);
        minScene.getRoot().requestFocus();
    }

	public void openOptionsScene(ActionEvent actionEvent) //throws IOException
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(optionsScene);
        optionsScene.getRoot().requestFocus();
    }

	public void startButtonClicked(ActionEvent e)
	{
		((JFXButton) e.getSource()).setDisable(true);
		((JFXButton) e.getSource()).getParent().setVisible(false);
		//startButtonHBox.getChildren().remove(startButton);//to remove it
		currentWord = GameLogic.getRandomWord();
		toBeBlankArray = currentWord.toCharArray();
//		wordToDisplay = GameLogic.randWordToHidden(currentWord);
//		wordToGuess.setText(wordToDisplay);
		for(int x = 0; x < toBeBlankArray.length; x++)
		{
			if(toBeBlankArray[x] != ' ')//ensures that spaces don't become underscores
			{
				toBeBlankArray[x] = '_';
			}
		}
		
		String wordToDisplay = new String(toBeBlankArray);//toBeBlankArray.toString(); wasn't working, so String Constructor
		wordToGuess.setText(wordToDisplay);
		isGameBeingPlayed = true;
		


	}

	public void keyboardAction(ActionEvent e) //every time a Letter is tried, this is fired
	{
		if(isGameBeingPlayed == true)
		{
			((JFXButton) e.getSource()).setDisable(true);//disables current button
			mainSceneParent.requestFocus();//makes it so no button is focused after a selection is made
	
			String stringToConvert = ((JFXButton) e.getSource()).getText();
	
			char charToSend = stringToConvert.charAt(0);
	
			boolean[] isArrayRight = GameLogic.checkArrayForMatches(currentWord, charToSend);
			
			String upperCaseCurretWord = currentWord.toUpperCase();						
			currentWordArray = upperCaseCurretWord.toCharArray();
			
			
			//takes the blanks and fills in the letter if guess was correct
			for(int x = 0; x < isArrayRight.length; x++)
			{
				if(isArrayRight[x] == true)
				{
					toBeBlankArray[x] = currentWordArray[x];
				}
			}
			
			String wordToShow = new String(toBeBlankArray);
			wordToGuess.setText(wordToShow); //refreshes the JPanel holding the word to guess
			
			if((GameLogic.doesArrayContainATrue(isArrayRight)) == true)//if user guesses correctly
			{
				if((GameLogic.doesArrayContainUnderscores(toBeBlankArray)) == false)//user has won
				{
					//userWin Popup, prompt replay
				}
			}
			else//fires if they guessed wrong
			{
				failCounter++;
				whichHangmanPath = "/ImageAssets/hangman" + failCounter + ".png";
				if(failCounter == 7)//player loses
				{
					isGameBeingPlayed = false;
					//userLose Popup
				}
				
				imageObject = new Image(whichHangmanPath);
				hangmanImage.setImage(imageObject);
	//			hangmanHolder.setIcon//updates image to add body part
	//			(
	//				new ImageIcon(getClass().getResource(whichHangmanPath))
	//			);
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		//System.out.println(wordToDisplay);
//		currentWord = GameLogic.getRandomWord();
//		wordToDisplay = GameLogic.randWordToHidden(currentWord);
//		wordToGuess.setText(wordToDisplay);//do this on start click
	}
}
