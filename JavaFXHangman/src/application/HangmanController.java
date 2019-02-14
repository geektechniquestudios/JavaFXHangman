package application;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class HangmanController
{

	@FXML
	private HBox topBox;

//	private void makeStageDraggable()
//	{
//
//	}
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
}
