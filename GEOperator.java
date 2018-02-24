/**
 * Clasa pentru operatorul ge.
 * Implementeaza interfata Operator.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */

public class GEOperator implements Operator {
	
	/**
	 * Valoare ce trebuie verificata
	 */
	float value;

	/**
	 * Constructor pentru operator.
	 * @param value - valoarea
	 */
	public GEOperator(String value) {
		// TODO Auto-generated constructor stub
		this.value = Float.parseFloat(value);
	}
	
	@Override
	public boolean valid(String name, float value) {
		// TODO Auto-generated method stub
		if (this.value <= value)
			return true;
		
		return false;
	}
	
	

}
