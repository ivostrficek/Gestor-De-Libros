import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Biblioteca {

	public Biblioteca(String ruta){
		String[] campos;
		try {
            Scanner entrada = new Scanner(new FileReader(ruta));
            while (entrada.hasNextLine()) {
                campos = entrada.nextLine().split("\t");
                Libro libro = new Libro();
                libro.setISBN(campos[0]);
                libro.setTitulo(campos[1]);
                libro.setAutor(campos[2]);
                libro.setEditorial(campos[3]);
                libro.setEdicion(Integer.parseInt(campos[4]));
                libro.setAnno_de_publicacion(Integer.parseInt(campos[5]));
                libros.add(libro);
            }
            entrada.close();
        } catch (FileNotFoundException e) {}
	}
	
	private Vector<Libro> libros = new Vector<Libro>();
	
	public Vector<Libro> getLibros(){
		return libros;
	}
	
	public void AltaLibro(Libro nuevo){
		nuevo.setTitulo(Main.leer_cadena ("Ingrese el titulo"));
        nuevo.setAutor(Main.leer_cadena ("Ingrese el autor"));
        nuevo.setEditorial(Main.leer_cadena ("Ingrese la editorial"));
        nuevo.setEdicion(Main.leer_entero ("Ingrese la edicion"));
        nuevo.setAnno_de_publicacion(Main.leer_entero ("Ingrese el anno de publicacion"));
        libros.add(nuevo);       
	}
	
	public void ModificacionLibro(int opcion, Libro dato){
		switch (opcion) {
        case 1:
            dato.setTitulo(Main.leer_cadena ("Ingrese el nuevo titulo"));
            break;
        case 2:
            dato.setAutor(Main.leer_cadena ("Ingrese el nuevo autor"));
            break;
        case 3:
            dato.setEditorial(Main.leer_cadena ("Ingrese la nueva editorial"));
            break;
        case 4:
            dato.setEdicion(Main.leer_entero ("Ingrese la nueva edicion"));
            break;
        case 5:
            dato.setAnno_de_publicacion(Main.leer_entero ("Ingrese el nuevo anno de publicacion"));
            break;
		}
	}
	
	public void BajaLibro(Libro dato){
		libros.remove(dato);
	}
	
	public void OrdenarLibros(){
		Collections.sort(libros);
	}
	
	public void MostrarLibros(){
		for(Libro l: getLibros()){
    		Main.out.println(l);
    	}
		Main.out.println("Total de registros: " + libros.size() + ".");  
	}
	
	
}
