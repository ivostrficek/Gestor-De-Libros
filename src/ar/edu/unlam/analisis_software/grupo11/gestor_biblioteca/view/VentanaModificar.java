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

public class VentanaModificar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173719083622270259L;
	private JPanel contentPane;
	private JTextField isbnTextField;
	private JTextField tituloTextField;
	private JTextField autorTextField;
	private JTextField editorialTextField;
	private JTextField edicionTextField;
	private JTextField a�oDePublicacionTextField;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaModificar(Libro libro) {
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
		tituloTextField.setBounds(155, 131, 86, 20);
		contentPane.add(tituloTextField);
		tituloTextField.setColumns(10);
		tituloTextField.setText(libro.getTitulo());
		
		autorTextField = new JTextField();
		autorTextField.setBounds(155, 156, 86, 20);
		contentPane.add(autorTextField);
		autorTextField.setColumns(10);
		autorTextField.setText(libro.getAutor());
		
		
		editorialTextField = new JTextField();
		editorialTextField.setBounds(155, 181, 86, 20);
		contentPane.add(editorialTextField);
		editorialTextField.setColumns(10);
		editorialTextField.setText(libro.getEditorial());
		
		edicionTextField = new JTextField();
		edicionTextField.setBounds(155, 206, 86, 20);
		contentPane.add(edicionTextField);
		edicionTextField.setColumns(10);
		edicionTextField.setText(Integer.toString(libro.getEdicion()));
		
		a�oDePublicacionTextField = new JTextField();
		a�oDePublicacionTextField.setBounds(155, 231, 86, 20);
		contentPane.add(a�oDePublicacionTextField);
		a�oDePublicacionTextField.setColumns(10);
		a�oDePublicacionTextField.setText(Integer.toString(libro.getAnno_de_publicacion()));
		
		JButton btnGuardarLibro = new JButton("Guardar libro");
		btnGuardarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer edicion = null;
				Integer anio_publicacion = null;
				String mensaje = "";
				try{
					edicion = Integer.parseInt(edicionTextField.getText());
				}
				catch(Exception e){
					e.printStackTrace();
					mensaje = mensaje.concat("-Debe ingresar un numero entero en el campo 'edici�n'\n");		
				}
				try{
					anio_publicacion = Integer.parseInt(a�oDePublicacionTextField.getText());
				}
				catch(Exception e){
					e.printStackTrace();
					mensaje = mensaje.concat("-Debe ingresar un numero entero en el campo 'A�o de publicacion'\n");
				}
				try{
					Libro libro = new Libro(isbnTextField.getText(),tituloTextField.getText(), autorTextField.getText(), editorialTextField.getText(),Integer.parseInt(edicionTextField.getText()),Integer.parseInt(a�oDePublicacionTextField.getText()));
					Repositorio.ModificarLibro(libro);
					int answer = JOptionPane.showConfirmDialog(null, "�Desea modificar otro libro?","", JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.OK_OPTION){
						VentanaIngresoISBN modificar = new VentanaIngresoISBN(2);
						modificar.setVisible(true);
						dispose();
					}
					if(answer == JOptionPane.NO_OPTION){
						GestorVista gestor = new GestorVista();
						gestor.frame.setVisible(true);
						dispose();
					}
				}
				catch(Exception e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, mensaje);
				}
				
			}
		});
		btnGuardarLibro.setBounds(127, 292, 171, 23);
		contentPane.add(btnGuardarLibro);
		
		JButton btnIrAMen = new JButton("Ir a men\u00FA");
		btnIrAMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorVista gestor = new GestorVista();
				gestor.frame.setVisible(true);
				dispose();
			}
		});
		btnIrAMen.setBounds(311, 363, 89, 23);
		contentPane.add(btnIrAMen);
		
		JLabel lblAltaDeLibros = new JLabel("Modificaci�n de libros");
		lblAltaDeLibros.setFont(new Font("Traditional Arabic", Font.PLAIN, 37));
		lblAltaDeLibros.setBounds(62, 23, 365, 50);
		contentPane.add(lblAltaDeLibros);
	}

	protected void blanquearCampos() {
		isbnTextField.setText("");
		tituloTextField.setText("");
		autorTextField.setText("");
		editorialTextField.setText("");
		edicionTextField.setText("");
		a�oDePublicacionTextField.setText("");
		
	}

}


