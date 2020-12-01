package TDADeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import TDALista.*;

/**
 * Clase Cola Deque.
 * @author Parra, Nadina y Diomedi, Antonela.
 *
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class Cola<E> implements Deque<E>{
	protected PositionList<E> cola;
	
	/**
	 * Crea una cola deque vacia.
	 */
	public Cola(){
		cola=new ListaDoblementeEnlazada<E>();
	}

	@Override
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	
	@Override
	public void addFirst(E e) {
		cola.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		cola.addLast(e);
	}

	@Override
	public boolean offerFirst(E e) {
		cola.addFirst(e);
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		cola.addLast(e);
		return true;
	}

	@Override
	public E removeFirst() {
		E element=null;
		try {
			element=cola.remove(cola.first());
		}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
		catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		
		return element;
	}

	@Override
	public E removeLast() {
		E element=null;
		try {
			element=cola.remove(cola.last());
		}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
		catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		return element;
	}

	@Override
	public E pollFirst() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.remove(cola.first());
			}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
			catch(EmptyListException ele) {System.out.print("Deque vacia");}
		}
		return element;
	}

	@Override
	public E pollLast() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.remove(cola.last());
			}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
		catch(EmptyListException ele) {System.out.print("Deque vacia");}
		}
		
		return element;
	}

	@Override
	public E getFirst() {
		E element=null;
		try {
			element=cola.first().element();
		}catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		return element;
	}

	@Override
	public E getLast() {
		E element=null;
		try {
			element=cola.last().element();
		}catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		return element;
	}

	@Override
	public E peekFirst() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.first().element();
			}catch(EmptyListException ele) {System.out.println("Deque vacia");}
		}
		return element;
	}

	@Override
	public E peekLast() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.last().element();
			}catch(EmptyListException ele) {System.out.println("Deque vacia");}
		}
		return element;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		boolean encontre=false;
		if(!isEmpty()) {
			try {
				Position<E>elem = cola.first();
				int i=1;
			
				while(!encontre && i!=size()) {
					if(elem.element()==o) {
						encontre=true;
					}
					else {
						elem=cola.next(elem);
						i++;
					}
				}
				if(encontre==true) {
					cola.remove(elem);
				}
			}catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			System.out.println(e.getMessage());
			
			}
		}
		return encontre;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		boolean encontre=false;
		Position<E> buscado=null;
		if(!isEmpty()) {
			for(Position<E> posElem : cola.positions())
				if(posElem.element().equals(o)) {
					encontre=true;
					buscado=posElem;
				}
			if(encontre==true)
				try {
					cola.remove(buscado);
				} catch (InvalidPositionException e) {System.out.println(e.getMessage());}
		}
		return encontre;
	}

	@Override
	public boolean add(E e) {
		cola.addLast(e);
		return true;
	}

	@Override
	public boolean offer(E e) {
		cola.addLast(e);
		return true;
	}

	@Override
	public E remove() {
		E element=null;
		try {
			element=cola.remove(cola.first());
		}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
		catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		return element;
	}

	@Override
	public E poll() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.remove(cola.first());
			}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
			catch(EmptyListException ele) {System.out.print("Deque vacia");}
		}
		return element;
	}

	@Override
	public E element() {
		E element=null;
		try {
			element=cola.first().element();
		}catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		return element;
	}

	@Override
	public E peek() {
		E element=null;
		if(!isEmpty()) {
			try {
				element=cola.first().element();
			}catch(EmptyListException ele) {System.out.println("Cola vacia");}
		}
		return element;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(E e) {
		cola.addFirst(e);
	}

	@Override
	public E pop() {
		E element=null;
		try {
			element=cola.remove(cola.first());
		}catch(InvalidPositionException ipe) {System.out.print(ipe.getMessage());}
		catch(EmptyListException ele) {throw new NoSuchElementException ("Deque vacia");}
		
		return element;
	}

	@Override
	public boolean remove(Object o) {
		boolean encontre=false;
		if(!isEmpty()) {
			try {
				Position<E>elem = cola.first();
				int i=1;
			
				while(!encontre && i!=size()) {
					if(elem.element()==o) {
						encontre=true;
					}
					else {
						elem=cola.next(elem);
						i++;
					}
				}
				if(encontre==true) {
					cola.remove(elem);
				}
			}
			catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			System.out.println(e.getMessage());
			}
		}
		return encontre;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return cola.size();
	}

	@Override
	public Iterator<E> iterator() {
		 return cola.iterator();
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
