package utils;

import java.io.IOException;
import utils.Teclado;

public class EntradaDatos {
	Teclado t = new Teclado();
	
	//------------------------------metodos privados para altas; refactorizacion---------------------------------
	
	public static String leerStringNoVacio(Teclado t, String mensaje) throws IOException {
	    String entrada;
	    do {
	        System.out.println(mensaje);
	        entrada = t.leerString();
	    } while (entrada.isEmpty());
	    return entrada;
	}
	
	public static char leerOpcionSN(Teclado t, String mensaje) throws IOException {
	    char opcion;
	    do {
	        System.out.println(mensaje);
	        opcion = Character.toLowerCase(t.leerChar());
	    } while ("sn".indexOf(opcion) == -1);
	    return opcion;
	}

	public static int leerEnteroValido(Teclado t, String mensaje) throws IOException {
	    int numero;
	    do {
	        System.out.println(mensaje);
	        numero = t.leerInt();
	    } while (numero == Integer.MIN_VALUE);
	    return numero;
	}
	
	public static double leerDoubleValido(Teclado t, String mensaje) throws IOException {
	    double decimal;
	    
	    do {
	        System.out.println(mensaje);
	        decimal = t.leerInt();
	    } while (decimal == Double.MIN_VALUE);
	    return decimal;
	}
}
