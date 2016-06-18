package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

public class Repositorio {
	
	public static Libro ConsultarLibro(String ISBN){
		try{
			Libro libro;
			Connection conn = sqliteConnection.dbConnector();
			String query = "select * from libro where isbn = " + ISBN;
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			libro = new Libro(ISBN, rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
			pst.close();
			return libro;
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No existe el libro solicitado");
			return null;
		}
	}
	
	public static void AgregarLibro(Libro l){
		try{
			Connection conn = sqliteConnection.dbConnector();
			String query = "INSERT INTO LIBRO (ISBN,TITULO,AUTOR,EDITORIAL,EDICION,ANO_PUBLICACION) VALUES ('" + l.getISBN() + "','" + l.getTitulo() + "','" + l.getAutor() + "','" + l.getEditorial() + "'," + l.getEdicion() + ",'" + l.getAnno_de_publicacion() + "')";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			//ResultSet rs = 
			JOptionPane.showMessageDialog(null,"Libro guardado correctamente");
			pst.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			e.printStackTrace();
		}
		
	}
	
	public static boolean ValidarUsuario(String usuario, String pass){		
		try {
			boolean validado;
			Connection conn = sqliteConnection.dbConnector();
			String query = "SELECT * from USUARIO where USUARIO = '" + usuario + "' AND PASSWORD = '" + pass + "'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();			
			if(!rs.next())
				validado = false;
			else
				validado = true;
			pst.close();
			return validado;
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
			return false;
		}
	}
}
