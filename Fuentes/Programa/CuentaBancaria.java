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
 * Clase Cuenta Bancaria.
 * Realiza los servicios y consultas que provee la cuenta bancaria.
 * 
 * @author Parra, Nadina y Diomedi, Antonela.
 * Proyecto Estructura de Datos  2020.
 */
public class CuentaBancaria {
	protected Deque<Transaccion> transacciones;
	protected float saldo;
	
	/**
	 * Crea e inicializa a Cuenta Bancaria.
	 */
	public CuentaBancaria() {
		transacciones=new Cola<Transaccion>();
		saldo=0;
	}
	
	/**
	 * Verifica si el codigo de acceso cumple con el formato AxA'A' siendo
	 * A el apellido del usuario y A' el apellido del usuario invertido.
	 * Asumimos que 'x' no forma parte del apellido y es utilizado como separador.
	 * @param codigo Codigo ingresado por el usuario.
	 * @return Apellido del usuario si el codigo es valido, null en caso contrario.
	 */
	public String codigoAcceso(String codigo) {
		boolean valido=true;
		int indice=0;
		int size=codigo.length();
		String caracter=null;
		String usuario=null;
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
							usuario=guardarUsuario(pila_aux);
					}
				}
			}
		}catch(EmptyQueueException eqe) {eqe.getMessage();}
		catch(EmptyStackException ese) {ese.getMessage();}
		return usuario;
	}
	
	
	/**
	 * Obtiene el apellido del usuario con el codigo de acceso
	 * y lo almacena en un String.
	 * @param pila Pila en donde esta almacenado el apellido del usuario.
	 * @return Apellido del usuario.
	 */
	private String guardarUsuario(Stack<String> pila) {
		Stack<String> pila_aux=new PilaEnlazada<String>();
		String usuario="";
		try {
			while(!pila.isEmpty())
				pila_aux.push(pila.pop());
			while(!pila_aux.isEmpty())
				usuario+=pila_aux.pop()+"";
		} catch (EmptyStackException e) {e.printStackTrace();}
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
		PriorityQueue<Float, String> ccp=new Heap<Float, String>(100,new DefaultComparator());
		try {
			if(!transacciones.isEmpty()) {
				for(Transaccion t:transacciones)
					ccp.insert(t.getSaldo(), t.getDescripcion());
		
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
			}	
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
		Dictionary<Float,String> dicc=new DiccionarioHA <Float,String>();
		try {
			for(Transaccion t:transacciones)
				dicc.insert(t.getSaldo(), t.getDescripcion());
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
			if(valor<0)
				valor=valor*(-1);
			Transaccion nueva=new Transaccion(valor,descripcion);
			transacciones.add(nueva);
			saldo=saldo_aux;
		}
		return exito;
	}
	
	

}
