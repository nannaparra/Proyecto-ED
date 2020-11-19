package TDAPila;

/**
 * Clase Nodo
 * @author Parra, Nadina y Diomedi, Antonela.
 *
 * @param <E> Tipo de Dato
 */
public class Nodo<E> {
	private E elemento;
	private Nodo<E> siguiente;
	
	/**
	 * Crea un nodo nulo.
	 */
	public Nodo(){
		this(null, null);
	}
		
	/**
	 * Crea un nodo con su elemento.
	 * @param item Elemento del nodo.
	 */
	public Nodo(E item){
		this(item,null);
	}
	
	/**
	 * Crea un nodo con su elemento y su nodo siguiente.
	 * @param item Elemento del nodo.
	 * @param sig Nodo siguiente al nodo que se crea.
	 */
	public Nodo(E item,Nodo<E> sig ){ 
		elemento=item; 
		siguiente=sig; 
	}
		
	/**
	 * Devuelve el elemento que hay en el nodo.
	 * @return El elemento que hay en el nodo.
	 */
	public E getElemento(){
		return elemento;
	}
	/**
	 * Devuelve el nodo siguiente al nodo que recibe el mensaje.
	 * @return El nodo siguiente al nodo que recibe el mensaje.
	 */
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	/**
	 * Establece el elemento pasado por parametro como rotulo del nodo que recibe el mensaje.
	 * @param elemento Rotulo del nodo que recibe el mensaje.
	 */
	public void setElemento(E elemento){
		this.elemento=elemento;
	}
	/**
	 * Inserta el nodo pasado por parametro como siguiente al nodo que recibe el mensaje.
	 * @param siguiente Nodo a insertar como siguiente al nodo que recibe el mensaje.
	 */
	public void setSiguiente(Nodo<E> siguiente){
		this.siguiente = siguiente;
	} 
}


