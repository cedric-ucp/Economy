package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import engine.process.initialisation.LoadSimulation;

public class Dashbord extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Element element = new Element();
	/**
	 * Create the panel.
	 * @param loadSimulation 
	 */
	public LoadSimulation loadSimulation;
	public Dashbord(LoadSimulation loadSimulation) {
		this.loadSimulation= loadSimulation; 
		setBackground(Color.LIGHT_GRAY);
		setBounds(219, 10, 657, 543);
		setLayout(null);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		element.paint(1, g);
		element.paint(2, g);
		element.paint(3, g);
		element.paint(4, g);
		
	}

}
