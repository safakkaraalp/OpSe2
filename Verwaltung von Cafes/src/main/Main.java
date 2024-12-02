package main;

import gui.CafeVerwaltungControl;
import gui.GastronomienControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new CafeVerwaltungControl(primaryStage);
		Stage gastroStage = new Stage();
        new GastronomienControl(gastroStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
