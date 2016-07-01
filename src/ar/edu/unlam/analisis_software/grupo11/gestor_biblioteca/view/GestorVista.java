package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.PanelOption;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestorVista {

	public JFrame frame;

	private PanelOption pnlOptionAltaLibro;
	private PanelOption pnlOptionModificarLibro;
	private PanelOption pnlOptionEliminarLibro;
	private PanelOption pnlOptionConsultas;
	private PanelOption pnlOptionOrdenarRegistros;
	private PanelOption pnlOptionListarRegistros;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorVista window = new GestorVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestorVista() {
		initialize();
		this.inicializarPanelesDeOpciones();
		this.addPanelToFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestor de Libros");
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1235, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorVista.this.cerrarVentana();
			}
		});
		btnSalir.setBounds(568, 619, 117, 25);
		frame.getContentPane().add(btnSalir);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GestorVista.this.cerrarVentana();
				
			}
		});	
		
	}
	

	private void addPanelToFrame() {
		frame.getContentPane().add(this.pnlOptionAltaLibro);
		frame.getContentPane().add(this.pnlOptionConsultas);
		frame.getContentPane().add(this.pnlOptionEliminarLibro);
		frame.getContentPane().add(this.pnlOptionListarRegistros);
		frame.getContentPane().add(this.pnlOptionModificarLibro);
		frame.getContentPane().add(this.pnlOptionOrdenarRegistros);
		
		
	}

	public void inicializarPanelesDeOpciones(){
		//Este es el color que va a utilizar en los paneles de las opciones.
		Color color = new Color(1, 223, 1);
		Color colorOnFocus= new Color(195, 198, 195);
		
		
		this.pnlOptionAltaLibro = new PanelOption("", "Altas de libros", color,colorOnFocus );
		pnlOptionAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAlta ventana = new VentanaAlta();
				ventana.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionAltaLibro.setBounds(168, 78, 229, 170);
		
		this.pnlOptionConsultas = new PanelOption("", "Consultar libro",color,colorOnFocus);
		pnlOptionConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN consulta = new VentanaIngresoISBN(1);
				consulta.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionConsultas.setBounds(168, 355, 229, 170);
		
		this.pnlOptionEliminarLibro = new PanelOption("", "Eliminar libro", color,colorOnFocus);
		pnlOptionEliminarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN eliminar = new VentanaIngresoISBN(3);
				eliminar.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionEliminarLibro.setBounds(926, 355, 229, 170);
		
		this.pnlOptionListarRegistros = new PanelOption("", "Listar registros", color,colorOnFocus);
		pnlOptionListarRegistros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		this.pnlOptionListarRegistros.setBounds(524, 355, 229, 170);
		
		this.pnlOptionModificarLibro = new PanelOption("", "Modificar libro", color,colorOnFocus);
		pnlOptionModificarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN modificacion = new VentanaIngresoISBN(2);
				modificacion.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionModificarLibro.setBounds(524, 78, 229, 170);
		
		this.pnlOptionOrdenarRegistros = new PanelOption("", "Ordenar registros", color,colorOnFocus);
		this.pnlOptionOrdenarRegistros.setBounds(926, 78, 229, 170);
		
		
	}
	
	
	protected void cerrarVentana() {
		Integer respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicacion?");
		if(respuesta.intValue() == JOptionPane.OK_OPTION){
			GestorVista.this.frame.dispose();
		}
	}
	
	
}


