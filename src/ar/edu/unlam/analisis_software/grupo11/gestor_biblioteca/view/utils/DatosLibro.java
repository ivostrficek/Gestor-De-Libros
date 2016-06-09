package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils;

import javax.swing.JPanel;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.model.Libro;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DatosLibro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1777878490893646088L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public DatosLibro() {
		setLayout(null);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setBounds(59, 31, 70, 15);
		add(lblISBN);
		
		textField = new JTextField();
		textField.setBounds(216, 29, 114, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(59, 78, 70, 15);
		add(lblTitulo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 76, 347, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(59, 132, 70, 15);
		add(lblAutor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 130, 347, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(59, 194, 70, 15);
		add(lblEditorial);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 192, 347, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAnioDePublicacion = new JLabel("Anio de publicacion:");
		lblAnioDePublicacion.setBounds(59, 265, 148, 15);
		add(lblAnioDePublicacion);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 263, 114, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEdicion = new JLabel("Edicion:");
		lblEdicion.setBounds(59, 324, 70, 15);
		add(lblEdicion);
		
		textField_5 = new JTextField();
		textField_5.setBounds(216, 322, 114, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
	}
	
	public DatosLibro(Libro libro){
		
	}
}
