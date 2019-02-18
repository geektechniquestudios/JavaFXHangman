package application;

import gameLogic.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
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


public class Main extends Application {

	private double xOffset = 0;
	private double yOffset = 0;
	private String wordToDisplay;

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		try
		{
//			String currentWord = GameLogic.getRandomWord();
//			wordToDisplay = GameLogic.randWordToHidden(currentWord);

			primaryStage.setAlwaysOnTop(true);

			FXMLLoader root = new FXMLLoader(getClass().getResource("HangmanFile.fxml"));//
		    Parent gameScenePane = root.load();//
		    Scene gameScene = new Scene(gameScenePane);//

		    FXMLLoader minPaneLoader = new FXMLLoader(getClass().getResource("HangmanMinimized.fxml"));//
	        Parent minSceneLoader = minPaneLoader.load();//
	        Scene minScene = new Scene(minSceneLoader);//

	        FXMLLoader optionsPaneLoader = new FXMLLoader(getClass().getResource("HangmanOptions.fxml"));//
	        Parent optionsSceneLoader = optionsPaneLoader.load();//
	        Scene optionsScene = new Scene(optionsSceneLoader);//

			// injecting min and opt scene into the controller of the main scene
	        HangmanController rootPaneController = (HangmanController) root.getController();//
	        rootPaneController.setMinScene(minScene);//
	        rootPaneController.setOptionsScene(optionsScene);
	        rootPaneController.setMainParent(gameScenePane);

	        //adding the currentWord and setting word to display
	        //System.out.println(currentWord);
	        //rootPaneController.setCurrentWord(currentWord);
	        //rootPaneController.setWordToDisplay(wordToDisplay);//now done on init

	        // injecting main and opt scene into the controller of the min scene
	        MinimizedController minPaneController = (MinimizedController) minPaneLoader.getController();//
	        minPaneController.setMainScene(gameScene);//
	        minPaneController.setOptionsScene(optionsScene);

	        // injecting main and min scene into the controller of the options scene
	        OptionsController optionsPaneController = (OptionsController) optionsPaneLoader.getController();//
	        optionsPaneController.setMainScene(gameScene);//
	        optionsPaneController.setMinScene(minScene);

			primaryStage.initStyle(StageStyle.TRANSPARENT);//removes window dressing

			gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			optionsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			minScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			gameScene.setFill(javafx.scene.paint.Color.TRANSPARENT);//transp backgrd
			optionsScene.setFill(javafx.scene.paint.Color.TRANSPARENT);

			gameScenePane.requestFocus();//makes it so button isn't highlighted

			primaryStage.setScene(gameScene);
			primaryStage.show();

			//transparency and draggable actions
			gameScenePane.setOnMousePressed(new EventHandler<MouseEvent>()
			{
	            @Override
	            public void handle(MouseEvent event)
	            {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        gameScenePane.setOnMouseDragged(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent event)
	            {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	                primaryStage.setOpacity(0.7f);
	            }
	        });
	        gameScenePane.setOnDragDone(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });
	        gameScenePane.setOnMouseReleased(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });

	        minSceneLoader.setOnMousePressed(new EventHandler<MouseEvent>()
			{
	            @Override
	            public void handle(MouseEvent event)
	            {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });

	        minSceneLoader.setOnMouseDragged(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent event)
	            {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	                primaryStage.setOpacity(0.7f);
	            }
	        });
	        minSceneLoader.setOnDragDone(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });
	        minSceneLoader.setOnMouseReleased(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });

	        optionsSceneLoader.setOnMousePressed(new EventHandler<MouseEvent>()
			{
	            @Override
	            public void handle(MouseEvent event)
	            {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        optionsSceneLoader.setOnMouseDragged(new EventHandler<MouseEvent>()
	        {
	            @Override
	            public void handle(MouseEvent event)
	            {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	                primaryStage.setOpacity(0.7f);
	            }
	        });
	        optionsSceneLoader.setOnDragDone(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });
	        optionsSceneLoader.setOnMouseReleased(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}

//	public String getWordToDisplay()
//	{
//		return wordToDisplay;
//	}





}
