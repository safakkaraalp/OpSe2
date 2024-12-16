package gui;

import business.CafeVerwaltung;
import business.CafeVerwaltungModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class GastronomienView implements Observer {

	private GastronomienControl gastronomienControl;
	private CafeVerwaltungModel cafeVerwaltungModel;

	private Pane pane = new Pane();
	private Label lblAnzeigeCafes = new Label("Anzeige Cafes");
	private TextArea txtAnzeigeCafes = new TextArea();
	private Button btnAnzeigeCafes = new Button("Anzeige");

	public GastronomienView(GastronomienControl gastronomienControl, Stage primaryStage,
			CafeVerwaltungModel cafeVerwaltungModel) {

		this.gastronomienControl = gastronomienControl;
		this.cafeVerwaltungModel = cafeVerwaltungModel;

		this.cafeVerwaltungModel.addObserver(this);

		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Gastronomien");
		primaryStage.show();

		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeCafes.setLayoutX(310);
		lblAnzeigeCafes.setLayoutY(40);
		lblAnzeigeCafes.setFont(font);
		lblAnzeigeCafes.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeCafes);

		// Text area
		txtAnzeigeCafes.setEditable(false);
		txtAnzeigeCafes.setLayoutX(310);
		txtAnzeigeCafes.setLayoutY(90);
		txtAnzeigeCafes.setPrefWidth(220);
		txtAnzeigeCafes.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeCafes);

		// Button
		btnAnzeigeCafes.setLayoutX(310);
		btnAnzeigeCafes.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeCafes);
	}

	private void initListener() {
		btnAnzeigeCafes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeCafesAn();
			}
		});
		
	}

	private void zeigeCafesAn() {
		/**CafeVerwaltung cafeVerwaltung = cafeVerwaltungModel.getCafeVerwaltung();
		if (cafeVerwaltung != null) {
			txtAnzeigeCafes.setText(cafeVerwaltung.gibCafeVerwaltungZuruck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Cafe aufgenommen!");
		}*/
		
			if(cafeVerwaltungModel.getCafeverwaltung().size() > 0) {
    		
    		cafeVerwaltungModel.getCafeverwaltung().forEach(CafeVerwaltung -> txtAnzeigeCafes.appendText(CafeVerwaltung.gibCafeVerwaltungZuruck(' ')+ "\n"));
    	}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	@Override
	public void update() {
		zeigeCafesAn();
	}
}
