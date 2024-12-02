package gui;

import business.CafeVerwaltungModel;
import javafx.stage.Stage;

public class GastronomienControl {
    private GastronomienView gastronomienView;
    private CafeVerwaltungModel cafeVerwaltungModel;

    public GastronomienControl(Stage primaryStage) {
        this.cafeVerwaltungModel = CafeVerwaltungModel.getInstance();
        this.gastronomienView = new GastronomienView(this, primaryStage, cafeVerwaltungModel);
    }
}
