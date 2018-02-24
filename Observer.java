/**
 * Interfata pentru un observator din feed.
 * @author Cristian Pavel - 324 CB
 * 
 */
public interface Observer {
	/**
	 * Metoda prin care copiez stock-urile din feed in observer
	 * @param stocks - vector de stock-uri
	 */
	public void putFromFeed(Stock[] stocks);
	/**
	 * Metoda de printare a unui observer
	 * @param stocks - vector de stock-uri
	 */
	public void print(Stock[] stocks);

}
