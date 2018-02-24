/**
 * Clasa pentru operatorul eq.
 * Implementeaza interfata Operator.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class EQOperator implements Operator {
	
	/**
	 * Nume ce trebuie verificat in caz ca avem "eq name ..."
	 */
	private String name;
	/**
	 * Valoare ce trebuie verificata in caz ca avem "eq value ..."
	 */
	private float value;
	
	/**
	 * Constructor pentru clasa. 
	 * @param type - name or value
	 * @param nameOrValue - in fucntie de tip e valoare sau numele ce trebuie verificat
	 */
	public EQOperator(String type, String nameOrValue) {
		
		
		if (type.equals("name")) {
			this.name = nameOrValue;
			value = -1;
		} else {
			
			this.value = Float.parseFloat(nameOrValue);
		}
		
		
	}

	@Override
	public boolean valid(String name, float value) {
		if (value == this.value || name.equals(this.name))
			return true;
			
		
		return false;
	}
	
	
}
