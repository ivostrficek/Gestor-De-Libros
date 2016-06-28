package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Repositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaIngresoISBN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1610803207410275203L;
	private JPanel contentPane;
	private JTextField ISBNtextField;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaIngresoISBN(int operacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String etiqueta = "Ingrese el ISBN del libro";
		if(operacion == 2){
			etiqueta = etiqueta.concat(" a modificar");
		}
		if(operacion == 3){
			etiqueta = etiqueta.concat(" a eliminar");
		}
		JLabel lblIngreseElIsbn = new JLabel(etiqueta);
		lblIngreseElIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElIsbn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIngreseElIsbn.setBounds(0, 26, 434, 45);
		contentPane.add(lblIngreseElIsbn);
		
		ISBNtextField = new JTextField();
		ISBNtextField.setBounds(137, 99, 155, 20);
		contentPane.add(ISBNtextField);
		ISBNtextField.setColumns(10);
		
		JButton btnConsultar = new JButton("");
		if(operacion == 1)
			btnConsultar.setText("Consultar");
		else
			btnConsultar.setText("Aceptar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Libro libro = Repositorio.ConsultarLibro(ISBNtextField.getText());
					if(libro == null)
						JOptionPane.showMessageDialog(null,"No existe el libro solicitado");
					else
						switch(operacion){  //Operacion = 1 Consulta; Operacion = 2 Modificacion; Operacion = 3 Eliminar libro.
							case 1:
								ResultadosConsulta resultados = new ResultadosConsulta(libro);
								resultados.setVisible(true);
								dispose();
								break;
							case 2:
								VentanaModificar modificar = new VentanaModificar(libro);
								modificar.setVisible(true);
								dispose();
								break;
							case 3:
								VentanaEliminar eliminar = new VentanaEliminar(libro);
								eliminar.setVisible(true);
								dispose();
								break;
						}
				
			}
		});
		btnConsultar.setBounds(173, 149, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnVolverAMen = new JButton("Volver a men\u00FA");
		btnVolverAMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GestorVista gestor = new GestorVista();
				gestor.frame.setVisible(true);
				dispose();
			}
		});
		btnVolverAMen.setBounds(291, 199, 115, 23);
		contentPane.add(btnVolverAMen);
	}
}
