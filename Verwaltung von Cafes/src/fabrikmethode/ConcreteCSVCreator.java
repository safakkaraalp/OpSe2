package fabrikmethode;

public class ConcreteCSVCreator extends Creator {

	
	public Product factoryMethod() {
		
		return new ConcreteCSVProduct();
	}

}
