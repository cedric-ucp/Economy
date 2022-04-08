package main.java.graphics;

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
import java.util.Map;
import main.java.graphics.Dashbord ;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.screenplay.PandemicSimulation;
import engine.process.features.screenplay.WarSimulation;
import engine.process.initialisation.LoadSimulation;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private Map<String, Country> countries;
	private CountryInfo countryInfo;
	private String winner ;
	private String loser ;
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
		frame.setTitle("ECO+");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel OperationZone = new JPanel();
		OperationZone.setBounds(10, 10, 199, 543);
		frame.getContentPane().add(OperationZone);
		OperationZone.setLayout(null);

		JButton btnSimulationWar = new JButton("Simulation War");
		String[] countrynames = { "FRANCE", "ALGERIA", "MOROCCO", "CAMEROON" };
		LoadSimulation loadSimulation = new LoadSimulation();
		loadSimulation.buildContinent();
		countries = loadSimulation.getContinent().getCountries();
		
		btnSimulationWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winner = (String) JOptionPane.showInputDialog(null, "Choise the Winner country", "War Simulation",
						JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[1]);
				loser = (String) JOptionPane.showInputDialog(null, "choise the Loser country", "War Simulation",
						JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[2]);
				WarSimulation warSimulation = new WarSimulation(countries.get(winner));
				warSimulation.changeEconomyCountry(false);
				WarSimulation warSimulation2 = new WarSimulation(countries.get(loser));
				warSimulation2.changeEconomyCountry(true);
//				element.paintWar(g);
			}
		});

		btnSimulationWar.setBounds(10, 171, 162, 64);
		OperationZone.add(btnSimulationWar);

		JButton btnSimulationPandimic = new JButton("Pandemic Simulation");
		btnSimulationPandimic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm= JOptionPane.showConfirmDialog(null, "WARNING WARNING ! DO YOU REALLY WANNA SPREAD THE VIRUS??", "Pandemic Simulation",JOptionPane.OK_OPTION);
				for (Country country : countries.values ()){
					PandemicSimulation pandemicSimulation = new PandemicSimulation () ;
					pandemicSimulation.changeEconomyCountry (country) ;
				}
			}
		});
		btnSimulationPandimic.setBounds(10, 307, 162, 64);
		OperationZone.add(btnSimulationPandimic);

		Dashbord dashbord = new  Dashbord(loadSimulation);
		frame.getContentPane().add(dashbord);
	}
	public String getWinner() {
		return winner;
	}
	public String getLoser() {
		return loser;
	}

}
