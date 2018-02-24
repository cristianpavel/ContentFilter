/**
 * Interfata pentru un Operator.
 *
 * @author Cristian Pavel - 324 CB
 *
 */
public interface Operator {
	/**
	 * Verifica daca un stock trece de operator.
	 * @param name - nume stock
	 * @param value - valoare stock 
	 * @return - true sau false
	 */
	public boolean valid(String name, float value);
}