package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main;
import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;
	
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ivo_s\\Desktop\\Gestor-De-Libros\\Biblioteca.sqlite");
			//JOptionPane.showMessageDialog(null, "Conexión con la base de datos exitosa!");
			return conn;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
