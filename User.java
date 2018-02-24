import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.TreeMap;
/**
 * Clasa pentru un observer al feed-ului.
 * Implementeaza interfata Observer.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class User implements Observer {

	/**
	 * Ultimele stock-uri printate sau stock-urile de
	 * la crearea user-ului(in caz ca nu a fost printat niciodata).
	 * 
	 */
	private TreeMap<String, Stock> lastPrinted;
	/**
	 * id-ul observatorului
	 */
	private int id;
	/**
	 * Arborele expresiei
	 */
	private Node filter;
	/**
	 * Retin stock-urile printate pana acum.
	 * Am nevoie ca sa deosebesc stock-urile creata inainte de
	 * crearea observatorului de restul.
	 * 
	 */
	private HashSet<String> hasBeenPrinted;
	
	public User(int id, Node filter) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.filter = filter;
		lastPrinted = new TreeMap<String, Stock>();
		hasBeenPrinted = new HashSet<String>();
	}
	
	@Override
	public void putFromFeed(Stock[] feed) {
		
		if (lastPrinted.isEmpty()) {
			for (int i = 0; i < feed.length; i++) {
				String name =  feed[i].getName();
				lastPrinted.put(name, (Stock) feed[i].clone());
				
			}
		}
	}
		
		
	
	@Override
	public void print(Stock[] feed) {
		
		/**
		 * pentru printarea cu 2 zecimale
		 */
		DecimalFormat df = new DecimalFormat("0.00");
		/**
		 * verific cazul in care nu sunt stock-uri inca in feed
		 */
		if (feed == null)
			return;
	
		/**
		 * parcurg stock-urile, le verific cu filtrul, si dupa printez
		 */
		for (int i = 0; i < feed.length; i++) {
			String name = feed[i].getName();
			float value = feed[i].getValue();
				
			if (filter == null || filter.accept(new TreeVisitor(name, value))) {
				float increase = 0;
				int nrChanges = feed[i].getNrChanges();
				/**
				 * Calculez nr de schimbari de la ultima printare.
				 * Daca a mai fost printat o sa fac scadere intre valoarea actuala
				 * si valoarea de la ultima printare. Daca nu a mai fost printat
				 * o sa fac diferenta intre aceeasi valoare.
				 * 
				 */
				if (lastPrinted.containsKey(name)) {
					nrChanges -= lastPrinted.get(name).getNrChanges();;
					/**
					 * Daca a mai fost printat calculez increase-ul.
					 */
					if (hasBeenPrinted.contains(name)) {
						increase = (value / lastPrinted.get(name).getValue() - 1) * 100;
					}
				}
				System.out.println("obs " + id + ": " + name + " " + df.format(value) + " "
												+ df.format(increase) + "% " + nrChanges);
				lastPrinted.put(name, (Stock)feed[i].clone());
				hasBeenPrinted.add(name);
			}
				
		}
			
			
	
	}
}


