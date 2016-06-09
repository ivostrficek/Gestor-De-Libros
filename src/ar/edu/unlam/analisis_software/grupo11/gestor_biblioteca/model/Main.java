
//Guarda este archivo con el nombre Main.java
//package ....libros;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static PrintStream out = System.out;

	public static String ruta = "libros.tsv";

	public static void main(String[] args) {

		Funcion<Libro> imprimir = new Funcion<Libro>() {
			@Override
			public void funcion(Libro libro, Object parametros) {
				out.println(libro);
				int[] contador = (int[]) parametros;
				contador[0]++;
			}
		};
		Funcion<Libro> imprimirEnArchivo = new Funcion<Libro>() {
			@Override
			public void funcion(Libro libro, Object parametros) {
				PrintStream archivo = (PrintStream) parametros;
				archivo.print(libro.getISBN() + "\t");
				archivo.print(libro.getTitulo() + "\t");
				archivo.print(libro.getAutor() + "\t");
				archivo.print(libro.getEditorial() + "\t");
				archivo.print(libro.getEdicion() + "\t");
				archivo.print(libro.getAnno_de_publicacion() + "\n");
			}
		};

		// Se banca linux
		if (!System.getProperties().get("os.name").equals("Linux") && System.console() != null)
			try {
				out = new PrintStream(System.out, true, "CP850");
				teclado = new Scanner(System.in, "CP850");
			} catch (UnsupportedEncodingException e) {
			}

		// En el constructor de la biblioteca agrega todos los libros del
		// archivo
		Biblioteca biblioteca = new Biblioteca(ruta);
		int i, n;
		Libro dato = null, libro;
		int[] contador = { 0 };
		int subopcion;
		Long opcion = null;
		libro = new Libro();
		do {
			opcion = mostrar_menu_principal_y_obtener_opcion();
			out.println();
			if (biblioteca.getLibros().isEmpty() && opcion != 1 && opcion != 7) {
				pausar("No hay registros.\n");
			}else{
				if (opcion < 5) {
					libro.setISBN(leer_cadena("Ingrese el ISBN del libro"));
					i = biblioteca.getLibros().indexOf(libro);
					dato = i < 0 ? null : biblioteca.getLibros().get(i);
					if (dato != null) {
						out.println();
						imprimir.funcion(dato, contador);
					}
				}
				if (opcion == 1 && dato != null)
					out.println("El registro ya existe.");
				else if (opcion >= 2 && opcion <= 4 && dato == null)
					out.println("\nRegistro no encontrado.");
				else
					switch (opcion.intValue()) {
					case 1:
							dar_alta_libro(libro, biblioteca);
						break;
					case 3:
							modificar_libro(libro, biblioteca,dato);
						break;
					case 4:
						biblioteca.BajaLibro(dato);
						out.println("Registro borrado correctamente.");
						break;
					case 5:
						biblioteca.OrdenarLibros();
						out.println("Registros ordenados correctamente.");
						break;
					case 6:
						biblioteca.MostrarLibros();
						break;
					}
				if (opcion < 7 && opcion >= 1)
					pausar("");
			}
		} while (opcion != 7);
		try {
			PrintStream salida = new PrintStream(ruta);
			n = biblioteca.getLibros().size();
			for (i = 0; i < n; i++)
				imprimirEnArchivo.funcion(biblioteca.getLibros().get(i), salida);
			salida.close();
		} catch (FileNotFoundException e) {
		}
	}

	private static void modificar_libro(Libro libro, Biblioteca biblioteca, Libro dato) {
		Long subopcion;
		out.println("Men\u00FA de modificaci\u00F3n de campos");
		out.println("1.- titulo");
		out.println("2.- autor");
		out.println("3.- editorial");
		out.println("4.- edicion");
		out.println("5.- anno de publicacion");
		do {
			subopcion = new Long(leer_entero("Seleccione un n\u00FAmero de campo a modificar"));
			if (subopcion < 1 || subopcion > 5)
				out.println("Opci\u00F3n no v\u00E1lida.");
		} while (subopcion < 1 || subopcion > 5);
		biblioteca.ModificacionLibro(subopcion.intValue(), dato);
		out.println("\nRegistro actualizado correctamente.");
		
	}

	private static void dar_alta_libro(Libro libro, Biblioteca biblioteca) {
		biblioteca.AltaLibro(libro);
		libro = new Libro();
		out.println("\nRegistro agregado correctamente.");
	}

	// Con esto busco mostrar el menu de la primera pantalla
	public static Long mostrar_menu_principal_y_obtener_opcion() {
		mostrar_menu_principal();
		return leer_opcion_correcta(1L, 7L);
	}

	public static void mostrar_menu_principal() {
		out.println("MEN\u00DA");
		out.println("1.- Altas");
		out.println("2.- Consultas");
		out.println("3.- Actualizaciones");
		out.println("4.- Bajas");
		out.println("5.- Ordenar registros");
		out.println("6.- Listar registros");
		out.println("7.- Salir");
	}

	// Me encargo de leer la opcion correcta. Recibe el valor inicial y el valor
	// final por parametro.
	private static Long leer_opcion_correcta(Long valorInicial, Long valorFinal) {
		Long numeroDeOpcion;
		String mensaje = "Seleccione una opci\u00F3n";
		String mensajeError = "Valor no valido\n" + mensaje;
		do {
			numeroDeOpcion = new Long(leer_entero(mensaje));
			mensaje = mensajeError;
		} while (numeroDeOpcion < valorInicial || numeroDeOpcion > valorFinal);
		return numeroDeOpcion;
	}

	// Usa esta funcion para realizar pausas en determinados momentos.
	public static void pausar(String mensage) {
		out.print(mensage + "\nPresione <ENTER> para continuar . . . ");
		teclado.nextLine();
		out.println();
	}

	public static String leer_cadena(String mensaje) {
		String linea;
		String mensajeAux = mensaje;
		do {
			out.print(mensajeAux + ": ");
			linea = teclado.nextLine();
			mensajeAux = linea.equals("") ? "La entrada es invalida. No puede estar vacio.\n" + mensaje : mensaje;
		} while (linea.equals(""));
		return linea;
	}

	public static int leer_entero(String mensaje) {
		try {
			return Integer.parseInt(leer_cadena(mensaje));
		} catch (NumberFormatException e) {
			out.print("Formato del n\u00FAmero incorrecto.");
			return leer_entero(mensaje);
		}
	}
	
	public static Long mostrar_menu_modificacion_y_obtener_opcion(){
		mostrar_menu_modificacion();
		return leer_opcion_correcta(1L, 5L);
	}
	
	public static void mostrar_menu_modificacion(){
		out.println("Men\u00FA de modificaci\u00F3n de campos");
		out.println("1.- titulo");
		out.println("2.- autor");
		out.println("3.- editorial");
		out.println("4.- edicion");
		out.println("5.- anno de publicacion");
	}

}
