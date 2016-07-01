package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils.PanelOption;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GestorVista {

	public JFrame frame;

	private PanelOption pnlOptionAltaLibro;
	private PanelOption pnlOptionModificarLibro;
	private PanelOption pnlOptionEliminarLibro;
	private PanelOption pnlOptionConsultas;
	private PanelOption pnlOptionOrdenarRegistros;
	private PanelOption pnlOptionListarRegistros;
	private JLabel lblBookMaster;
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
		frame.setTitle("Book Master 2000");
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1235, 723);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorVista.this.cerrarVentana();
			}
		});
		btnSalir.setBounds(571, 619, 117, 25);
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
//		frame.getContentPane().add(this.pnlOptionOrdenarRegistros);
		
		lblBookMaster = new JLabel("Book Master 2000");
		lblBookMaster.setFont(new Font("Traditional Arabic", Font.PLAIN, 41));
		lblBookMaster.setBounds(495, 11, 340, 103);
		frame.getContentPane().add(lblBookMaster);
		
		
	}

	public void inicializarPanelesDeOpciones(){
		//Este es el color que va a utilizar en los paneles de las opciones.
		Color color = new Color(1, 223, 1);
		Color colorOnFocus= new Color(195, 198, 195);
		
		ImageIcon image2 = new ImageIcon("addbook.jpg");
		JLabel imagenAgregar = new JLabel("", image2, JLabel.CENTER);
		
		
		this.pnlOptionAltaLibro = new PanelOption("", "Altas de libros", color,colorOnFocus );
		pnlOptionAltaLibro.add(imagenAgregar);
		pnlOptionAltaLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAlta ventana = new VentanaAlta();
				ventana.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionAltaLibro.setBounds(167, 119, 229, 181);
		
		ImageIcon image4 = new ImageIcon("consultar3.jpg");
		JLabel imagenConsultar = new JLabel("", image4, JLabel.CENTER);
		
		this.pnlOptionConsultas = new PanelOption("", "Consultar libro",color,colorOnFocus);
		pnlOptionConsultas.add(imagenConsultar);
		pnlOptionConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN consulta = new VentanaIngresoISBN(1);
				consulta.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionConsultas.setBounds(358, 355, 229, 170);
		
		ImageIcon image5 = new ImageIcon("eliminar3.jpg");
		JLabel imagenEliminar = new JLabel("", image5, JLabel.CENTER);
		
		this.pnlOptionEliminarLibro = new PanelOption("", "Eliminar libro", color,colorOnFocus);
		pnlOptionEliminarLibro.add(imagenEliminar);
		pnlOptionEliminarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN eliminar = new VentanaIngresoISBN(3);
				eliminar.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionEliminarLibro.setBounds(939, 130, 229, 170);
		
		ImageIcon image = new ImageIcon("libros.jpg");
		JLabel imagenListar = new JLabel("", image, JLabel.CENTER);
		
		this.pnlOptionListarRegistros = new PanelOption("", "Listar registros", color,colorOnFocus);
		pnlOptionListarRegistros.add(imagenListar);
		pnlOptionListarRegistros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaRegistros registros = new VentanaRegistros();
				registros.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionListarRegistros.setBounds(761, 355, 229, 170);
		
		ImageIcon image3 = new ImageIcon("editando3.jpg");
		JLabel imagenModificar = new JLabel("", image3, JLabel.CENTER);
		
		this.pnlOptionModificarLibro = new PanelOption("", "Modificar libro", color,colorOnFocus);
		pnlOptionModificarLibro.add(imagenModificar);
		pnlOptionModificarLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaIngresoISBN modificacion = new VentanaIngresoISBN(2);
				modificacion.setVisible(true);
				frame.dispose();
			}
		});
		this.pnlOptionModificarLibro.setBounds(524, 130, 229, 170);
		
//		this.pnlOptionOrdenarRegistros = new PanelOption("", "Ordenar registros", color,colorOnFocus);
//		this.pnlOptionOrdenarRegistros.setBounds(926, 78, 229, 170);
		
		
	}
	
	
	protected void cerrarVentana() {
		Integer respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la aplicacion?");
		if(respuesta.intValue() == JOptionPane.OK_OPTION){
			GestorVista.this.frame.dispose();
		}
	}
	
	
}


