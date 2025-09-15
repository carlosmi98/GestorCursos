package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Teclado {
	
	public String leerString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
	}
	
	public char leerChar() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c;
		String s = br.readLine();
		c = s.charAt(0);
		
		return c;
	}
	
	public int leerInt() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int i;
		String s = br.readLine();
		
		try {
			i = Integer.parseInt(s);
		}catch(NumberFormatException nfe) {
			i = Integer.MIN_VALUE;
		}
		
		return i;
	}
	
	public double leerDouble() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double d;
		String s = br.readLine();
		
		try {
			d= Double.parseDouble(s);
		}catch(NumberFormatException nfe) {
			System.err.println("Formato incorrecto. Decimal '.' o entero.");
			d = Double.MIN_VALUE;
		}
		return d;
	}
	
}
