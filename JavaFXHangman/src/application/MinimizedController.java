package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
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

public class MinimizedController {

	@FXML
	private HBox topBox;
	private Scene optionsScene;
    private Scene mainScene;

    @FXML
    private void setSceneOptions()
    {

    }

    @FXML
	private void quitGame()
	{
		System.exit(0);
	}

    public void setOptionsScene(Scene someScene)
    {
    	optionsScene = someScene;
    }

    public void setMainScene(Scene scene)
    {
        mainScene = scene;
    }

    //@FXML
    public void openGameScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
        mainScene.getRoot().requestFocus();
    }

    public void openOptionsScene(ActionEvent actionEvent) //throws IOException
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(optionsScene);
        optionsScene.getRoot().requestFocus();
    }

    public void minimizeScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

}