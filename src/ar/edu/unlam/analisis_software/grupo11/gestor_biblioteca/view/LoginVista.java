package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.main.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class LoginVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8147387990784556206L;
	private JPanel contentPane;
	private JTextField textUsuarioLogin;
	private JPasswordField txtPasswordLogin;
	private static LoginVista frame = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginVista();
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
	public LoginVista() {
		setTitle("Login Book Master 2000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 205);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(34, 11, 72, 29);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(10, 59, 96, 29);
		contentPane.add(lblContrasea);
		
		textUsuarioLogin = new JTextField();
		textUsuarioLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(Repositorio.ValidarUsuario(textUsuarioLogin.getText(), txtPasswordLogin.getText())){
						//JOptionPane.showMessageDialog(null, "Usuario logueado correctamente");
//						frame.setVisible(false);
						frame.dispose();
						new GestorVista().frame.setVisible(true);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña es incorrecta");
					}
				}
			}
		});
		textUsuarioLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsuarioLogin.setBounds(110, 13, 147, 25);
		contentPane.add(textUsuarioLogin);
		textUsuarioLogin.setColumns(10);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginVista.frame.dispose();
			}
		});
		buttonCancelar.setBounds(192, 132, 89, 23);
		contentPane.add(buttonCancelar);
		
		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(Repositorio.ValidarUsuario(textUsuarioLogin.getText(), txtPasswordLogin.getText())){
						//JOptionPane.showMessageDialog(null, "Usuario logueado correctamente");
//						frame.setVisible(false);
						frame.dispose();
						new GestorVista().frame.setVisible(true);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña es incorrecta");
					}
				}
			}
		});

		buttonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Repositorio.ValidarUsuario(textUsuarioLogin.getText(), txtPasswordLogin.getText())){
					//JOptionPane.showMessageDialog(null, "Usuario logueado correctamente");
//					frame.setVisible(false);
					frame.dispose();
					new GestorVista().frame.setVisible(true);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña es incorrecta");
				}
			}
		});
		buttonIngresar.setBounds(10, 132, 89, 23);
		contentPane.add(buttonIngresar);
		
		txtPasswordLogin = new JPasswordField();
		txtPasswordLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(Repositorio.ValidarUsuario(textUsuarioLogin.getText(), txtPasswordLogin.getText())){
						//JOptionPane.showMessageDialog(null, "Usuario logueado correctamente");
//						frame.setVisible(false);
						frame.dispose();
						new GestorVista().frame.setVisible(true);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña es incorrecta");
					}
				}
			}
		});
		txtPasswordLogin.setBounds(110, 65, 147, 25);
		contentPane.add(txtPasswordLogin);
	}
}
