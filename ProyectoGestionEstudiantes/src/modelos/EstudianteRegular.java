package modelos;

import java.io.IOException;

import utils.EntradaDatos;
import utils.Teclado;

public class EstudianteRegular extends Estudiante {

	private boolean beca;
	
	public EstudianteRegular() {}
	
	public EstudianteRegular(int codigo, String nombre, int edad, char intercambio, boolean beca) {
		super(codigo, nombre, edad, intercambio);
		this.beca = beca;
	}

	
	public static EstudianteRegular crearDesdeInput(Teclado t, int codigo) throws IOException {
	    String nombre = EntradaDatos.leerStringNoVacio(t, "Introduce nombre del estudiante: ");
	    int edad = EntradaDatos.leerEnteroValido(t, "Introduce edad del estudiante: ");
	    char beca1 = EntradaDatos.leerOpcionSN(t, "Tiene beca el estudiante regular? s/n: ");
		boolean beca = beca1 == 's';
		
	    return new EstudianteRegular(codigo, nombre, edad, 'n', beca);
	}
	
//	@Override
//	public String toString() {
//	    return super.toString() +
//	           "\nBeca: " + beca + "\n\n";
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Beca: ").append(beca).append("\n");
		return sb.toString();
	}
	
	public boolean getBeca() {
		return beca;
	}

	public void setBeca(boolean beca) {
		this.beca = beca;
	}
	
}
