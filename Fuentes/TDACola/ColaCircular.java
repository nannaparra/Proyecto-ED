package TDACola;

/**
 * Clase Cola Circular.
 * @author Parra, Nadina y Diomedi, Antonela.
 * @param <E> Tipo de dato de los elementos a almacenar en la cola.
 */
public class ColaCircular<E> implements Queue<E> {
	protected int f,r;
	protected E[] cola;
	

	/**
	 * Construye una cola circular vacia.
	 */
	@SuppressWarnings("unchecked")
	public ColaCircular(){
		cola=(E[]) new Object [10];
		r=0;
		f=0;
	}
	
	public void enqueue(E e){
		if (size()==((cola.length)-1))
			redimensionar();
		cola[r]=e;
		r=(r+1)%(cola.length);
	}
		
		
	public E dequeue() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException("Cola vacia");
		E temp= cola[f];
		cola[f]=null;
		f=(f+1)%(cola.length);
		return temp;
	}
		
		
	public E front() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException ("Cola vacia");
		return cola[f];	
	}
		
		
	public boolean isEmpty(){
		return (f==r);
	}
		
		
	public int size(){
		return ((cola.length-f+r)%(cola.length));
	}
	
	/**
	 * Aumenta el tamaño de la cola.
	 */
	private void redimensionar() {
		E[] nuevo=(E[])new Object[2*cola.length];
		int m=size();
		int faux=f;
		for(int i=0;i<m;i++){
			nuevo[i]=cola[faux];
			faux=(faux+1)%cola.length;
		}
		r=size();
		f=0;			
		cola=nuevo;
	}

}
