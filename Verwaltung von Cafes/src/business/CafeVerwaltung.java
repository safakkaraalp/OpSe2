package business;

import java.util.ArrayList;

public class CafeVerwaltung {

	// Name des Cafes
	private String name;
	// Name des Ortes
	private String ort;

	// Beschreibung
	private String beschreibung;

	// Verschiedene KaffeeProdukte
	//private String[] kaffeeProdukte;
	private ArrayList<String> kaffeeProdukteList = new ArrayList<>();
	
	private String angeschlossenerBaeckerei;

	public CafeVerwaltung(String name, String ort, String beschreibung, String[] kaffeeProdukte,
			String angeschlossenerBaeckerei) {
		if(kaffeeProdukteList == null) {
            throw new IllegalArgumentException("KaffeeProdukteList duerfen nicht null sein.");
        }
		this.name = name;
		this.ort = ort;
		this.beschreibung = beschreibung;
		this.setKaffeeprodukteAusStringArray(kaffeeProdukte);
		this.setAngeschlossenerBaeckerei(angeschlossenerBaeckerei);
	}
	
	public void setKaffeeprodukteAusStringArray(String[] dienstleistung) {
		this.kaffeeProdukteList = new ArrayList<String>();
		for(int i = 0;i<dienstleistung.length;i++) {
			this.kaffeeProdukteList.add(dienstleistung[i]);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	

	public String getKaffeeProdukteAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for (i = 0; i < this.getKaffeeProdukteList().size() - 1; i++) {
			ergebnis = ergebnis + this.getKaffeeProdukteList().get(i) + trenner;
		}
		return ergebnis + this.getKaffeeProdukteList().get(i);
	}

	public String gibCafeVerwaltungZuruck(char trenner) {
		return this.getName() 
		+ trenner + this.getOrt() 
		+ trenner + this.getBeschreibung() + trenner
				+  this.getAngeschlossenerBaeckerei() + 
				+ trenner + "\n" + this.getKaffeeProdukteAlsString(trenner) + "\n";

	}

	public String getAngeschlossenerBaeckerei() {
		return angeschlossenerBaeckerei;
	}

	public void setAngeschlossenerBaeckerei(String angeschlossenerBaeckerei) {
		this.angeschlossenerBaeckerei = angeschlossenerBaeckerei;
	}

	public ArrayList<String> getKaffeeProdukteList() {
		return kaffeeProdukteList;
	}

	public void setKaffeeProdukteList(ArrayList<String> kaffeeProdukteList) {
		this.kaffeeProdukteList = kaffeeProdukteList;
	}

	
}
