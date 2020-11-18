package TDALista;
/**
 * Modela un acceso a una lista vacia.
 * @author Parra, Nadina y Diomedi, Antonella
 *
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public EmptyListException (String err){
		super(err);
	}
}
