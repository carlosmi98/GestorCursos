package gestionEstudiantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

import java.io.IOException;

import utils.Teclado;
import utils.EntradaDatos;

import modelos.Estudiante;
import modelos.EstudianteIntercambio;
import modelos.EstudianteRegular;

public class Curso {
	Teclado t = new Teclado();
	
	private Map<String, List<Estudiante>> cursosPorCarrera;  // Relaciona carrera con estudiantes
	private Map<Integer, List<Double>> notasPorEstudiante;  // Relaciona estudiante con sus notas
	    
	public void inicializarCursos() {
       cursosPorCarrera = new HashMap<>();
	   notasPorEstudiante = new HashMap<>();

	}
	
	
	public void altas() throws IOException {

		String carrera;
		char confirmar = ' ', intercambio;
		int codigo;
		Estudiante estudiante;
		
		do {
			carrera = EntradaDatos.leerStringNoVacio(t, "Introduce carrera: ");
			
			if (!cursosPorCarrera.containsKey(carrera)) {
				cursosPorCarrera.putIfAbsent(carrera, new ArrayList<>());
				
				System.out.println("\nCarrera registrada correctamente.\n");
			} else {
				System.out.println("\nLa carrera ya existe.\n");
				continue;
			}
			do {
				do {
					codigo = EntradaDatos.leerEnteroValido(t, "Introduce código estudiante: ");
					if(notasPorEstudiante.containsKey(codigo))
						System.out.println("El código de alumno ya existe.");
				}while(notasPorEstudiante.containsKey(codigo));
				intercambio = EntradaDatos.leerOpcionSN(t, "El estudiante es de intercambio? s/n: ");
				
				if(intercambio == 's') {
					estudiante = EstudianteIntercambio.crearDesdeInput(t, codigo);

					registrarEstudiante(carrera, estudiante, codigo);
					
				} else {
					estudiante = EstudianteRegular.crearDesdeInput(t, codigo);
					
					registrarEstudiante(carrera, estudiante, codigo);

				}
				
				confirmar = EntradaDatos.leerOpcionSN(t, "Quieres agregar otro alumno a la carrera? s/n: ");
				
			} while (confirmar == 's');
			
			confirmar = EntradaDatos.leerOpcionSN(t, "Quieres agregar otra carrera? s/n: ");

		} while (confirmar == 's');
	}
	
	private void registrarEstudiante(String carrera, Estudiante estudiante, int codigo) {
	    cursosPorCarrera.get(carrera).add(estudiante);
	    notasPorEstudiante.putIfAbsent(codigo, new ArrayList<>()); //guarda solo si no existe el codigo, con put() sobreescribiría el estudiante
	
	    System.out.println("\nAlumno registrado correctamente.\n");
		System.out.println("Total de estudiantes en " + carrera + ": " + cursosPorCarrera.get(carrera).size());
		//al guardar el codigo de la lista en un mapa nos aseguramos que no se repita el codigo en la lista

	}

	public void agregarNotas() throws IOException {
		int codigo;
		char siguiente;
		double nota;
		
		do {
			codigo = EntradaDatos.leerEnteroValido(t, "Inserta código del alumno al que quieres agregar notas: ");
			if (!notasPorEstudiante.containsKey(codigo))
	            System.out.println("El código no existe. Intenta otra vez.");
	       
		}while(!notasPorEstudiante.containsKey(codigo));
		
		do {
			nota = EntradaDatos.leerDoubleValido(t, "Introduce nota del alumno: ");
			siguiente = EntradaDatos.leerOpcionSN(t, "Quieres añadir más notas: ");
			
			notasPorEstudiante.get(codigo).add(nota);

		}while(siguiente == 's');
		
		}
	
	public void eliminarEstudiante() throws IOException {
		
		int codigo; 
		boolean encontrado = false;
		 
		codigo = EntradaDatos.leerEnteroValido(t, "Introduce codigo de estudiante a eliminar");
		
		for(Map.Entry<String, List<Estudiante>> ent : cursosPorCarrera.entrySet()) {
			List<Estudiante> estudiantes = ent.getValue();
			Iterator<Estudiante> iter = estudiantes.iterator();
			
		    while (iter.hasNext()) {
		        Estudiante est = iter.next();
		        
		        if (est.getCodigo() == codigo) {
		            iter.remove(); 
		            System.out.println("Estudiante eliminado de la carrera " + ent.getKey());
		            encontrado = true;
		            break;
		        }
		    }

		}

		if (!encontrado) {
			System.out.println("Estudiante no encontrado.");
		}
		
	}
	
	public void buscarEstudianteNombre() throws IOException {
		
		String nombreBuscado;
		boolean encontrado = false;
		nombreBuscado = EntradaDatos.leerStringNoVacio(t, "Introduce nombre del alumno a buscar: ");
		
		for(Map.Entry<String, List<Estudiante>> ent : cursosPorCarrera.entrySet()) {
			List<Estudiante> estudiantes = ent.getValue();
			
			for(Estudiante est : estudiantes) {
				if(est.getNombre().equalsIgnoreCase(nombreBuscado)) {
					System.out.println("Estudiante encontrado en la carrera " + ent.getKey());
					System.out.println(est);
					encontrado = true;
				}
				
			}
		}
		if(!encontrado) System.out.println("estudiante no encontrado.");
	}
	//-------------------------------------------------------------------------------------------------------------
	
	
	public void listado() {
		
		int conteoRegular = 0;
		int conteoIntercambio = 0;
		System.out.println("\nListado de carreras y sus estudiantes:");

		for (Map.Entry<String, List<Estudiante>> entrada : cursosPorCarrera.entrySet()) {
			System.out.println("Carrera: " + entrada.getKey());

			List<Estudiante> estudiantes = entrada.getValue();
			if (estudiantes.isEmpty()) {
				System.out.println("No hay estudiantes registrados.");
			} else {
				for (Estudiante est : estudiantes) {
					if(est instanceof EstudianteRegular) conteoRegular++;
					else if(est instanceof EstudianteIntercambio) conteoIntercambio++;
					
					
					System.out.println(est);
				}
			}
			
		}
		System.out.println("Total de estudiantes regulares: " + conteoRegular + "\nTotal de estudiantes intercambio: " + conteoIntercambio);

	}
	
	public void modificaciones() throws IOException {
		
		int opcion;
		
		System.out.println("Menú modificaciones: \n\t1. Carrera. \n\t2.Alumnos. \n\t3. Notas. \n\t4. Salir.");
		
		do {
			opcion = EntradaDatos.leerEnteroValido(t, "Ingresa opcion entre 1 y 4: ");
			
			switch (opcion) {
			case 1:
//				modificarCarrera();
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("Volviendo al menú principal");
				break;
			case 4:
				break;
				default: System.out.print("Opción no válida.");
			}
		}while(opcion!=4);
	}
	
//	public void modificarCarrera() throws IOException {
//		
//		String carrera = EntradaDatos.leerStringNoVacio(t, "Introduce carrera a modificar: ");
//		boolean encontrado = false;
//		
//		if(cursosPorCarrera.containsKey(carrera)) {
//			encontrado = true;
//				
//		}
//		
//	}
	
	public void fin() {
		System.out.println("Fin del programa.");
	}
}
