package TDADiccionario;
/**
 * Interfaz de entrada
 * @author Antonela Diomedi y Nadina Guadalupe Parra
 * @param <K>	Tipo de dato de la clave
 * @param <V>	Tipo de dato del valor
 */

public interface Entry<K,V> {
	
	/**
	 * Retorna la clave de la entrada
	 * @return clave
	 */
	
	public K getKey();
	
	/**
	 * Retorna el valor de la entrada
	 * @return valor
	 */
	
	public V getValue();
	
}