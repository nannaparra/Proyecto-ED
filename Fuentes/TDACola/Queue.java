package TDACola;


/**
 * Interface Queue
 * @author Parra, Nadina y Diomedi, Antonela.
 */
public interface Queue<E> {
	
	/**
	 * Inserta un elemento al final de la cola.
	 * @param e elemento a insertar.
	 */
	public void enqueue(E e);
	
	/**
	 * Elimina el primer elemento de la cola y lo retorna.
	 * @return elemento eliminado.
	 * @throws EmptyQueueException si la cola esta vacia.
	 */
	public E dequeue() throws EmptyQueueException;
	
	/**
	 * Retorna el elemento del frente de la cola.
	 * @return elemento del frente de la cola.
	 * @throws EmptyQueueException si la cola esta vacia.
	 */
	public E front() throws EmptyQueueException;
	
	/**
	 * Consulta si la cola esta vacia.
	 * @return verdadero si la cola esta vacia y falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna la cantidad de elementos de la cola.
	 * @return cantidad de elementos de la cola.
	 */
	public int size();
	
	}
	

