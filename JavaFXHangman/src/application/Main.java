package application;

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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private double xOffset = 0; 
	private double yOffset = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("HangmanFile.fxml"));
			Scene gameScene = new Scene(root);
			primaryStage.sizeToScene();
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameScene.setFill(javafx.scene.paint.Color.TRANSPARENT);
			
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	                primaryStage.setOpacity(0.7f);
	            }
	        });
	        root.setOnDragDone(e -> 
	        {
	        	primaryStage.setOpacity(1.0f);
	        });
	        root.setOnMouseReleased(e ->
	        {
	        	primaryStage.setOpacity(1.0f);
	        });
	        
			primaryStage.setScene(gameScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
