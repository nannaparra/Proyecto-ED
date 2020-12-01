package TDALista;
import java.util.Iterator;

/**
 * Clase ElementIterator
 * Modela un iterador con los elementos de una lista.
 * @author Parra, Nadina y Diomedi, Antonella
 *
 * @param <E> Tipo de dato de los elementos almacenados en el iterador.
 */
public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Crea un iterador con los elementos de la lista pasada como parametro.
	 * @param l lista a partir de la cual se contruye el iterador.
	 */
	public ElementIterator (PositionList <E> l ) {
		try{				
			list=l;
			if (list.isEmpty()) cursor = null;
			else cursor = list.first();			
		}catch(EmptyListException e){System.out.println("e:"+e.getMessage());}			
	}
		
	/**Consulta si el iterador tiene siguiente elemento.
	 * @return true si tiene siguiente, false en caso contrario.
	 */
	public boolean hasNext() {
		return cursor !=null;
	}
	
	/**Retorna el siguiente elemento del iterador.
	 * @return siguiente elemento del iterador.
	 */
	public E next()   {
		E toReturn=null;
		if (hasNext()){
		toReturn = cursor.element();
		try{
			cursor = (cursor ==  list.last()) ? null : list.next(cursor);
		}catch(EmptyListException e){System.out.println("e:"+e.getMessage());}
		catch(BoundaryViolationException b){System.out.println("b:"+b.getMessage());}
		catch(InvalidPositionException i){System.out.println("i:"+i.getMessage());}
		}
		return toReturn;
	}
}