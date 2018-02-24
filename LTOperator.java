/**
 * Clasa pentru operatorul lt.
 * Implementeaza interfata Operator.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class LTOperator implements Operator {

	/**
	 * Valoare ce trebuie verificata
	 */
	private float value;

	/**
	 * Constructor pentru operator.
	 * @param value - valoarea
	 */
	public LTOperator(String value) {
		
		this.value = Float.parseFloat(value);
		
	}
	@Override
	public boolean valid(String name, float value) {
		
		if (value < this.value)
			return true;
		
		return false;
	
	}
	
	
}
