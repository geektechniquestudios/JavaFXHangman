package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MinimizedController 
{
	@FXML private HBox topBox;
	private Scene optionsScene;
    private Scene mainScene;
    private Stage primaryStage;
    
    HangmanController mainController;
    OptionsController optionsController;

    @FXML private void quitGame()
	{
		System.exit(0);
	}

    @FXML private void openGameScene(ActionEvent actionEvent)
    {
    	mainController.setArrowVisible();
    	mainController.playFadeIn();
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
        mainScene.getRoot().requestFocus();
    }

    @FXML private void openOptionsScene(ActionEvent actionEvent) //throws IOException
    {
    	optionsController.setArrowVisible();
    	optionsController.playFadeIn();
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(optionsScene);
        optionsScene.getRoot().requestFocus();    
    }

    @FXML private void minimizeScene(ActionEvent actionEvent)
    {
        primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }
    
    public void setRootPaneController(HangmanController someHangmanController)
    {
    	mainController = someHangmanController;
    }
    
    public void setOptionsPaneController(OptionsController someOptionsController)
    {
    	optionsController = someOptionsController;
    }
    
    public void setOptionsScene(Scene someScene)
    {
    	optionsScene = someScene;
    }

    public void setMainScene(Scene scene)
    {
        mainScene = scene;
    }
}