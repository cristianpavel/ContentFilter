/**
 * Vizitator pentru arbore.
 * Implementeaza interfata Visitor.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */

public class TreeVisitor implements Visitor {

	/**
	 * numele stock-ului cu care vizitez
	 */
	private String name;
	/**
	 * valoarea stock-ului cu care vizitez
	 */
	private float value;
	
	public TreeVisitor(String name, float value) {
		
		this.name = name;
		this.value = value;
	}
	
	/**
	 * vizitez un nod AND
	 */
	@Override
	public boolean visit(AndNode n) {
		
		return n.getLeft().accept(this) && n.getRight().accept(this);
	}

	/**
	 * vizitez un nod OR
	 */
	@Override
	public boolean visit(OrNode n) {
		return n.getLeft().accept(this) || n.getRight().accept(this);	
		
	}

	/**
	 * vizitez o frunza
	 */
	@Override
	public boolean visit(BooleanNode n) {
		
		return n.validateOperator(name, value);
	}

	
	
	
	
}
