import java.util.HashMap;
import java.util.TreeMap;
/**
 * Clasa pentru un feed. Am o lista de observatori
 * pe care trebuie sa-i printez la comanda "print".
 * 
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class Feed {
	/**
	 * stock-urile din feed
	 */
	private TreeMap<String, Stock> stocks;
	/**
	 * observatorii din feed
	 */
	private HashMap<Integer, Observer> inFeed;
	
	/**
	 * Constructor pentru feed
	 */
	public Feed() {
		
		inFeed = new HashMap<Integer, Observer>();
		stocks = new TreeMap<String, Stock>();
	}
	
	/**
	 * Printez obserber-ul cu id-ul observer
	 * @param id - id-ul celui ce trebuie printat
	 */
	public void printObserver(int id) {
		
		inFeed.get(id).print(stocks.values().toArray(new Stock[stocks.size()]));
		
	}
	/**
	 * Adaug un observer la HashMap. La adaugare
	 * copiez stock-urile din Feed in Observer.
	 * 
	 * @param id - id-ul observerului
	 * @param o - observer-ul
	 */
	public void addObserver(int id, Observer o) {
		
		inFeed.put(id, o);
		o.putFromFeed(stocks.values().toArray(new Stock[stocks.size()]));
	}
	
	/**
	 * Sterg un observer din HashMap.
	 * 
	 * @param id - id-ul observer-ului
	 */
	public void deleteObserver(int id) {
		
		inFeed.remove(id);
		
	}
	
	/**
	 * Adaug un stock in feed. Daca acesta exista deja
	 * ii actualizez valoarea.
	 * @param stock - stock-ul ce trebuie adaugat
	 */
	public void addStock(Stock stock) {
		
		if (stocks.containsKey(stock.getName())) {
			stocks.get(stock.getName()).setValue(stock.getValue());
			
		} else {
			stocks.put(stock.getName(), stock);
		}
	}

}
