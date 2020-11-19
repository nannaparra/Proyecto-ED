package Programa;
import TDAPila.*;
import TDAColaCP.*;
import TDADiccionario.*;
import TDADiccionario.Entry;
import TDADiccionario.InvalidKeyException;

import java.util.Deque;

import TDACola.*;
import TDADeque.*;

/**
 * Clase Logica: Realiza los servicios y consultas que provee la cuenta bancaria.
 * 
 * @author Parra, Nadina y Diomedi, Antonela.
 * Proyecto Estructura de Datos - 2020.
 */
public class Logica {
	protected Deque<Transaccion> transacciones;
	protected float saldo;
	protected String usuario;
	private Dictionary<Float,String> dicc;
	private PriorityQueue<Float, String> ccp;
	
	/**
	 * Crea e inicializa a Logica.
	 */
	public Logica() {
		transacciones=new Cola<Transaccion>();
		saldo=0;
		usuario="";
		dicc=new DiccionarioHA <Float,String>();
		ccp= new Heap<Float, String>(100,new DefaultComparator());
	}
	
	/**
	 * Verifica si el codigo de acceso cumple con el formato AxA'A' siendo
	 * A el apellido del usuario y A' el apellido del usuario invertido.
	 * Asumimos que 'x' no forma parte del apellido y es utilizado como separador.
	 * @param codigo Codigo ingresado por el usuario.
	 * @return True si el codigo cumple el formato, false en caso contrario.
	 */
	public boolean codigoAcceso(String codigo) {
		boolean valido=true;
		int indice=0;
		int size=codigo.length();
		String caracter=null;
		Stack<String> pila=new PilaEnlazada<String>();
		Stack<String> pila_aux=new PilaEnlazada<String>();
		Queue<String> cola=new ColaCircular<String>();
		try {
			if(size<4)
				valido=false;
			else {
				caracter=codigo.charAt(indice)+"";
				//Leo A
				while(valido && !caracter.equals("x")) {
					pila.push(caracter);
					pila_aux.push(caracter);
					indice++;
					if(indice<size)
						caracter=codigo.charAt(indice)+"";
					else
						valido=false;
				}
				if(valido) {
					indice++; //Avanzo indice
					if(indice<size)
						caracter=codigo.charAt(indice)+"";
					else
						valido=false;
					//Leo A'
					while(valido && !pila.isEmpty()) {
						if(!pila.pop().equals(caracter))
							valido=false;
						else {
							cola.enqueue(caracter);
							indice++;
							if(indice<size)
								caracter=codigo.charAt(indice)+"";
							else
								valido=false;
						}
					}
					if(!pila.isEmpty())
						valido=false;
					//Leo A'
					if(valido) {
						while(valido && !cola.isEmpty()) {
							if(!cola.dequeue().equals(caracter))
								valido=false;
							else {
								indice++;
								if(indice<size)
									caracter=codigo.charAt(indice)+"";
							}
						}
						if(indice!=size || !cola.isEmpty())
							valido=false;
						else
							guardarUsuario(pila_aux);
					}
				}
			}
		}catch(EmptyQueueException eqe) {eqe.getMessage();}
		catch(EmptyStackException ese) {ese.getMessage();}
		return valido;
	}
	
	/**
	 * Obtiene el apellido del usuario con el codigo de acceso
	 * y lo almacena en el atributo usuario.
	 * @param pila Pila en donde esta almacenado el apellido del usuario.
	 */
	private void guardarUsuario(Stack<String> pila) {
		Stack<String> pila_aux=new PilaEnlazada<String>();
		try {
			while(!pila.isEmpty())
				pila_aux.push(pila.pop());
			while(!pila_aux.isEmpty())
				usuario+=pila_aux.pop()+"";
		} catch (EmptyStackException e) {e.printStackTrace();}
	}
	
	/**
	 * Retorna el nombre del usuario.
	 * @return Nombre del usuario.
	 */
	public String nombreUsuario() {
		return usuario;
	}
	
