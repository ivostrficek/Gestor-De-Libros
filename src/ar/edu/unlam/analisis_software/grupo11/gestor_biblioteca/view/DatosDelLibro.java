package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.DatosLibro;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosDelLibro extends JFrame {

	private JPanel contentPane;
	private DatosLibro panelDatosDelLibro;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosDelLibro frame = new DatosDelLibro();
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
	public DatosDelLibro() {
		initFrame();
		addAllEvents();
	}

	private void addAllEvents() {
	
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Sarasa", "Alerta", JOptionPane.YES_NO_OPTION);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option=JOptionPane.showConfirmDialog(null, "Esta seguro que quiere salir. No se realizara modificacion alguna sobre el listado de libros ni sus datos", "Alerta", JOptionPane.YES_NO_OPTION);
				if(option==JOptionPane.YES_OPTION){
					DatosDelLibro.this.salir();
				}
			}
		});
		
	}

	protected void salir() {
		this.dispose();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 723);
		
		agregarContentPane();
		agregarPanelDatosLibro();
		agregarBotonAceptar();
		agregarBotonCancelar();
	}
	
	
	
	private void agregarContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void agregarBotonCancelar() {
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(678, 580, 117, 25);
		contentPane.add(btnCancelar);
	}

	private void agregarBotonAceptar() {
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(412, 580, 117, 25);
		contentPane.add(btnAceptar);
		
	}

	private void agregarPanelDatosLibro(){
		panelDatosDelLibro = new DatosLibro();
		panelDatosDelLibro.setBounds(323, 12, 590, 424);
		contentPane.add(panelDatosDelLibro);
	}
}
