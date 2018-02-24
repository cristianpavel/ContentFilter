/**
 * SingletonFactory pentru Observer. Creeaza
 * observeri de tipul User, pornind de la un id
 * si o expresie.
 * 
 * @author Cristian Pavel - 324 CB
 *
 */
public class ObserverFactory {

		private static final ObserverFactory INSTANCE = new ObserverFactory();
		
		
		private ObserverFactory() {
			
			
		}
	
		public static ObserverFactory getInstance() {
			
			return INSTANCE;
		}
		
		/**
		 * 
		 * @param id - id-ul observer-ului
		 * @param expression - expresia ce trebuie transformata in arbore
		 * @return un Observer de tipul User
		 */
		public Observer createObserver(int id, String expression) {
			

			if (expression.equals("nil"))
				return new User(id, null);
			/**
			 * scapam de toate spatiile dintre paranteze
			 * si operatori
			 */
			expression = expression.replaceAll("\\( ","\\(");
			expression = expression.replaceAll("\\) ","\\)");
			expression = expression.replaceAll(" \\(","\\(");
			expression = expression.replaceAll(" \\)","\\)");
			return new User(id,generateTree(expression));

						
		}
			
		/**
		 * Genereaza un arbore (filtru) pornind de la o expresie).
		 * Apelez functia recursiv, spargand-o de fiecare data in 2.
		 * Ex. Avand (EXPR1) && (EXPR2) o sa ma duc mai intai pe stanga,
		 * rezolv EXPR1, dupa ma duc in dreapta, rezolv EXPR2, si la 
		 * sfarsit fac AND node, care are copii nodurile radacina dat de
		 * EXPR1 si EXPR2.
		 * 
		 * Cand ajung la caz de baza fara AND sau OR, creez operator
		 * cu OperatorsFactory si fac frunza.
		 * 
		 * 
		 * @param expression - din input
		 * @return arborele ce trebuie vizitat
		 */
		private Node generateTree(String expression) {
			
			Node root = null;
			
			//caz de baza
			if (expression.indexOf("&&") == -1 && expression.indexOf("||") == -1) {
			
				expression = expression.replaceAll("[()]", "").trim();
				root = new BooleanNode(OperatorsFactory.getInstance().createOperator(expression));
				return root;
			}
	
			
			
			/**
			 * Gasesc EXPR1 si EXPR2. Caut punctul in care se inchide
			 * prima paranteza deschisa.
			 * 
			 */
			int nrUnclosed = 0;
			int i = 0;
			
			for (; i < expression.length(); i++) {
				if (expression.charAt(i) == '(')
					nrUnclosed++;
				
				if (expression.charAt(i) == ')')
					nrUnclosed--;
				
				if (nrUnclosed == 0)
					break;
				
			}
			
			
			/**
			 * daca daca am o singura paranteza (doar EXPR1, doar EXPR2)
			 * elimin paranteza de la inceput si de la sfarsit pentru ca e inutila
			 * 
			 */
			if (i == expression.length() - 1) {
				
				return generateTree(expression.substring(1,expression.length() - 1));
			
			}
			//iau jumatatea dreapta a expresiei
			String halfExpression = expression.substring(i + 1).trim();
			
			Node left = generateTree(expression.substring(1,i)); //recursiv EXPR1
			Node right = generateTree(halfExpression.substring(2)); //recursiv EXPR1
			
			if (halfExpression.charAt(0) == '&') //fac nodul radacina
				root = new AndNode(left,right);
			else
				root = new OrNode(left,right);
			
			
			return root;
		}
			
		
}
		

