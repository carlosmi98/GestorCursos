package modelos;

import java.io.IOException;

import utils.EntradaDatos;
import utils.Teclado;

public class EstudianteIntercambio extends Estudiante{

	private String nacionalidad;
	private String lenguaNativa;

	public EstudianteIntercambio() {}

	public EstudianteIntercambio(int codigo, String nombre, int edad, char intercambio, String nacionalidad,
			String lenguaNativa) {
		super(codigo, nombre, edad, intercambio);
		this.nacionalidad = nacionalidad;
		this.lenguaNativa = lenguaNativa;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "\nNacionalidad: " + nacionalidad + "\nLengua nativa: " + lenguaNativa + "\n\n";
	}

	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLenguaNativa() {
		return lenguaNativa;
	}

	public void setLenguaNativa(String lenguaNativa) {
		this.lenguaNativa = lenguaNativa;
	}
	
	public static EstudianteIntercambio crearDesdeInput(Teclado t, int codigo) throws IOException {
	    String nombre = EntradaDatos.leerStringNoVacio(t, "Introduce nombre del estudiante: ");
	    int edad = EntradaDatos.leerEnteroValido(t, "Introduce edad del estudiante: ");
	    String nacionalidad = EntradaDatos.leerStringNoVacio(t, "Introduce nacionalidad del alumno de intercambio: ");
		String lenguaNativa = EntradaDatos.leerStringNoVacio(t, "Introduce lenguaNativa del alumno de intercambio: ");
		
	    return new EstudianteIntercambio(codigo, nombre, edad, 's', nacionalidad, lenguaNativa);
	}
}
