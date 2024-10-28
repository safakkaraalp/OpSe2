package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CafeVerwaltungModel {
	public CafeVerwaltung cafeVerwaltung;
	
	
	
	public void schreibeCafeVerwaltungInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(cafeVerwaltung.gibCafeVerwaltungZuruck(';'));
			aus.close();
			

}	
	
	
	/*private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.cafeVerwaltung = new CafeVerwaltung(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
      				zeigeInformationsfensterAn(
      	  	   			"Die KaffeeProdukte wurden gelesen!");
      		}
       		else{
       			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}*/


	
	

}
