package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Repositorio;

public class VentanaEliminar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2274695061869179L;
	private JPanel contentPane;
	private JTextField isbnTextField;
	private JTextField tituloTextField;
	private JTextField autorTextField;
	private JTextField editorialTextField;
	private JTextField edicionTextField;
	private JTextField añoDePublicacionTextField;
	/**
	 * Create the frame.
	 */
	public VentanaEliminar(Libro libro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(27, 109, 46, 14);
		contentPane.add(lblIsbn);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(27, 134, 46, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(27, 159, 102, 14);
		contentPane.add(lblAutor);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(27, 184, 102, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblEdicin = new JLabel("Edici\u00F3n");
		lblEdicin.setBounds(27, 209, 102, 14);
		contentPane.add(lblEdicin);
		
		JLabel lblAoDePublicacin = new JLabel("A\u00F1o de publicaci\u00F3n");
		lblAoDePublicacin.setBounds(27, 234, 137, 14);
		contentPane.add(lblAoDePublicacin);
		
		isbnTextField = new JTextField();
		isbnTextField.setEditable(false);
		isbnTextField.setBounds(155, 106, 86, 20);
		contentPane.add(isbnTextField);
		isbnTextField.setColumns(10);
		isbnTextField.setText(libro.getISBN());
		
		tituloTextField = new JTextField();
		tituloTextField.setEditable(false);
		tituloTextField.setBounds(155, 131, 86, 20);
		contentPane.add(tituloTextField);
		tituloTextField.setColumns(10);
		tituloTextField.setText(libro.getTitulo());
		
		autorTextField = new JTextField();
		autorTextField.setEditable(false);
		autorTextField.setBounds(155, 156, 86, 20);
		contentPane.add(autorTextField);
		autorTextField.setColumns(10);
		autorTextField.setText(libro.getAutor());
		
		
		editorialTextField = new JTextField();
		editorialTextField.setEditable(false);
		editorialTextField.setBounds(155, 181, 86, 20);
		contentPane.add(editorialTextField);
		editorialTextField.setColumns(10);
		editorialTextField.setText(libro.getEditorial());
		
		edicionTextField = new JTextField();
		edicionTextField.setEditable(false);
		edicionTextField.setBounds(155, 206, 86, 20);
		contentPane.add(edicionTextField);
		edicionTextField.setColumns(10);
		edicionTextField.setText(Integer.toString(libro.getEdicion()));
		
		añoDePublicacionTextField = new JTextField();
		añoDePublicacionTextField.setEditable(false);
		añoDePublicacionTextField.setBounds(155, 231, 86, 20);
		contentPane.add(añoDePublicacionTextField);
		añoDePublicacionTextField.setColumns(10);
		añoDePublicacionTextField.setText(Integer.toString(libro.getEdicion()));
		
		JButton btnGuardarLibro = new JButton("Eliminar libro");
		btnGuardarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer edicion = null;
				Integer anio_publicacion = null;
				String mensaje = "";

				Integer respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este libro?");
				if(respuesta.intValue() == JOptionPane.OK_OPTION){
					try{
						Repositorio.EliminarLibro(libro);
						int answer = JOptionPane.showConfirmDialog(null, "¿Desea eliminar otro libro?","", JOptionPane.YES_NO_OPTION);
						if(answer == JOptionPane.OK_OPTION){
							VentanaIngresoISBN eliminar = new VentanaIngresoISBN(3);
							eliminar.setVisible(true);
							dispose();
						}
						if(answer == JOptionPane.NO_OPTION){
							GestorVista gestor = new GestorVista();
							gestor.frame.setVisible(true);
							dispose();
						}
	
					}catch(Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, mensaje);
					}	
				}
				
				
			}
		});
		btnGuardarLibro.setBounds(133, 288, 171, 23);
		contentPane.add(btnGuardarLibro);
		
		JButton btnIrAMen = new JButton("Ir a men\u00FA");
		btnIrAMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorVista gestor = new GestorVista();
				gestor.frame.setVisible(true);
				dispose();
			}
		});
		btnIrAMen.setBounds(338, 361, 89, 23);
		contentPane.add(btnIrAMen);
		
		JLabel lblAltaDeLibros = new JLabel("Borrado de libros");
		lblAltaDeLibros.setFont(new Font("Traditional Arabic", Font.PLAIN, 37));
		lblAltaDeLibros.setBounds(74, 24, 273, 50);
		contentPane.add(lblAltaDeLibros);
	}

	protected void blanquearCampos() {
		isbnTextField.setText("");
		tituloTextField.setText("");
		autorTextField.setText("");
		editorialTextField.setText("");
		edicionTextField.setText("");
		añoDePublicacionTextField.setText("");
		
	}

}


