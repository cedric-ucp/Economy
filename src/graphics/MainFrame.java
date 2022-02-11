package graphics;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.process.initialisation.LoadSimulation;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Box;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel OperationZone = new JPanel();
		OperationZone.setBounds(10, 10, 199, 543);
		frame.getContentPane().add(OperationZone);
		OperationZone.setLayout(null);
		
		JButton btnSimulationWar = new JButton("Simulation War");
		btnSimulationWar.setBounds(10, 190, 162, 64);
		OperationZone.add(btnSimulationWar);
		
        LoadSimulation loadSimulation = new LoadSimulation () ;
        loadSimulation.buildContinent () ;
		
		Dashbord dashbord = new Dashbord(loadSimulation);
		dashbord.setBackground(Color.LIGHT_GRAY);
		dashbord.setBounds(219, 10, 657, 543);
		frame.getContentPane().add(dashbord);
	}
}
