package TDALista;
/**
 * Modela un acceso a una posicion invalida.
 * @author Parra, Nadina y Diomedi, Antonella
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}