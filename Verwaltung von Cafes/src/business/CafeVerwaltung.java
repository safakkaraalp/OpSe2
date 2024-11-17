package business;


public class CafeVerwaltung {
	
	// Name des Cafes
    private String name;
    // Name des Ortes
    private String ort;
    
    //Beschreibung
    private String beschreibung;
    
   
    // Verschiedene KaffeeProdukte
    private String[] kaffeeProdukte;
    
    //boolean Variable f�r B�ckerei, ob angeschlossen ist
    private boolean angeschlossenerBaeckerei;

    public CafeVerwaltung(String name, String ort, String beschreibung, String[] kaffeeProdukte, boolean angeschlossenerBaeckerei){
   		this.name = name;
  	    this.ort = ort;
   	    this.beschreibung = beschreibung;
   	    this.setKaffeeProdukte(kaffeeProdukte);
   	    this.setAngeschlossenerBaeckerei(angeschlossenerBaeckerei);
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

	public String[] getKaffeeProdukte() {
		return kaffeeProdukte;
	}

	public void setKaffeeProdukte(String[] kaffeeProdukte) {
		this.kaffeeProdukte = kaffeeProdukte;
	}

	
	
	public boolean isAngeschlossenerBaeckerei() {
		return angeschlossenerBaeckerei;
	}

	public void setAngeschlossenerBaeckerei(boolean angeschlossenerBaeckerei) {
		this.angeschlossenerBaeckerei = angeschlossenerBaeckerei;
	}

	public String getKaffeeProdukteAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getKaffeeProdukte().length - 1; i++) {
			ergebnis = ergebnis + this.getKaffeeProdukte()[i] + trenner; 
		}
		return ergebnis	+ this.getKaffeeProdukte()[i];
	}
	
	public String gibCafeVerwaltungZuruck(char trenner){
			String angeschlossen = "";
			if(this.isAngeschlossenerBaeckerei() == true){
				angeschlossen = "ja";
			} else{
				angeschlossen = "nein";
			}
		
  		    return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getBeschreibung() + trenner
  		    + angeschlossen + trenner
  		    + this.getKaffeeProdukteAlsString(trenner)  ;
  		    
  	}
}
