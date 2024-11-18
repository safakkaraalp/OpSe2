package fabrikmethode;

import java.io.BufferedReader;
import java.io.IOException;

public class ConcreteTxtProduct extends Product{
	public BufferedReader reader;

	public String[] leseAusDatei() throws IOException {
		String [] ergebnisZeile = new String[5];
		String zeile = reader.readLine();
		int i = 0;
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i]= zeile;
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliessDatei() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
