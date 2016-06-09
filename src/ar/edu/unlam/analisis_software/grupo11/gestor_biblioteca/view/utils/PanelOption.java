package ar.edu.unlam.analisis_software.grupo11.gestor_biblioteca.view.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelOption extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6421483657945768898L;
	private JLabel lblDescripcionOpcion ;
	private Color clrFocusLost;
	private Color clrOnFocus;

	/**
	 * Create the panel.
	 */
	public PanelOption(String pathArchivoImagen, String descripcionOpcion, Color color, Color colorOnFocus) {
		addMouseListener(this);
		this.clrOnFocus=colorOnFocus;
		this.clrFocusLost = color ;
	
		setLayout(new BorderLayout(0, 0));
		this.lblDescripcionOpcion = new JLabel(descripcionOpcion);
		lblDescripcionOpcion.setLabelFor(lblDescripcionOpcion);
		lblDescripcionOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDescripcionOpcion, BorderLayout.SOUTH);
		this.setBackground(color);
		this.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(this.clrOnFocus);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(this.clrFocusLost);
		
	}


}

