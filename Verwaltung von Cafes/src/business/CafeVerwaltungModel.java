package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.CafeVerwaltungView;

public class CafeVerwaltungModel {
	public CafeVerwaltung cafeVerwaltung;
	public CafeVerwaltungView cafeVerwaltungView;

	public void schreibeCafeVerwaltungInCsvDatei() throws IOException {
	    try (BufferedWriter aus = new BufferedWriter(new FileWriter("CafeVerwaltungAusgabe.csv", true))) {
	        aus.write(this.getCafeVerwaltung().gibCafeVerwaltungZuruck(';'));
	        aus.newLine(); // Fügt eine neue Zeile nach dem aktuellen Datensatz hinzu
	        aus.close();
	    }
	}
	
	
	public CafeVerwaltung getCafeVerwaltung() {
	    return this.cafeVerwaltung;
	}


	public void setCafeVerwaltung(CafeVerwaltung cafeVerwaltung) {
		this.cafeVerwaltung = cafeVerwaltung;
	}
	
	
	public void leseAusDatei(String typ) throws IOException {
	    if ("csv".equals(typ)) {
	        // Öffnen der CSV-Datei
	        BufferedReader reader = new BufferedReader(new FileReader("CafeVerwaltung.csv"));
	        String line = reader.readLine();
	        reader.close();

	        // Prüfen, ob die Datei leer ist
	        if (line == null || line.isEmpty()) {
	            System.out.println("Die CSV-Datei ist leer oder konnte nicht gelesen werden.");
	            return;
	        }

	        // CSV-Zeile aufteilen
	        String[] zeile = line.split(";");
	        

	        // Konvertieren der CSV-Daten in ein Objekt
	        boolean angeschlossen = zeile[3].equalsIgnoreCase("ja");
	        String[] kaffeeProdukte = zeile[4].split("_");

	        // Erstellen eines neuen CafeVerwaltung-Objekts
	        this.cafeVerwaltung = new CafeVerwaltung(
	            zeile[0], // Name
	            zeile[1], // Ort
	            zeile[2], // Beschreibung
	            kaffeeProdukte, // KaffeeProdukte
	            angeschlossen // Angeschlossene Bäckerei
	        );

	       
	    } else {
	        throw new UnsupportedOperationException("Dateiformat nicht unterstützt: " + typ);
	    }
	}



	}
