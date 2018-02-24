/**
 * SingletonFactory care imi creeaza operatori
 * in functie de numele acestuia.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class OperatorsFactory {

	private static final OperatorsFactory INSTANCE = new OperatorsFactory();
	
	private OperatorsFactory() {
		
	}
	
	public static OperatorsFactory getInstance() {
		
		return INSTANCE;
	}
	
	/**
	 * Am un switch care imi dirijeaza crearea de operatori.
	 * @param expression - ex. le value 1.6
	 * @return - un operator
	 */
	public Operator createOperator(String expression) {
		
		String[] parts = expression.split("[ ]+");

		switch(parts[0]) {
		
		case "le":
			return new LEOperator(parts[2]);
		case "lt":
			return new LTOperator(parts[2]);
		case "gt":
			return new GTOperator(parts[2]);
		case "ge":
			return new GEOperator(parts[2]);
		case "eq":
			return new EQOperator(parts[1],parts[2]);
		case "ne":
			return new NEOperator(parts[1],parts[2]);
	
		
		
		}
		
		return null;
		
	}
	
	
}