	/**
	 * Retorna la ultima transacción que se realizo.
	 * @return Valor y descripción de la ultima transacción.
	 */
	public String opReciente() {
		String text=null;
		if(!transacciones.isEmpty()) {
			Transaccion transaccionReciente=transacciones.peekLast();
			text="Valor: $"+transaccionReciente.getSaldo()+"\r\n\r\n\r\nDescripci\u00F3n: "+transaccionReciente.getDescripcion()+"\r\n";
		}
		return text;
	}
	
	/**
	 * Retorna la primera transacción que se realizo.
	 * @return Valor y descripción de la ultima transacción.
	 */
	public String opHistorica() {
		String text=null;
		if(!transacciones.isEmpty()) {
			Transaccion transaccionReciente=transacciones.peekFirst();
			text="Valor: $"+transaccionReciente.getSaldo()+"\r\n\r\n\r\nDescripci\u00F3n: "+transaccionReciente.getDescripcion()+"\r\n";
		}
		return text;
	}
	
	/**
	 * Retorna el saldo total que tiene en la cuenta.
	 * @return Saldo total.
	 */
	public String saldo() {
		return Float.toString(saldo);
	}
	
	/**
	 * Retorna la transacción con valor mas alto que se realizo.
	 * @return Valor y descripcción de la transacción mas costosa.
	 */
	public String opMasCostosa() {
		String text=null;
		if(!transacciones.isEmpty())
			try {
				Stack<Float> pila=new PilaEnlazada<Float>();
				Stack<String> pila2=new PilaEnlazada<String>();
				TDAColaCP.Entry<Float, String>e;
			
				while(!ccp.isEmpty()) {
					e=ccp.removeMin();
					pila.push(e.getKey());
					pila2.push(e.getValue());
				}
			
				text="Valor: $"+pila.top()+"\r\n\r\n\r\nDescripción: "+pila2.top();
			
				while(!pila.isEmpty())
					ccp.insert(pila.pop(), pila2.pop());	
				
			}catch(EmptyPriorityQueueException | EmptyStackException | TDAColaCP.InvalidKeyException e) {
				System.out.println(e.getMessage());}
		return text;
	}

	/**
	 * Retorna todos los valores y descripciones de las transacciones que tienen
	 * el mismo valor pasado como parametro.
	 * @param montoS Valor de las transacciones a mostrar.
	 * @return Transacciones que tiene el mismo monto.
	 */
	public String opMismoMonto(String montoS) {
		Float monto=Float.parseFloat(montoS);
		String text=null;
		try {
			for(Entry<Float, String> entradas : dicc.findAll(monto)) {
				if(text==null) {
					text="Descripción: "+entradas.getValue()+"\n Valor: $"+entradas.getKey();
				}
				else
					text=text+"\n Descripción: "+entradas.getValue()+"\n Valor: $"+entradas.getKey();
			}
		}
		catch(InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
		return text;
	}
	
	/**
	 * Ingresa una nueva transaccion, si el valor es positivo se toma como un deposito
	 * si el valor es negativo es una extracción. Si se desea extraer un monto mayor
	 * al disponible, la transacción no se realiza.
	 * Cada transacción tiene un valor y una descipción.
	 * @param valorS Valor ingresado por el usuario.
	 * @param descripcion Descripción ingresada por el usuario.
	 * @return Retorna un 0 si la transacción fue realizada con exito, -1 en caso contrario.
	 */
	public int nuevaTransaccion(String valorS,String descripcion) {
		int exito=0;
		float valor=Float.parseFloat(valorS);
		float saldo_aux=saldo+valor;
		if((saldo_aux)<0)
			exito=-1;
		else {
			Transaccion nueva=new Transaccion(valor,descripcion);
			transacciones.add(nueva);
			saldo=saldo_aux;
		}
		//También inserto los valores de entrada en las estructuras Diccionario y ColaConPrioridad
		try {
			dicc.insert(valor,descripcion);
			ccp.insert(valor, descripcion);
		} catch (InvalidKeyException | TDAColaCP.InvalidKeyException e) {System.out.println(e.getMessage());}
		return exito;
	}
	
	

}
