/**
 * Interfata pentru vizitator.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public interface Visitor {
	
	/**
	 * Visit pentru nod AND
	 * @param n - nod
	 * @return true sau false
	 */
	public boolean visit(AndNode n);
	
	/**
	 * Visit pentru nod OR
	 * @param n - nod
	 * @return true sau false
	 */
	public boolean visit(OrNode n);
	
	/**
	 * Visit pentru frunza
	 * @param n - nod
	 * @return true sau false
	 */
	public boolean visit(BooleanNode n);
	

}
