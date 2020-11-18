package Programa;

/**
 * Clase Transaccion: Crea y provee los servicios de una transacción.
 * @author Parra, Nadina y Diomedi, Antonela.
 * Proyecto Estructura de Datos - 2020.
 */
public class Transaccion {
	protected float saldo;
	protected String descripcion;
	
	/**
	 * Crea una transacción con un valor y una descripción.
	 * @param saldo Valor ingresado por el usuario.
	 * @param descripcion Descripción ingresada por el usuario.
	 */
	public Transaccion(float saldo,String descripcion) {
		this.saldo=saldo;
		this.descripcion=descripcion;
	}
	
	/**
	 * Retorna el monto de la transacción.
	 * @return Valor de la transacción.
	 */
	public float getSaldo() {
		return saldo;
	}
	
	/**
	 * Retorna la descripción de la transacción.
	 * @return Descripción de la transacción.
	 */
	public String getDescripcion() {
		return descripcion;
	}

}
