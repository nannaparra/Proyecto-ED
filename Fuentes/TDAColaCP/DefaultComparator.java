package TDAColaCP;

import java.util.Comparator;

/**
 * Clase DefaultComparator.
 * Modela un comparador y la operacion que brinda.
 *  @author Antonela Diomedi y Nadina Guadalupe Parra
 *
 * @param <E> Tipo de dato de los elementos que compara.
 */
public class DefaultComparator<E> implements Comparator<E> {
	
	@SuppressWarnings("unchecked")
	public int compare(E o1, E o2) {
		return ((Comparable<E>) o1).compareTo(o2);
	}

}
