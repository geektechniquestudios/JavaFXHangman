package application;

import fileIO.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import animations.FadeInDown;
import animations.FadeOutUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class OptionsController implements Initializable
{
	@FXML private HBox topBox;
	@FXML private JFXListView<String> wordBank;
	@FXML private JFXToggleButton toggleDict;
	@FXML private JFXButton addWordButton;
	@FXML private JFXButton deleteWordButton;
	@FXML private JFXTextField addWordField;
	@FXML private BorderPane mainBox;
	@FXML private ImageView arrow;

	private Scene mainScene;
	private Scene minScene;
	private ObservableList<String> someListView;
	private boolean hasAnimationStarted = false;
	private Stage primaryStage;
	
	HangmanController mainController;
	MinimizedController minController;

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

	public void openMinScene(ActionEvent actionEvent)
	{
		if(hasAnimationStarted == false)
		{
			playFadeOut(actionEvent, minScene);
		}
		hasAnimationStarted = true;
	}

	@FXML private void toggleWasChanged(ActionEvent e)
	{
		boolean isToggleEnabled = toggleDict.isSelected();
		String wordToSend;

		addWordButton.setDisable(!(isToggleEnabled));//these will disable buttons if the toggle state is off
		deleteWordButton.setDisable(!(isToggleEnabled));
		addWordField.setDisable(!(isToggleEnabled));
		wordBank.setDisable(!(isToggleEnabled));
		
		if(isToggleEnabled)
		{
			wordToSend = "WordBank.txt";
		}
		else
		{
			wordToSend = "DefaultDictionary.txt";
		}

		FileInstantiation.setWordList(wordToSend);//which wordlist to use
		FileInstantiation.setToggleState(isToggleEnabled);
	}

	@FXML private void addWordWasHit(ActionEvent e)
	{//content filtering
		if(!(addWordField.getText().matches("[a-zA-Z ]*")))
		{
			addWordField.setText("");
			addWordField.setPromptText("letters only");
		}
		
		else if(addWordField.getText().length() > 17)
		{
			addWordField.setText("");
			addWordField.setPromptText("too long");
		}

		else if((!(addWordField.getText().matches("[a-zA-Z].*"))))
		{
			addWordField.setText("");
			addWordField.setPromptText("start with a letter");
		}
		else if(FileInstantiation.getRandomWordArrList().contains(addWordField.getText()))
		{	
			addWordField.setText("");
			addWordField.setPromptText("already in list");
		}
		else
		{
			FileInstantiation.writeNewWord(addWordField.getText());
			addWordField.setText("");
			addWordField.setPromptText("next word?");
			someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
			wordBank.setItems(someListView);
		}	
	}

	@FXML private void deleteWordWasHit(ActionEvent e)
	{
		if(FileInstantiation.getRandomWordArrList().toArray().length == 1)
		{
			addWordField.setPromptText("can't delete last word");
		}
		else
		{
			try
			{
				int someIndex = wordBank.getSelectionModel().getSelectedIndex();
				FileInstantiation.deleteSomeWord(someIndex);
				
				someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
				wordBank.setItems(someListView);	
			}
			catch(Exception d)
			{
				d.printStackTrace();
			}
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		boolean isToggleOn = FileInstantiation.getToggleState();
		String whichWordList;
		
		Tooltip toggleTip = new Tooltip("Make your own dictionary, or use a default set of words.");
		toggleDict.setTooltip(toggleTip);
		
		toggleDict.setSelected(isToggleOn);//fetches memory state for toggle button
		addWordButton.setDisable(!(isToggleOn));//these disable buttons if the toggle state is off
		deleteWordButton.setDisable(!(isToggleOn));
		addWordField.setDisable(!(isToggleOn));
		wordBank.setDisable(!(isToggleOn));

		FileInstantiation.setWordList("WordBank.txt");//when the toggle switches, update setWordList

		someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
		wordBank.setItems(someListView);//list populates
		
		if(isToggleOn)
		{
			whichWordList = "WordBank.txt";
		}
		else// if (isToggleOn == false)
		{
			whichWordList = "DefaultDictionary.txt";
		}		
	}
	
	public void playFadeIn()
	{
		new FadeInDown(mainBox).play();
	}
	
	public void playFadeOut(ActionEvent actionEvent, Scene someScene)
	{
		arrow.setVisible(false);
		FadeOutUp someFadeOut = new FadeOutUp(mainBox);
		
		someFadeOut.setOnFinished(event -> 
		{
			//load minScene
		    someScene.getRoot().requestFocus();
			primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		    primaryStage.setScene(someScene);
		    hasAnimationStarted = false;
		});
		
		someFadeOut.play();
	}
	
	public void setRootPaneController(HangmanController someHangmanController)
    {
    	mainController = someHangmanController;
    }
	
	public void setMinPaneController(MinimizedController someMinimizedController)
	{
	    minController = someMinimizedController;
	}
	
	public void setMainScene(Scene scene)
    {
        mainScene = scene;
    }

    public void setMinScene(Scene someScene)
    {
    	minScene = someScene;
    }
    
    public void setArrowVisible()
    {
    	arrow.setVisible(true);
    }
}
