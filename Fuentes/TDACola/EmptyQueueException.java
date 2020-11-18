package TDACola;
/**
 * Modela un acceso a una cola vacia.
 * @author Parra, Nadina y Diomedi, Antonela.
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
       
	/**
	 * Inicia la clase con un mensaje pasado como parametro.
	 * @param err String que recibe el mensaje de error.
	 */
	   public EmptyQueueException(String err){
			super(err);
		}
}

