
import java.util.Scanner;
/**
 * Clasa main a programului
 * 
 * @author Cristian Pavel - 324 CB
 * 
 *
 */
public class MainClass {

	public static void main(String[] args) {
	
		/**
		 * feed-ul principal in care am stock-urile si lista de observatori
		 */
		Feed feed = new Feed();
		/**
		 * factory pentru observer
		 */
		ObserverFactory ob = ObserverFactory.getInstance();
		
		/**
		 * citesc stream-ul de data de la input
		 */
		Scanner s = null;
		try {
			
			s = new Scanner(System.in);
			String input = s.nextLine();
			
			/**
			 * citesc linii pana ajung la "begin"
			 */
			while (!input.equals("begin")) {
				input = s.nextLine();
				
			}
			
			
			/**
			 * citesc acum linie cu line pana la end
			 */
			while (!input.equals("end")) {
				/**
				 * citesc o linie si o sparg in 3 cuvinte
				 * 		1. comanda
				 * 		2. id operator / nume stock
				 * 	    3. expresie
				 */
				input = s.nextLine();
				
				String[] words = input.split("[ ]+",3);
				String firstWord = words[0];
			
				/**
				 * in functie de primul cuvant fac o operatie
				 */
				if (firstWord.equals("create_obs")) {
					
					/**
					 * iau id-ul si expresia si adaug in feed un observotor creat cu factory-ul
					 */
					int id = Integer.parseInt(words[1]);
					
					String expression = words[2];
				
					feed.addObserver(id, ob.createObserver(id, expression));
				
					
				} else if (firstWord.equals("delete_obs")) {
					
					/**
					 * sterg din feed observatorul
					 */
					int id = Integer.parseInt(words[1]);
					feed.deleteObserver(id);
				} else if (firstWord.equals("feed")) {
					/**
					 * adaug / reactualizez un stock din feed
					 */
					feed.addStock(new Stock(words[1], Float.parseFloat(words[2])));
					
				} else if (firstWord.equals("print")) {
					/**
					 * printez un observator din feed
					 */
					feed.printObserver(Integer.parseInt(words[1]));
				}
				
				
				
			}
			
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		
		
		
		
	}
}
