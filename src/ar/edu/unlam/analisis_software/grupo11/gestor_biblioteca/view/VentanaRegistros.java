package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Repositorio;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.OrdenarLibrosPorTitulo;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class VentanaRegistros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1502516476520863122L;

	private JPanel contentPane;
	private ArrayList<Libro> libros;
	private JList<Libro> listaLibros;
	private JScrollPane scrollPane;
	private DefaultListModel<Libro> modelTitulos;
	private JTextField añoDePublicacionTextField;
	private JTextField edicionTextField;
	private JTextField editorialTextField;
	private JTextField autorTextField;
	private JTextField tituloTextField;
	private JTextField isbnTextField;
	
	
	
//	public static void main(String[] args) {
//		new VentanaRegistros().setVisible(true);
//	}

	public VentanaRegistros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 484);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelTitulos = new DefaultListModel<Libro>();
		new DefaultListModel<String>();
		listaLibros = new JList<Libro>();
		listaLibros.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		libros = Repositorio.ObtenerLibros();
	

		
//		comboBox = new JComboBox<String>();
//		comboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if(comboBox.getSelectedItem().equals("Autor")){
//					Collections.sort(libros, new OrdenarLibrosPorAutor());
//					for(int i = 0; i < libros.size(); i++){
//						modelAutores.addElement(libros.get(i).getAutor());
//						listaAutores.setModel(modelAutores);
//					}
//				}
//				else
//					if(comboBox.getSelectedItem().equals("Titulo")){
//						Collections.sort(libros, new OrdenarLibrosPorTitulo() );
//						for(int i = 0; i < libros.size(); i++){
//							modelTitulos.addElement(libros.get(i));
//							listaLibros.setModel(modelTitulos);
//						}
//							
//					}
//						
//				
//
//				
//				
//			}
//		});
//		comboBox.setBounds(39, 53, 173, 20);
//		contentPane.add(comboBox);
//		comboBox.addItem("Seleccionar");
//		comboBox.addItem("Autor");
//		comboBox.addItem("Titulo");
		
//		JLabel lblListarLibrosPor = new JLabel("Listar libros por:");
//		lblListarLibrosPor.setBounds(39, 28, 114, 14);
//		contentPane.add(lblListarLibrosPor);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(23, 111, 288, 289);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(listaLibros);
		listaLibros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Libro libroSeleccionado = listaLibros.getSelectedValue();
				isbnTextField.setText(libroSeleccionado.getISBN());
				tituloTextField.setText(libroSeleccionado.getTitulo());
				autorTextField.setText(libroSeleccionado.getAutor());
				edicionTextField.setText(Integer.toString(libroSeleccionado.getEdicion()));
				editorialTextField.setText(libroSeleccionado.getEditorial());
				añoDePublicacionTextField.setText(Integer.toString(libroSeleccionado.getAnno_de_publicacion()));
				
			}
		});

		
		
		JLabel label = new JLabel("T\u00EDtulo");
		label.setBounds(376, 172, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Autor");
		label_1.setBounds(376, 197, 102, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Editorial");
		label_2.setBounds(376, 222, 102, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("ISBN");
		label_3.setBounds(376, 147, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Edici\u00F3n");
		label_4.setBounds(376, 247, 102, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("A\u00F1o de publicaci\u00F3n");
		label_5.setBounds(376, 275, 137, 14);
		contentPane.add(label_5);
		
		añoDePublicacionTextField = new JTextField();
		añoDePublicacionTextField.setText("0");
		añoDePublicacionTextField.setEditable(false);
		añoDePublicacionTextField.setColumns(10);
		añoDePublicacionTextField.setBounds(483, 272, 209, 20);
		contentPane.add(añoDePublicacionTextField);
		
		edicionTextField = new JTextField();
		edicionTextField.setText("0");
		edicionTextField.setEditable(false);
		edicionTextField.setColumns(10);
		edicionTextField.setBounds(483, 247, 209, 20);
		contentPane.add(edicionTextField);
		
		editorialTextField = new JTextField();
		editorialTextField.setText((String) null);
		editorialTextField.setEditable(false);
		editorialTextField.setColumns(10);
		editorialTextField.setBounds(483, 219, 209, 20);
		contentPane.add(editorialTextField);
		
		autorTextField = new JTextField();
		autorTextField.setText((String) null);
		autorTextField.setEditable(false);
		autorTextField.setColumns(10);
		autorTextField.setBounds(483, 194, 209, 20);
		contentPane.add(autorTextField);
		
		tituloTextField = new JTextField();
		tituloTextField.setText((String) null);
		tituloTextField.setEditable(false);
		tituloTextField.setColumns(10);
		tituloTextField.setBounds(483, 169, 209, 20);
		contentPane.add(tituloTextField);
		
		isbnTextField = new JTextField();
		isbnTextField.setText((String) null);
		isbnTextField.setEditable(false);
		isbnTextField.setColumns(10);
		isbnTextField.setBounds(483, 143, 209, 20);
		contentPane.add(isbnTextField);
		
		JLabel lblListadoDeLibros = new JLabel("Listado de libros registrados");
		lblListadoDeLibros.setFont(new Font("Traditional Arabic", Font.PLAIN, 37));
		lblListadoDeLibros.setBounds(165, 22, 481, 91);
		contentPane.add(lblListadoDeLibros);
		
		JButton btnIrAMen = new JButton("Ir a men\u00FA");
		btnIrAMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorVista gestor = new GestorVista();
				gestor.frame.setVisible(true);
				dispose();
			}
		});
		btnIrAMen.setBounds(614, 397, 89, 23);
		contentPane.add(btnIrAMen);
		
//		scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(302, 26, 288, 90);
//		contentPane.add(scrollPane_1);
		
//		listaAutores = new JList<String>();
//		listaAutores.setModel(modelAutores);
//		listaAutores.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				for(int i = 0; i < libros.size(); i++){
//					if(listaAutores.getSelectedValue().equals(libros.get(i).getAutor())){
//						modelTitulos.addElement(libros.get(i));
//						listaLibros.setModel(modelTitulos);
//					}
//				}
//			}
//		});
//		scrollPane_1.setViewportView(listaAutores);
		
		Collections.sort(libros, new OrdenarLibrosPorTitulo() );
		for(int i = 0; i < libros.size(); i++){
			modelTitulos.addElement(libros.get(i));
			listaLibros.setModel(modelTitulos);
		}
		
		
	}
}
