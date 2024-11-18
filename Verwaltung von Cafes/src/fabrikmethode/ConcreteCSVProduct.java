package fabrikmethode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCSVProduct extends Product{
	
	public BufferedReader reader;
	
	
	
	public ConcreteCSVProduct() {
		this.reader = reader;
		try {
			reader = new BufferedReader(new FileReader("CafeVerwaltung.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String[] leseAusDatei() throws IOException {
	
		
		String line = reader.readLine();
		

		if (line == null || line.isEmpty()) {
			System.out.println("Die CSV-Datei ist leer oder konnte nicht gelesen werden.");
			
		}

		String[] zeile = line.split(";");

		
		
		return zeile;
		
		
	}
	
	
	
	
	public void schliessDatei() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
