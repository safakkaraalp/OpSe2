package gui;

import java.io.IOException;

import business.CafeVerwaltungModel;
import javafx.stage.Stage;

public class CafeVerwaltungControl {
    private CafeVerwaltungView cafeVerwaltungView;
    private CafeVerwaltungModel cafeVerwaltungModel;
    
    public CafeVerwaltungControl(Stage primaryStage) {
        this.cafeVerwaltungModel = CafeVerwaltungModel.getInstance();
        this.cafeVerwaltungView = new CafeVerwaltungView(this, cafeVerwaltungModel, primaryStage);
    }
    
    public void leseCafeVerwaltungAusDatei(String typ) {
        try {
            if ("csv".equals(typ) || "txt".equals(typ)) {
                this.cafeVerwaltungModel.leseAusDatei(typ);
                cafeVerwaltungView.zeigeInformationsfensterAn(
                    "Die Kaffee-Produkte wurden erfolgreich geladen!"
                );
                // Manually update the view since observer pattern is removed
                cafeVerwaltungView.zeigeCafeVerwaltungAn();
            } else {
                cafeVerwaltungView.zeigeFehlermeldungsfensterAn("Fehler bei der Ausführung");
            }
        } catch (Exception exc) {
            exc.printStackTrace(); // Debug
            cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
                "Fehler beim Laden der Datei: " + exc.getMessage()
            );
        }
    }
    
    public void schreibeCafeVerwaltungInDatei() {
        try {
            this.cafeVerwaltungModel.schreibeCafeVerwaltungInCsvDatei();
            cafeVerwaltungView.zeigeInformationsfensterAn(
                "Die KaffeeVerwaltung wurde gespeichert!"
            );
        } catch (IOException exc) {
            cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
                "IOException beim Speichern!"
            );
        } catch (Exception exc) {
            cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
                "Unbekannter Fehler beim Speichern!"
            );
        }
    }
}
