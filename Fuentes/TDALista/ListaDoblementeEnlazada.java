package TDALista;

import java.util.Iterator;

/**
 * Clase Lista Doblemente Enlazada.
 * Define los datos y operaciones aplicables en una lista.
 * @author Parra, Nadina y Diomedi, Antonella
 * @param <E> Tipo de dato de los elementos a almacenar en la lista.
 */


public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	
	protected DNodo<E> head,tail;
	protected int size;
	
	/**
	 * Construye una lista vacia doblemente enlazada.
	 */
	public ListaDoblementeEnlazada(){
		head=new DNodo<E>();
		tail=new DNodo<E>();
		size=0;
		head.setSiguiente(tail);
		tail.setAnterior(head);
	}
	
    public int size(){
    	return size;
    }
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public Position<E> first() throws EmptyListException{
		if(size==0) throw new EmptyListException("La lista esta vacia.");
		return head.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		if (size==0) throw new EmptyListException("La lista esta vacia");
		return tail.getAnterior();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> nuevo=checkPosition(p);
		if (nuevo.equals(head.getSiguiente())) throw new BoundaryViolationException("El primer elemento no tiene previo");
		return nuevo.getAnterior();
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> nuevo=checkPosition(p);
		if(nuevo.equals(tail.getAnterior())) throw new BoundaryViolationException("El ultimo elemento no tiene siguiente");
		return nuevo.getSiguiente();
	}
	
	public void addFirst(E e){
		DNodo<E> nuevo=new DNodo<E>(e,head,head.getSiguiente());
		(head.getSiguiente()).setAnterior(nuevo);
		head.setSiguiente(nuevo);
		size++;
	}
	
	public void addLast(E e){
		DNodo<E> nuevo=new DNodo<E>(e,tail.getAnterior(),tail);
		(tail.getAnterior()).setSiguiente(nuevo);
		tail.setAnterior(nuevo);
		size++;
	}
	
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> nodo=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,nodo,nodo.getSiguiente());
		(nodo.getSiguiente()).setAnterior(nuevo);
		nodo.setSiguiente(nuevo);
		size++;
	}
	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> nodo=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,nodo.getAnterior(),nodo);
		(nodo.getAnterior()).setSiguiente(nuevo);
		nodo.setAnterior(nuevo);
		size++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		DNodo<E> v=checkPosition(p);
		if(size==0) throw new InvalidPositionException("La Posicion es invalida.");
		DNodo<E> sig = v.getSiguiente();
		DNodo<E> ant = v.getAnterior();
		E elem = v.element();
		sig.setAnterior(ant);
		ant.setSiguiente(sig); 
		v.setSiguiente(null);
		v.setAnterior(null);
		v.setElement(null);
		size--;
		return elem;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException{
		DNodo<E> v = checkPosition(p);
		if(size==0) throw new InvalidPositionException("La Posicion es invalida.");
		E toReturn = v.element();
		v.setElement(element);
		return toReturn;	
	}
		
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
		
	public Iterable<Position<E>> positions(){			
		PositionList<Position<E>> lista=new ListaDoblementeEnlazada<Position<E>>();
		try{
			if(!(size==0)){
				Position<E> pos=head.getSiguiente();
				while(pos!=null){
					lista.addLast(pos);
					if(pos==(tail.getAnterior()))
						pos=null;
					else pos=next(pos);
				}
			}
		}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return lista;
	}
	
	/**
	 * Verifica que la posicion sea valida.
	 * @param p Posicion que queremos validar.
	 * @return Retorna el nodo en esa posicion.
	 * @throws InvalidPositionException Si la posicion es invalida, lanza el error.
	 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null) throw new InvalidPositionException("La posicion no es valida.");
		if (p==head) throw new InvalidPositionException("La cabeza no es una posicion valida.");
		if (p==tail) throw new InvalidPositionException("La cola no es una posicion valida.");
		try{
			DNodo<E> temp = (DNodo<E>) p;
			if ((temp.getAnterior() == null) || (temp.getSiguiente()==null))
					throw new InvalidPositionException("La posicion no es valida.");
			return temp;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("La posicion no es valida");
		}

}
}