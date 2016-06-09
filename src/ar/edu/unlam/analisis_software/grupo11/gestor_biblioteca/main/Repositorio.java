package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

public class Repositorio {
	
	public static void AgregarLibro(Libro l){
		try{
			Connection conn = sqliteConnection.dbConnector();
			String query = "INSERT INTO LIBRO (ISBN,TITULO,AUTOR,EDITORIAL,EDICION,ANO_PUBLICACION) VALUES ('" + l.getISBN() + "','" + l.getTitulo() + "','" + l.getAutor() + "','" + l.getEditorial() + "'," + l.getEdicion() + ",'" + l.getAnno_de_publicacion() + "')";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			JOptionPane.showMessageDialog(null,"Libro guardado correctamente");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		
	}
	
	public static boolean ValidarUsuario(String usuario, String pass){		
		try {
			Connection conn = sqliteConnection.dbConnector();
			String query = "SELECT * from USUARIO where USUARIO = '" + usuario + "' AND PASSWORD = '" + pass + "'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();			
			
			if(!rs.next())
				return false;
			else
				return true;
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
			return false;
		}
	}
}
