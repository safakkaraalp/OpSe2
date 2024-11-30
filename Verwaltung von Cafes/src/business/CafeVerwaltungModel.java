package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrikmethode.ConcreteCSVCreator;
import fabrikmethode.ConcreteTxtCreator;
import fabrikmethode.Creator;
import fabrikmethode.Product;
import gui.CafeVerwaltungView;

public class CafeVerwaltungModel {
	public CafeVerwaltung cafeVerwaltung;
	public CafeVerwaltungView cafeVerwaltungView;

	public void schreibeCafeVerwaltungInCsvDatei() throws Exception {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("CafeVerwaltungAusgabe.csv", true));
			aus.write(getCafeVerwaltung().gibCafeVerwaltungZuruck(';'));
			aus.close();
		} catch (IOException exc) {
			throw new IOException("Fehler beim Speichern der Datei!");
		} catch (Exception exc) {
			throw new Exception(exc);
		}

	}

	public void leseAusDatei(String typ) throws IOException {
		Creator writeCreator = new ConcreteTxtCreator();
		if (typ.equals("txt")) {
			writeCreator = new ConcreteTxtCreator();
		} else {
			writeCreator = new ConcreteCSVCreator();
		}
		Product writer = writeCreator.factoryMethod();
		String[] zeile = writer.leseAusDatei();
		writer.schliessDatei();

		this.cafeVerwaltung = new CafeVerwaltung(zeile[0], zeile[1], zeile[2], zeile[3].split("_"), zeile[4]);

	}

	public CafeVerwaltung getCafeVerwaltung() {
		return this.cafeVerwaltung;
	}

	public void setCafeVerwaltung(CafeVerwaltung cafeVerwaltung) {
		this.cafeVerwaltung = cafeVerwaltung;
	}

}
