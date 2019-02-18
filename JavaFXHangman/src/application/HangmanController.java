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



	private Scene minScene;
	private Scene optionsScene;
	private Parent mainSceneParent;

	private String currentWord;
	private String wordToDisplay;

//	@FXML
//	private void setSceneOptions()
//	{
//		System.out.println("options works");
//	}

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

    public void setWordToDisplay(String wordToSet)
    {
    	wordToDisplay = wordToSet;
    }

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

//	public String setCurrentWord()
//	{
//
//
//		return RandomWord;
//	}

	public void keyboardAction(ActionEvent e) //every time a Letter is tried, this is fired
	{
		((JFXButton) e.getSource()).setDisable(true);//disables current button
		mainSceneParent.requestFocus();//makes it so no button is focused after a selection is made

		String stringToConvert = ((JFXButton) e.getSource()).getText();


		char charToSend = stringToConvert.charAt(0);

		boolean[] isArrayRight = GameLogic.checkArrayForMatches(currentWord, charToSend);


	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		wordToGuess.setText(wordToDisplay);
	}


}
