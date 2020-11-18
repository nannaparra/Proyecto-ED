package TDALista;

/**
 * Clase DNodo.
 * Crea y define operaciones que se pueden aplicar a un nodo.
 * @author Parra, Nadina y Diomedi, Antonela.
 * @param <E> Tipo de dato de los elementos a almacenar en el nodo.
 */
public class DNodo<E> implements Position<E> {
	protected E elemento;
	protected DNodo<E> ant;
	protected DNodo<E> sig;
	
	/**
	 * Crea un nodo doble nulo.
	 */
	public DNodo(){
		elemento=null;
		ant=null;
		sig=null;		
	}
	
	/**
	 * Crea un nodo doble con su elemento y su nodo siguiente y anterior.
	 * @param e Elemento que se va a asignar al nodo.
	 * @param anterior Nodo que se asigna como nodo anterior.
	 * @param siguiente Nodo que se asigna como nodo siguiente.
	 */
	public DNodo(E e,DNodo<E> anterior,DNodo<E> siguiente){
		elemento=e;
		ant=anterior;
		sig=siguiente;
	}
	
	
	public E element(){
		return elemento;
	}
	
	/**
	 * Cambia el elemento del nodo.
	 * @param e Elemento que se va a asignar al nodo.
	 */
	
	public void setElement(E e){
		elemento=e;
	}
	
	/**
	 * Cambia el nodo siguiente al nodo que recibe el mensaje.
	 * @param siguiente Nodo que se va a asignar como nodo siguiente.
	 */
	public void setSiguiente(DNodo<E> siguiente){
		sig=siguiente;
	}
	
	/**
	 * Retorna el nodo siguiente al nodo que recibe el mensaje. 
	 * @return Nodo siguiente.
	 */
	public DNodo<E> getSiguiente(){
		return sig;
	}
	
	/**
	 * Cambia el nodo anterior al nodo que recibe el mensaje.
	 * @param anterior Nodo que se va a asignar como nodo anterior.
	 */
	public void setAnterior(DNodo<E> anterior){
		ant=anterior;
	}
	
	/**
	 * Retorna el nodo anterior al nodo que recibe el mensaje.
	 * @return Nodo anterior.
	 */
	public DNodo<E> getAnterior(){
		return ant;
	}

}
