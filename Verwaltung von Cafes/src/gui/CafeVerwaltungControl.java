package gui;

import java.io.IOException;

import business.CafeVerwaltungModel;
import javafx.stage.Stage;

public class CafeVerwaltungControl {
	private CafeVerwaltungView cafeVerwaltungView;
	private CafeVerwaltungModel cafeVerwaltungModel;
	
	public CafeVerwaltungControl(Stage primaryStage) {
		this.cafeVerwaltungModel = new CafeVerwaltungModel();
		this.cafeVerwaltungView = new CafeVerwaltungView(this,cafeVerwaltungModel,primaryStage);
		
	
	}
	
	
	 public void leseCafeVerwaltungAusDatei(String typ) {
	        try {
	        	if("csv".equals(typ)) {
		        	this.cafeVerwaltungModel.leseAusDatei(typ);
		            cafeVerwaltungView.zeigeInformationsfensterAn("Die Kaffee-Produkte wurden erfolgreich geladen!");
	        	} else if("txt".equals(typ)){
	        		this.cafeVerwaltungModel.leseAusDatei(typ);
	        		cafeVerwaltungView.zeigeInformationsfensterAn("Die Kaffee-Produkte wurden von TXT geladen!");
	        	} else {
	        		cafeVerwaltungView.zeigeFehlermeldungsfensterAn("Fehler bei der ausfuehrung");
	        	}
	        } catch (Exception exc) {
	        	exc.printStackTrace(); // Debug
	        	cafeVerwaltungView.zeigeFehlermeldungsfensterAn("Fehler beim Laden der Datei: " + exc.getMessage());
	        }
	    }
	
	public void schreibeCafeVerwaltungInDatei() {
		try {
			this.cafeVerwaltungModel.schreibeCafeVerwaltungInCsvDatei();
			cafeVerwaltungView.zeigeInformationsfensterAn("Die KaffeeVerwaltung wurden gespeichert!");
		}	
		catch(IOException exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

}