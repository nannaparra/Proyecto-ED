package TDADiccionario;

/**
 * Retorna en caso de una entrada que no existe.
 * @author Antonela Diomedi y Nadina Guadalupe Parra
 *
 */
public class InvalidEntryException extends Exception {
	
	/**
	 * Constructor de la excepcion.
	 * @param s mensaje de la excepcion
	 */
	public InvalidEntryException(String s) {
		super(s);
		}
}
