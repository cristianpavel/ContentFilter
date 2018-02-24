/**
 * Clasa pentru un Stock.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */

public class Stock implements Cloneable {
	/**
	 * numele stock-ului
	 */
	private String name;
	
	/**
	 * valoare stock-ului
	 */
	private float value;
	
	/**
	 * numarul de schimbari de la crearea lui
	 */
	private int nrChanges;
	
	/**
	 * Constructor pentru stock.
	 * 
	 * @param name - numele
	 * @param value - valoarea
	 */
	public Stock(String name, float value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.name = name;
		nrChanges = 1;
	
	}
	

	public float getValue() {
		return value;
	}
	
	/**
	 * Schimba valoarea.
	 * @param value - noua valoare
	 */
	public void setValue(float value) {
		
		
		this.value = value;
		nrChanges++;
	
	}
	

	public String getName() {
		return name;
	}
	
	public int getNrChanges() {
		
		return nrChanges;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
	
		} catch (CloneNotSupportedException e) {
			System.out.println("Nu pot clona");

		}

		return null;
	}
	
}
