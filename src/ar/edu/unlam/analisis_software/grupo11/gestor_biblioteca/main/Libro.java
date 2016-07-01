package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;

public class Libro implements Comparable<Libro> {

    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int edicion;
    private int anno_de_publicacion;
    
    public Libro(){
    	
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, int edicion, int anno_de_publicacion) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
		this.anno_de_publicacion = anno_de_publicacion;
	}

	@Override
    public boolean equals(Object libro) {
        return this==libro || (libro instanceof Libro && ISBN.equals(((Libro)libro).ISBN));
    }

    @Override
    public int compareTo(Libro libro) {
        return ISBN.compareTo(libro.ISBN);
    }
    
    @Override
    public String toString() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }
    
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getAnno_de_publicacion() {
        return anno_de_publicacion;
    }
    
    public void setAnno_de_publicacion(int anno_de_publicacion) {
        this.anno_de_publicacion = anno_de_publicacion;
    }
}
