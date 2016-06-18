package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Repositorio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField ISBNtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsulta frame = new VentanaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElIsbn = new JLabel("Ingrese el ISBN del libro");
		lblIngreseElIsbn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIngreseElIsbn.setBounds(83, 60, 284, 45);
		contentPane.add(lblIngreseElIsbn);
		
		ISBNtextField = new JTextField();
		ISBNtextField.setBounds(134, 132, 155, 20);
		contentPane.add(ISBNtextField);
		ISBNtextField.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Libro libro = Repositorio.ConsultarLibro(ISBNtextField.getText());
				ResultadosConsulta resultados = new ResultadosConsulta(libro);
				resultados.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(321, 228, 89, 23);
		contentPane.add(btnConsultar);
	}

}
