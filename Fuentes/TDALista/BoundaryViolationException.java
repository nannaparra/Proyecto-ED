package TDALista;
/**
 * Modela un acceso por fuera de los limites de la estructura.
 * @author Parra, Nadina Guadalupe.
 *
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}