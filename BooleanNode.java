/**
 * Clasa pentru frunze din arborele expresiei
 * Extinde clasa Node si implementeaza Visitable
 * pentru a putea fi vizitat in vederea calcularii
 * expresiei.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */

public class BooleanNode extends Node implements Visitable {

	/**
	 * Frunzele sunt operatori
	 */
	private Operator op;
	

	public BooleanNode(Operator op) {
		super(null,null);
		this.op = op;
	}
	
	/**
	 * 
	 * Metoda prin care vad daca un stock trece de operator-ul op.
	 * Folosesc doar name si value pentru ca ele ma intereseaza.
	 * 
	 * @param name - nume stock
	 * @param value - valoare stock
	 * @return
	 */
	public boolean validateOperator(String name, float value) {
		return op.valid(name, value);
	}
	
	@Override
	public boolean accept(Visitor v) {
		
		return v.visit(this);
	}

}
