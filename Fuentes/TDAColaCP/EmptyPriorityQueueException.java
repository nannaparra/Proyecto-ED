package TDAColaCP;
/**
 * Class EmptyPriorityQueueException
 * @author Antonela Diomedi y Nadina Guadalupe Parra
 * Clase que modela la excepcion ante una operacion que excede los l�mites de la estructura
 */
public class EmptyPriorityQueueException extends Exception {
	
	/**
	 * Inicializa una nueva excepcion.
	 * El msg describe el origen de la misma. 
	 * @param msg describe el origen de la excepcion
	 */
 public EmptyPriorityQueueException(String msj) {
	 super(msj);
 }
}
