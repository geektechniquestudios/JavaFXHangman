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

import fileIO.FileInstantiation;
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

	@FXML private JFXButton aBut;
	@FXML private JFXButton bBut;
	@FXML private JFXButton cBut;
	@FXML private JFXButton dBut;
	@FXML private JFXButton eBut;
	@FXML private JFXButton fBut;
	@FXML private JFXButton gBut;
	@FXML private JFXButton hBut;
	@FXML private JFXButton iBut;
	@FXML private JFXButton jBut;
	@FXML private JFXButton kBut;
	@FXML private JFXButton lBut;
	@FXML private JFXButton mBut;
	@FXML private JFXButton nBut;
	@FXML private JFXButton oBut;
	@FXML private JFXButton pBut;
	@FXML private JFXButton qBut;
	@FXML private JFXButton rBut;
	@FXML private JFXButton sBut;
	@FXML private JFXButton tBut;
	@FXML private JFXButton uBut;
	@FXML private JFXButton vBut;
	@FXML private JFXButton wBut;
	@FXML private JFXButton xBut;
	@FXML private JFXButton yBut;
	@FXML private JFXButton zBut;


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
	private boolean isFirstPlay = true;

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

		startButton.setVisible(false);
		startButton.setDisable(true);
		FileInstantiation.setWordList("WordBank.txt");///////////////////////////////
		currentWord = GameLogic.getRandomWord();
		toBeBlankArray = currentWord.toCharArray();

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
		failCounter = 1;

		imageObject = new Image("/ImageAssets/hangman1.png");
		hangmanImage.setImage(imageObject);

		aBut.setDisable(false);
		bBut.setDisable(false);
		cBut.setDisable(false);
		dBut.setDisable(false);
		eBut.setDisable(false);
		fBut.setDisable(false);
		gBut.setDisable(false);
		hBut.setDisable(false);
		iBut.setDisable(false);
		jBut.setDisable(false);
		kBut.setDisable(false);
		lBut.setDisable(false);
		mBut.setDisable(false);
		nBut.setDisable(false);
		oBut.setDisable(false);
		pBut.setDisable(false);
		qBut.setDisable(false);
		rBut.setDisable(false);
		sBut.setDisable(false);
		tBut.setDisable(false);
		uBut.setDisable(false);
		vBut.setDisable(false);
		wBut.setDisable(false);
		xBut.setDisable(false);
		yBut.setDisable(false);
		zBut.setDisable(false);
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
					isGameBeingPlayed = false;
					startButton.setVisible(true);
					startButton.setDisable(false);
					startButton.setText("You Won!");
					startButton.setTranslateY(185.0);
					isFirstPlay = false;
					wordToGuess.setText(currentWord.toUpperCase());
				}
			}
			else//fires if they guessed wrong
			{
				failCounter++;
				whichHangmanPath = "/ImageAssets/hangman" + failCounter + ".png";
				if(failCounter == 7)//player loses
				{
					isGameBeingPlayed = false;
					startButton.setVisible(true);
					startButton.setDisable(false);
					startButton.setText("Play Again");
					startButton.setTranslateY(185.0);
					isFirstPlay = false;
					wordToGuess.setText(currentWord.toUpperCase());

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
