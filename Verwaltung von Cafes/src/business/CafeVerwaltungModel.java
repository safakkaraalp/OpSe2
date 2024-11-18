package business;

import java.io.BufferedReader;
import fabrikmethode .*;
import fabrikmethode.ConcreteCSVCreator;
import fabrikmethode.ConcreteTxtCreator;
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
		Creator writeCreator = new ConcreteCSVCreator();
		Product writer = writeCreator.factoryMethod();
		writer.leseAusDatei();
		writer.schliessDatei();
		
	}
	
	
	public void schreibeCafeVerwaltungInTxtDatei() throws IOException {
		Creator writeCreator = new ConcreteTxtCreator();
		Product writer = writeCreator.factoryMethod();
		writer.leseAusDatei();
		writer.schliessDatei();
	}

	public CafeVerwaltung getCafeVerwaltung() {
		return this.cafeVerwaltung;
	}

	public void setCafeVerwaltung(CafeVerwaltung cafeVerwaltung) {
		this.cafeVerwaltung = cafeVerwaltung;
	}

	public void leseAusDatei(String typ) throws IOException {
		
		
			String[] kaffeeProdukte = 

			
			this.cafeVerwaltung = new CafeVerwaltung(zeile[0], 
					zeile[1], 
					zeile[2], 
					kaffeeProdukte, 
					angeschlossen 
			);

		
	}

}
