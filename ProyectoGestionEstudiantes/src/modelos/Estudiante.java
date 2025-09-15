package modelos;

import java.io.IOException;
import utils.EntradaDatos;
import utils.Teclado;

public class Estudiante {

	private int codigo;
	private String nombre;
	private int edad;
	private char intercambio;
	
	public Estudiante() {};

	Estudiante(int codigo, String nombre, int edad, char intercambio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.intercambio = intercambio;
	}

	public char getIntercambio() {
		return intercambio;
	}

	public void setIntercambio(char intercambio) {
		this.intercambio = intercambio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

//	@Override
//	public String toString() {
//		// facer con stringbuilder retornar sbappend
//		return "Codigo: " + codigo + "\nNombre: " + nombre + "\nEdad: " + edad + "\nintercambio: " + intercambio;
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Código: ").append(codigo).append("\n");
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Edad: ").append(edad).append("\n");
		sb.append("Intercambio: ").append(intercambio).append("\n");
		
		return sb.toString();
	}
	
	
}
