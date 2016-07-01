package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils;

import java.util.Comparator;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;

public class OrdenarLibrosPorTitulo implements Comparator<Libro> {


	public int compare(Libro l1, Libro l2) {
		
//		if(l1.getTitulo().compareTo(l2.getTitulo()) > 0)
//			return 1;
//		else 
//			if (l1.getTitulo().compareTo(l2.getTitulo()) < 0)
//				return -1;
//			else
//				return 0;	
        int res = String.CASE_INSENSITIVE_ORDER.compare(l1.getTitulo(), l2.getTitulo());
        if (res == 0) {
            res = l1.getTitulo().compareTo(l2.getTitulo());
        }
        return res;
	}

}
