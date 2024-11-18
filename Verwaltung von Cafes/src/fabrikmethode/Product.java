package fabrikmethode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.CafeVerwaltung;

public abstract class Product {
	public abstract String [] leseAusDatei() throws IOException;
	
	public abstract void schliessDatei();
	
}
