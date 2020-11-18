package TDAPila;
/**
 * Clase Pila Enlazada.
 * Define los datos y operaciones aplicables sobre una pila.
 * @author Parra, Nadina y Diomedi, Antonela.
 * @param <E> Tipo de dato de los elementos a almacenar en la pila.
 */


public class PilaEnlazada <E> implements Stack<E> {
	protected Nodo<E> head;
	protected int size;
	
	/**
	 * Crea una pila vacia utilizando una estructura de nodos enlazados.
	 */
	public PilaEnlazada (){
		head =null;
		size=0;
	}
	
	public boolean isEmpty(){
	return (size==0);
	}
	public void push(E item){
		Nodo<E> aux= new Nodo<E>();
		aux.setElemento(item);
		aux.setSiguiente(head);
		head=aux;
		size++;
	}
	public E pop() throws EmptyStackException{
		if (size==0) throw new EmptyStackException ("Pila Vacia");
		E aux=head.getElemento();
		head=head.getSiguiente();
		size--;
		return aux;
	}
	public E top()throws EmptyStackException{
		if (size==0) throw new EmptyStackException ("Pila vacia");
		return head.getElemento();
	}
	public int size(){
		return size;
		
	}
	

}
