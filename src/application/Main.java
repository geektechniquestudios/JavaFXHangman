package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

																					
public class Main extends Application {

	private static double xOffset = 0;
	private static double yOffset = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try
		{
			primaryStage.setAlwaysOnTop(true);
			primaryStage.getIcons().add(new Image("/imageAssets/hangmanIcon.jpg"));

			//making references to each scene to maintain the specific state when switching between them
			//then adding those references to all controllers
			FXMLLoader root = new FXMLLoader(getClass().getResource("HangmanFile.fxml"));
		    Parent gameScenePane = root.load();
		    Scene gameScene = new Scene(gameScenePane);
		    
		    
		    
		    FXMLLoader minPaneLoader = new FXMLLoader(getClass().getResource("HangmanMinimized.fxml"));
	        Parent minSceneLoader = minPaneLoader.load();
	        Scene minScene = new Scene(minSceneLoader);
	        
	        FXMLLoader optionsPaneLoader = new FXMLLoader(getClass().getResource("HangmanOptions.fxml"));
	        Parent optionsSceneLoader = optionsPaneLoader.load();
	        Scene optionsScene = new Scene(optionsSceneLoader);

			// references for min and opt scene into the controller of the main scene
	        HangmanController rootPaneController = (HangmanController) root.getController();
	        rootPaneController.setMinScene(minScene);
	        rootPaneController.setOptionsScene(optionsScene);
	        rootPaneController.setMainParent(gameScenePane);

	        // references for main and opt scene into the controller of the min scene
	        MinimizedController minPaneController = (MinimizedController) minPaneLoader.getController();//
	        minPaneController.setMainScene(gameScene);
	        minPaneController.setOptionsScene(optionsScene);
        
	        // references for main and min scene into the controller of the options scene
	        OptionsController optionsPaneController = (OptionsController) optionsPaneLoader.getController();//
	        optionsPaneController.setMainScene(gameScene);
	        optionsPaneController.setMinScene(minScene);
	        
	        // references for controllers
	        optionsPaneController.setRootPaneController(rootPaneController);
	        optionsPaneController.setMinPaneController(minPaneController);
	        minPaneController.setRootPaneController(rootPaneController);
	        minPaneController.setOptionsPaneController(optionsPaneController);
	        rootPaneController.setMinPaneController(minPaneController);
	        rootPaneController.setOptionsPaneController(optionsPaneController);
	        
	        
	             
	        //the below line causes graphical errors during scene switching --- searching for a fix
			primaryStage.initStyle(StageStyle.TRANSPARENT);//removes window decoration and makes stage transp
			//primaryStage.initStyle(StageStyle.UNDECORATED);	
			
			
			
			//adding the stylesheet to all scenes
			gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			optionsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			minScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			gameScene.setFill(javafx.scene.paint.Color.TRANSPARENT);//transp backgrd
			optionsScene.setFill(javafx.scene.paint.Color.TRANSPARENT);
			minScene.setFill(javafx.scene.paint.Color.TRANSPARENT);

			gameScenePane.requestFocus();//makes it so no buttons are highlighted

			primaryStage.setScene(gameScene);
			primaryStage.show();

			//transparency and draggable actions
			makeParentDraggable(gameScenePane, primaryStage);
			makeParentDraggable(minSceneLoader, primaryStage);
			makeParentDraggable(optionsSceneLoader, primaryStage);        
	        
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

	public static void makeParentDraggable(Parent loaderToDrag, Stage primaryStage)//and transparent
	{
		loaderToDrag.setOnMousePressed(new EventHandler<MouseEvent>()
		{
            @Override
            public void handle(MouseEvent event)
            {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        loaderToDrag.setOnMouseDragged(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
                primaryStage.setOpacity(0.7f);
            }
        });
        loaderToDrag.setOnDragDone(e ->
        {
        	primaryStage.setOpacity(1.0f);
        });
        loaderToDrag.setOnMouseReleased(e ->
        {
        	primaryStage.setOpacity(1.0f);
        });
	}
}
