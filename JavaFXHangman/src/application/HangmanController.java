package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.io.IOException;
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

public class HangmanController
{

	@FXML
	private HBox topBox;
	private Scene minScene;
	private Scene optionsScene;

	@FXML
	private void setSceneOptions()
	{
		System.out.println("options works");
	}

	@FXML
	private void quitGame()
	{
		System.exit(0);
	}

	@FXML
	private void setSceneMinimize()
	{

	}

    public void setMinScene(Scene scene)
    {
        minScene = scene;
    }

    public void setOptionsScene(Scene someScene)
    {
    	optionsScene = someScene;
    }

    //@FXML
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




}
