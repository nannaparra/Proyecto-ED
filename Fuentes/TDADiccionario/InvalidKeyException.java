package TDADiccionario;

@SuppressWarnings("serial")
/**
 * 
 * @author Antonela Diomedi y Nadina Guadalupe Parra
 *
 */
public class InvalidKeyException extends Exception{
	
	/**
	 * Constructor de la excepcion.
	 * @param s, mensanje de la excepcion.
	 */
	public InvalidKeyException(String s) {
		super(s);
		}
}
