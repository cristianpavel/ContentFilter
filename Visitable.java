/**
 * Interfata pentru Visitable.
 * E implementata de nodurile ce trebuie vizitate.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public interface Visitable {
	/**
	 * Indica daca accepta un nod un anumit vizitator.
	 * 
	 * @param v - vizitator
	 * @return true sau false
	 */
	public boolean accept(Visitor v);

}
