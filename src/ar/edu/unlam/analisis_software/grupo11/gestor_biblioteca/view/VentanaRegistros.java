package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Repositorio;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.OrdenarLibrosPorAutor;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.OrdenarLibrosPorTitulo;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaRegistros extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
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
	private JScrollPane scrollPane_1;
	private JList<String> listaAutores;
	private DefaultListModel<String> modelAutores;
	
	
	public static void main(String[] args) {
		new VentanaRegistros().setVisible(true);
	}

	public VentanaRegistros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		libros = Repositorio.ObtenerLibros();

		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("Autor")){
					Collections.sort(libros, new OrdenarLibrosPorAutor());
					for(int i = 0; i < libros.size(); i++){
						modelAutores.addElement(libros.get(i).getAutor());
						listaAutores.setModel(modelAutores);
					}
				}
				else
					if(comboBox.getSelectedItem().equals("Titulo")){
						Collections.sort(libros, new OrdenarLibrosPorTitulo() );
						for(int i = 0; i < libros.size(); i++){
							modelTitulos.addElement(libros.get(i));
							listaLibros.setModel(modelTitulos);
						}
							
					}
						
				

				
				
			}
		});
		comboBox.setBounds(39, 72, 173, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Seleccionar");
		comboBox.addItem("Autor");
		comboBox.addItem("Titulo");
		
		JLabel lblListarLibrosPor = new JLabel("Listar libros por:");
		lblListarLibrosPor.setBounds(41, 47, 114, 14);
		contentPane.add(lblListarLibrosPor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 144, 288, 117);
		contentPane.add(scrollPane);
		listaLibros = new JList<Libro>();
		scrollPane.setViewportView(listaLibros);
		listaLibros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Libro libroSeleccionado = listaLibros.getSelectedValue();
				isbnTextField.setText(libroSeleccionado.getISBN());
				tituloTextField.setText(libroSeleccionado.getTitulo());
				edicionTextField.setText(Integer.toString(libroSeleccionado.getEdicion()));
				editorialTextField.setText(libroSeleccionado.getEditorial());
				añoDePublicacionTextField.setText(Integer.toString(libroSeleccionado.getAnno_de_publicacion()));
				
			}
		});
		modelTitulos = new DefaultListModel<Libro>();
		modelAutores = new DefaultListModel<String>();
		
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
		label_5.setBounds(376, 272, 137, 14);
		contentPane.add(label_5);
		
		añoDePublicacionTextField = new JTextField();
		añoDePublicacionTextField.setText("0");
		añoDePublicacionTextField.setEditable(false);
		añoDePublicacionTextField.setColumns(10);
		añoDePublicacionTextField.setBounds(504, 269, 86, 20);
		contentPane.add(añoDePublicacionTextField);
		
		edicionTextField = new JTextField();
		edicionTextField.setText("0");
		edicionTextField.setEditable(false);
		edicionTextField.setColumns(10);
		edicionTextField.setBounds(504, 244, 86, 20);
		contentPane.add(edicionTextField);
		
		editorialTextField = new JTextField();
		editorialTextField.setText((String) null);
		editorialTextField.setEditable(false);
		editorialTextField.setColumns(10);
		editorialTextField.setBounds(504, 219, 86, 20);
		contentPane.add(editorialTextField);
		
		autorTextField = new JTextField();
		autorTextField.setText((String) null);
		autorTextField.setEditable(false);
		autorTextField.setColumns(10);
		autorTextField.setBounds(504, 194, 86, 20);
		contentPane.add(autorTextField);
		
		tituloTextField = new JTextField();
		tituloTextField.setText((String) null);
		tituloTextField.setEditable(false);
		tituloTextField.setColumns(10);
		tituloTextField.setBounds(504, 169, 86, 20);
		contentPane.add(tituloTextField);
		
		isbnTextField = new JTextField();
		isbnTextField.setText((String) null);
		isbnTextField.setEditable(false);
		isbnTextField.setColumns(10);
		isbnTextField.setBounds(504, 144, 86, 20);
		contentPane.add(isbnTextField);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(302, 26, 288, 90);
		contentPane.add(scrollPane_1);
		
		listaAutores = new JList<String>();
		listaAutores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				for(int i = 0; i < libros.size(); i++){
					if(listaAutores.getSelectedValue().equals(libros.get(i).getAutor())){
						modelTitulos.addElement(libros.get(i));
					}
				}
			}
		});
		scrollPane_1.setViewportView(listaAutores);
	}
}
