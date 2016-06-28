package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.Libro;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadosConsulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7735383119694098329L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ResultadosConsulta(Libro libro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("ISBN");
		label.setBounds(27, 109, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("T\u00EDtulo");
		label_1.setBounds(27, 134, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Autor");
		label_2.setBounds(27, 159, 102, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Editorial");
		label_3.setBounds(27, 184, 102, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Edici\u00F3n");
		label_4.setBounds(27, 209, 102, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("A\u00F1o de publicaci\u00F3n");
		label_5.setBounds(27, 234, 137, 14);
		panel.add(label_5);
		
		JButton btnRealizarOtraConsulta = new JButton("Realizar otra consulta");
		btnRealizarOtraConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaIngresoISBN consulta = new VentanaIngresoISBN(1);
				consulta.setVisible(true);
				dispose();
			}
		});
		btnRealizarOtraConsulta.setBounds(51, 275, 182, 20);
		panel.add(btnRealizarOtraConsulta);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultados.setFont(new Font("Traditional Arabic", Font.PLAIN, 37));
		lblResultados.setBounds(27, 11, 262, 50);
		panel.add(lblResultados);
		
		JLabel ISBNlabel = new JLabel(libro.getISBN());
		ISBNlabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		ISBNlabel.setBounds(185, 109, 86, 14);
		panel.add(ISBNlabel);
		
		JLabel tituloLabel = new JLabel(libro.getTitulo());
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tituloLabel.setBounds(185, 134, 86, 14);
		panel.add(tituloLabel);
		
		JLabel autorLabel = new JLabel(libro.getAutor());
		autorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		autorLabel.setBounds(185, 159, 86, 14);
		panel.add(autorLabel);
		
		JLabel editorialLabel = new JLabel(libro.getEditorial());
		editorialLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		editorialLabel.setBounds(185, 184, 86, 14);
		panel.add(editorialLabel);
		
		JLabel edicionLabel = new JLabel(Integer.toString(libro.getEdicion()));
		edicionLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		edicionLabel.setBounds(185, 209, 86, 14);
		panel.add(edicionLabel);
		
		JLabel añoLabel = new JLabel(Integer.toString(libro.getAnno_de_publicacion()));
		añoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		añoLabel.setBounds(185, 234, 86, 14);
		panel.add(añoLabel);
		
		JButton btnNewButton = new JButton("Ir a men\u00FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorVista gestor = new GestorVista();
				gestor.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(51, 313, 182, 23);
		panel.add(btnNewButton);
	}
}
