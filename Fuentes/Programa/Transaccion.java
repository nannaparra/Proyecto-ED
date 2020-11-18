package Programa;

/**
 * Clase Transaccion: Crea y provee los servicios de una transacci�n.
 * @author Parra, Nadina y Diomedi, Antonela.
 * Proyecto Estructura de Datos - 2020.
 */
public class Transaccion {
	protected float saldo;
	protected String descripcion;
	
	/**
	 * Crea una transacci�n con un valor y una descripci�n.
	 * @param saldo Valor ingresado por el usuario.
	 * @param descripcion Descripci�n ingresada por el usuario.
	 */
	public Transaccion(float saldo,String descripcion) {
		this.saldo=saldo;
		this.descripcion=descripcion;
	}
	
	/**
	 * Retorna el monto de la transacci�n.
	 * @return Valor de la transacci�n.
	 */
	public float getSaldo() {
		return saldo;
	}
	
	/**
	 * Retorna la descripci�n de la transacci�n.
	 * @return Descripci�n de la transacci�n.
	 */
	public String getDescripcion() {
		return descripcion;
	}

}
