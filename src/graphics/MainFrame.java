package graphics;

import java.awt.EventQueue;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.screenplay.WarSimulation;
import engine.process.initialisation.LoadSimulation;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private Map<Config.countryName, Country> countries;
	private CountryInfo countryInfo;

	/**
	 * Launch the application.
	 */
	public static void main(java.lang.String[] args) {
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
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel OperationZone = new JPanel();
		OperationZone.setBounds(10, 10, 199, 543);
		frame.getContentPane().add(OperationZone);
		OperationZone.setLayout(null);

		JButton btnSimulationWar = new JButton("Simulation War");
		java.lang.String[] countrynames = { "FRANCE", "ALGERIA", "MOROCCO", "CAMEROON" };
		btnSimulationWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.lang.String c1 = (java.lang.String) JOptionPane.showInputDialog(null, "choise the first country", "War Simulation",
						JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[1]);
				java.lang.String c2 = (java.lang.String) JOptionPane.showInputDialog(null, "choise the first country", "War Simulation",
						JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[2]);
				
				WarSimulation warSimulation = new WarSimulation(countries.get(c1));
				warSimulation.changeEconomyCountry(false);
				WarSimulation warSimulation2 = new WarSimulation(countries.get(c2));
				warSimulation2.changeEconomyCountry(true);

			}
		});
		btnSimulationWar.setBounds(10, 190, 162, 64);
		OperationZone.add(btnSimulationWar);

		LoadSimulation loadSimulation = new LoadSimulation();
		loadSimulation.buildContinent();

		Dashbord dashbord = new Dashbord(loadSimulation);
		dashbord.setBackground(Color.LIGHT_GRAY);
		dashbord.setBounds(219, 10, 657, 543);
		frame.getContentPane().add(dashbord);
	}
}
