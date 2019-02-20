package application;

import fileIO.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class OptionsController implements Initializable
{
	@FXML private HBox topBox;
	@FXML private JFXListView<String> wordBank;
	@FXML private JFXToggleButton toggleDict;
	@FXML private JFXButton addWordButton;
	@FXML private JFXButton deleteWordButton;
	@FXML private JFXTextField addWordField;

	private Scene mainScene;
	private Scene minScene;
	private ObservableList<String> someListView;

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

	public void toggleWasChanged(ActionEvent e)
	{
		boolean isToggleEnabled = toggleDict.isSelected();
		String wordToSend;

		addWordButton.setDisable(!(isToggleEnabled));//these disable buttons if the toggle state is off
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

	public void addWordWasHit(ActionEvent e)
	{
		if(!(addWordField.getText().matches("[a-zA-Z ]*")))
		{
			
		}
		else if(addWordField.getText().length() > 15)
		{
		
		}
			//if it dosn't contain letters
		else if((!(addWordField.getText().matches("[a-zA-Z].*"))))
		{
		
		}
		else if(FileInstantiation.getRandomWordArrList().contains(addWordField.getText()))
		{
		
		}
		else
		{
			FileInstantiation.writeNewWord(addWordField.getText());
			addWordField.setText("");
			someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
			wordBank.setItems(someListView);
		}
		
	}

	public void deleteWordWasHit(ActionEvent e)
	{
		try
		{
			int someIndex = wordBank.getSelectionModel().getSelectedIndex();
			//String stringToDelete = (String) wordBank.getSelectedValue();
			FileInstantiation.deleteSomeWord(someIndex);
			someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
			wordBank.setItems(someListView);
			
		}
		catch(Exception d)
		{
			
		}
		//someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
		//wordBank.setItems(someListView);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		boolean isToggleOn = FileInstantiation.getToggleState();
		String whichWordList;
		toggleDict.setSelected(isToggleOn);//fetches memory state for toggle button
		addWordButton.setDisable(!(isToggleOn));//these disable buttons if the toggle state is off
		deleteWordButton.setDisable(!(isToggleOn));
		addWordField.setDisable(!(isToggleOn));
		wordBank.setDisable(!(isToggleOn));

		if(isToggleOn)
		{
			whichWordList = "WordBank.txt";
		}
		else// if (isToggleOn == false)
		{
			whichWordList = "DefaultDictionary.txt";
		}
		FileInstantiation.setWordList(whichWordList);//when the toggle switches, update setWordList

		someListView = FXCollections.observableArrayList(FileInstantiation.getRandomWordArrList());
		wordBank.setItems(someListView);//list populates


	}
}
