package TDAColaCP;

/**
 * 
 * Clase Heap
 *@author Antonela Diomedi y Nadina Guadalupe Parra
 * Implementación de la interface PriorityQueue<K,V> con un Heap
 */
public class Heap<K,V> implements PriorityQueue<K,V> {
	protected Entrada<K,V> [] elems;
	protected DefaultComparator<K> comp;
	protected int size;
	/**
	 * 
	 * Inicializa un nuevo heap 
	 * @param maxElems, cantidad de elementos maximos del heap
	 * @param comp, comparador a asignar
	 */
	public Heap(int maxElems, DefaultComparator<K> comp) {
		elems=(Entrada<K,V> []) new Entrada[maxElems];
		this.comp=comp;
		size=0;
	}
	/**
	 * 
	 * Inicializa un nuevo heap con una cantidad de elementos maxima por defecto
	 * @param comp, comparador a asignar
	 */
	public Heap(DefaultComparator<K> comp) {
		this(4,comp);
	}
	/**
	 * Consulta la cantidad de elementos de la cola.
	 * @return Cantidad de elementos de la cola.
	 */	
	public int size() {
		return size;
	}
	/**
	 * Consulta si la cola est� vac�a.
	 * @return Verdadero si la cola est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return size==0;
	}
	/**
	 * Devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola est� vac�a.
	 */
	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if(size==0) throw new EmptyPriorityQueueException("No se puede pedir el min de un Heap vacio");
		return elems[1];
	}
	/**
	 * Inserta un par clave-valor y devuelve la entrada creada.
	 * @param key Clave de la entrada a insertar.
	 * @param value Valor de la entrada a insertar.
	 * @return Entrada creada.
	 * @throws InvalidKeyException si la clave es inv�lida.
	 */
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
		if(key==null) throw new InvalidKeyException("clave nula");
		if(size==elems.length-1)
			duplicar();
		Entrada<K,V> nueva=new Entrada<K,V>(key,value);
		elems[++size]=nueva;
		int i=size;
		boolean seguir=true;
		while(i>1 && seguir) {
			Entrada<K,V> actual=elems[i];
			Entrada<K,V> padre=elems[i/2];
			if(comp.compare(actual.getKey(), padre.getKey())<0) {
				Entrada<K,V> aux=elems[i];
				elems[i]=elems[i/2];
				elems[i/2]=aux;
				i=i/2;
		}else
			seguir=false;
	}
		return nueva;
	}
	
	/**
	 * Remueve y devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola est� vac�a.
	 */
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
		if(size==0) throw new EmptyPriorityQueueException("La cola esta vacia");
		Entrada<K,V> min=elems[1];
		if(size==1)
			elems[size--]=null; //seteo la componente 1 del arreglo en nula y decremento size
		else {
			elems[1]=elems[size];
			elems[size--]=null;
			int i=1;
			boolean seguir=true;
			while(seguir) {
				int hijoIzq=i*2; int hijoDer=(i*2)+1; boolean tieneIzq=hijoIzq<=size; boolean tieneDer=hijoDer<=size;
				if(!tieneIzq)
					seguir=false;
				else {
					int menor=hijoIzq;
					if(tieneDer) {
						if(comp.compare(elems[hijoIzq].getKey(), elems[hijoDer].getKey())>0)
							menor=hijoDer;
						}
						if(comp.compare(elems[i].getKey(), elems[menor].getKey())>0) {
							Entrada<K,V> aux=elems[i];
							elems[i]=elems[menor];
							elems[menor]=aux;
							i=menor;
						}else
							seguir=false;
					}
				}
			}
		return min;
	}
	/**
	 * 
	 * Duplica el tamaño del Heap 
	 */
	private void duplicar() {
		Entrada<K,V>[] nuevo=(Entrada<K,V> []) new Entrada[elems.length*2];
		for(int i=1; i<elems.length; i++) {
			nuevo[i]=elems[i];
		}
		elems=nuevo;
	}
}