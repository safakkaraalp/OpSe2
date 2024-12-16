package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fabrikmethode.ConcreteCSVCreator;
import fabrikmethode.ConcreteTxtCreator;
import fabrikmethode.Creator;
import fabrikmethode.Product;
import gui.CafeVerwaltungView;
import ownUtil.Observable;
import ownUtil.Observer;

public class CafeVerwaltungModel implements Observable {
	public CafeVerwaltung cafeVerwaltung;
	public CafeVerwaltungView cafeVerwaltungView;
	
	public ArrayList<CafeVerwaltung> cafeverwaltungList = new ArrayList<>();
	
	private static CafeVerwaltungModel cafeModel;
	private Vector<Observer> observers = new Vector<Observer>();
	
	private CafeVerwaltungModel() {
		
	}
	
	public static CafeVerwaltungModel getInstance(){
		if(cafeModel == null) {
			cafeModel = new CafeVerwaltungModel();
			return cafeModel;
		}
		return cafeModel;
	}
	
	
	public void addCafeVerwaltung(CafeVerwaltung cafeverwaltung) {
		cafeverwaltungList.add(cafeverwaltung);
		notifyObservers();
	}

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
		notifyObservers();

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
		
		notifyObservers();
	}

	public CafeVerwaltung getCafeVerwaltung() {
		return this.cafeVerwaltung;
		
	}

	public void setCafeVerwaltung(CafeVerwaltung cafeVerwaltung) {
		this.cafeVerwaltung = cafeVerwaltung;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		
		this.observers.addElement(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
		
	}

	@Override
	public void notifyObservers() {
		 
		for(int i = 0; i<this.observers.size(); i++)
		{
			this.observers.elementAt(i).update();
		}
		
	}

	public ArrayList<CafeVerwaltung> getCafeverwaltung() {
		return cafeverwaltungList;
	}

}