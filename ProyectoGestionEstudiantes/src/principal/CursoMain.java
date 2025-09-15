package principal;

import java.io.IOException;
import utils.Teclado;
import gestionEstudiantes.Curso;

public class CursoMain {

	public static void main(String[] args) throws IOException {
		CursoMain cm = new CursoMain();
		Teclado t = new Teclado();
		Curso c = new Curso();
		int op;
		c.inicializarCursos();
		do {
			op = cm.menu(t);
			switch (op) {
			case 1:
				c.altas();
				break;
			case 2:
				c.agregarNotas();
				break;
			case 3:
				c.listado();
				break;
			case 4:
				c.modificaciones();
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				c.fin();
				break;
			
				
			}
		}while(op != 8);
	}
	
	int menu(Teclado t) throws IOException{
		int op;
		
		   System.out.println("===== SISTEMA DE GESTIÓN DE ESTUDIANTES =====");
		   System.out.println("1. Registrar un estudiante");
		   System.out.println("2. Mostrar lista de estudiantes");
		   System.out.println("3. Eliminar un estudiante");
		   System.out.println("4. Buscar estudiante por nombre");
		   System.out.println("5. Modificar datos de un estudiante");		   
		   System.out.println("6. Listar cursos disponibles");
		   System.out.println("7. Exportar datos");
		   System.out.println("8. Salir");

		do {
			System.out.println("Elige opción del menú: ");
			op = t.leerInt();
		}while(op < 1 || op > 8);
		
		return op;
	}
}
