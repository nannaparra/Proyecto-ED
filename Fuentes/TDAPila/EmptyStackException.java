package TDAPila;
/**
 * Clase EmptyStackException
 * Modela una acceso a una pila vacia.
 * @author Parra, Nadina y Diomedi, Antonela.
 *
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err mensaje de error.
	 */
	public EmptyStackException (String err){
		super (err);
	}
}