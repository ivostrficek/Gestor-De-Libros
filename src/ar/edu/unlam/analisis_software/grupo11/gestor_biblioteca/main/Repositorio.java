package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

public class Repositorio {
	

	
	public static Libro ConsultarLibro(String ISBN){
		try{
			Libro libro;
			Connection conn = sqliteConnection.dbConnector();
			String query = "select * from libro where isbn = \"" + ISBN + "\"";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if(rs.isClosed()){
				return null;
			}
			libro = new Libro(ISBN, rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
			pst.close();
			return libro;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void AgregarLibro(Libro l){
		try{
			Connection conn = sqliteConnection.dbConnector();
			String query = "INSERT INTO LIBRO (ISBN,TITULO,AUTOR,EDITORIAL,EDICION,ANO_PUBLICACION) VALUES ('" + l.getISBN() + "','" + l.getTitulo() + "','" + l.getAutor() + "','" + l.getEditorial() + "'," + l.getEdicion() + ",'" + l.getAnno_de_publicacion() + "')";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Libro guardado correctamente");
			pst.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error: Ya existe un libro en la base de datos con el ISBN ingresado");
			e.printStackTrace();
		}
		
	}
	
	public static void ModificarLibro (Libro l){
		try{
			Connection conn = sqliteConnection.dbConnector();
			String query = "UPDATE LIBRO SET TITULO = \"" + l.getTitulo() + "\", AUTOR = \"" + l.getAutor() + "\", EDITORIAL = \"" + l.getEditorial() + "\", EDICION = " + l.getEdicion() + ", ANO_PUBLICACION = " + l.getAnno_de_publicacion() + " WHERE ISBN = \"" + l.getISBN() + "\"";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Libro modificado correctamente");
			pst.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			e.printStackTrace();
		}
	}
	
	public static void EliminarLibro(Libro l) {
		try{
			Connection conn = sqliteConnection.dbConnector();
			String query = "DELETE FROM LIBRO WHERE ISBN = \"" + l.getISBN() + "\"";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.executeUpdate();
			//ResultSet rs = 
			JOptionPane.showMessageDialog(null,"Libro eliminado correctamente");
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

	public static ArrayList<Libro> ObtenerLibros() {
		try {
			ArrayList<Libro> libros = new ArrayList<Libro>();
			Connection conn = sqliteConnection.dbConnector();
			String query = "SELECT * from LIBRO";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				libros.add(new Libro(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
			pst.close();
			return libros;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}


}
