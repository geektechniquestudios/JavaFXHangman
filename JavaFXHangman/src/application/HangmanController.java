package application;

import gameLogic.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class HangmanController
{

	@FXML
	private HBox topBox;

	@FXML
	private ImageView hangmanImage;



	private Scene minScene;
	private Scene optionsScene;
	private Parent mainSceneParent;

	private String currentWord;

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

//		String stringToConvert = ((JFXButton) e.getSource()).getText();
//
//
//		char charToSend = stringToConvert.charAt(0);
//
//		boolean[] isArrayRight = GameLogic.checkArrayForMatches(currentWord, charToSend);

	}


}
