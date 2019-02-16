package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.application.Application;
import javafx.stage.StageStyle;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.fxml.FXMLLoader;

public class OptionsController
{
	@FXML
	private HBox topBox;
	private Scene mainScene;
	private Scene minScene;

	@FXML
	private void quitGame()
	{
		System.exit(0);
	}

	public void setMainScene(Scene scene)
    {
        mainScene = scene;
    }

    public void setMinScene(Scene someScene)
    {
    	minScene = someScene;
    }

	public void openGameScene(ActionEvent actionEvent) //throws IOException
	{
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	    primaryStage.setScene(mainScene);
	    mainScene.getRoot().requestFocus();
	}

	public void openMinScene(ActionEvent actionEvent) //throws IOException
	{
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	    primaryStage.setScene(minScene);
	    minScene.getRoot().requestFocus();
	}
}
