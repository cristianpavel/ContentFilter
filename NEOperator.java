/**
 * Clasa pentru operatorul ne.
 * Implementeaza interfata Operator.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class NEOperator implements Operator {
	
	/**
	 * Nume ce trebuie verificat in caz ca avem "ne name ..."
	 */
	private String name;
	/**
	 * Valoare ce trebuie verificata in caz ca avem "ne value ..."
	 */
	private float value;
	
	/**
	 * Constructor pentru clasa. 
	 * @param type - name or value
	 * @param nameOrValue - in fucntie de tip e valoare sau numele ce trebuie verificat
	 */
	public NEOperator(String type, String nameOrValue) {
		
		
		if (type.equals("name")) {
			this.name = nameOrValue;
			value = -1;
		} else {
			
			this.value = Float.parseFloat(nameOrValue);
		}
		
		
	}

	@Override
	public boolean valid(String name, float value) {
		// TODO Auto-generated method stub
		if (this.name == null && value != this.value)
			return true;
		if (this.value == -1 && !(name.equals(this.name)))
			return true;
			
		return false;
	}
	
	
}
