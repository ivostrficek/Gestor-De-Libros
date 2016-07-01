package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils;

import java.util.Comparator;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;

public class OrdenarLibrosPorAutor implements Comparator<Libro> {
	
	
	public int compare(Libro l1, Libro l2) {
		
        int res = String.CASE_INSENSITIVE_ORDER.compare(l1.getAutor(), l2.getAutor());
        if (res == 0) {
            res = l1.getAutor().compareTo(l2.getAutor());
        }
        return res;	
	}

}
