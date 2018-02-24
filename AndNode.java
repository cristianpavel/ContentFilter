/**
 * Clasa pentru nodul AND din arborele expresiei
 * Extinde clasa Node si implementeaza Visitable
 * pentru a putea fi vizitat in vederea calcularii
 * expresiei.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class AndNode extends Node implements Visitable {
	/**
	 * 
	 * @param left - nodul din stanga
	 * @param right - nodul din dreapta
	 */
	public AndNode(Node left, Node right) {
		super(left, right);
	}
	
	@Override
	public boolean accept(Visitor v) {
		
		return v.visit(this);
	}

}
