/**
 * Clasa pentru un nod pentru a fi
 * extinsa in functie de tipul de nod.
 * Implementeaza interfata Visitable
 * pentru a putea fi parcurs.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Node implements Visitable {

	/**
	 * nodul din stanga
	 */
	private Node left;
	
	/**
	 * nodul din dreapta
	 */
	private Node right;
	
	/**
	 * 
	 * @param left - copil stanga
	 * @param right - copil dreapta
	 */
	public Node(Node left, Node right) {
		
		this.left = left;
		this.right = right;
	}
	
	/**
	 * 
	 * @return copil stanga
	 */
	public Node getLeft() {
		return this.left;
	}
	
	/**
	 * 
	 * @return copil dreapta
	 */
	public Node getRight() {
		return this.right;
	}
	
	@Override
	public boolean accept(Visitor v) {
		return false;
	}

	

}
