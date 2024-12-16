package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CafeVerwaltungTest {
	private CafeVerwaltung c1;

	@BeforeEach
	void setUp() throws Exception {
		String [] arr = new String[2];
		arr[0] = "Marco";
		arr[1] = "Düsseldorf";
		this.c1 = new CafeVerwaltung("Safak", "Bochum", "Latte", arr, "Ja");
		 	
	}

	@AfterEach
	void tearDown() throws Exception {
		this.c1 = null;
	}

	@Test
	void test() {
		assertTrue(() -> this.c1.getName().equals("Safak"));
	}
	
	void test2() {
		Throwable exc= assertThrows(IllegalArgumentException.class,() -> {
        	new CafeVerwaltung("Safak", "Bochum", "Latte", null, "Ja");});
		
        assertEquals("KaffeeProdukteList duerfen nicht null sein.", exc.getMessage());
    }

}
