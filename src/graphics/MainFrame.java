package graphics;

import java.util.Map;
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
import java.awt.Container;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements Runnable {
	private Element element = new Element();
	private JFrame frame;
	private Map<String, Country> countries;
	private CountryInfo countryInfo;
	private boolean war;
	private Dashbord dashbord;
	private JButton btnSimulationWar;
	private JButton btnSimulationPandimic;

	/**
	 * Launch the application.
	 */
	public MainFrame(String title) {
		super(title);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		Container frame = getContentPane();
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel OperationZone = new JPanel();
		OperationZone.setBounds(10, 10, 199, 543);
		add(OperationZone);
		OperationZone.setLayout(null);

		btnSimulationWar = new JButton("Simulation War");
		String[] countrynames = { "ALGERIA", "CAMEROON", "FRANCE", "ITALY", "MOROCCO", "SPAIN", "TUNISIA" };
		LoadSimulation loadSimulation = new LoadSimulation();
		loadSimulation.buildContinent();
		countries = loadSimulation.getContinent().getCountries();

		btnSimulationWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Config.WAR_WINNER = (String) JOptionPane.showInputDialog(null, "Choise the Winner country",
						"War Simulation", JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[0]);

				Config.WAR_LOSER = (String) JOptionPane.showInputDialog(null, "choise the Loser country",
						"War Simulation", JOptionPane.QUESTION_MESSAGE, null, countrynames, countrynames[1]);
				Config.COUNTER_WAR = 7;
				btnSimulationWar.setVisible(false);
				WarSimulation warSimulation = new WarSimulation(countries.get(Config.WAR_WINNER));
				warSimulation.changeEconomyCountry(false);
				WarSimulation warSimulation2 = new WarSimulation(countries.get(Config.WAR_LOSER));
				warSimulation2.changeEconomyCountry(true);
				Config.WAR = true;
			}
		});

		btnSimulationWar.setBounds(10, 171, 162, 64);
		OperationZone.add(btnSimulationWar);

		btnSimulationPandimic = new JButton("Pandemic Simulation");
		btnSimulationPandimic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirm = JOptionPane.showConfirmDialog(null,
						"WARNING WARNING ! DO YOU REALLY WANNA SPREAD THE VIRUS??", "Pandemic Simulation",
						JOptionPane.OK_OPTION);
				if(confirm==0) {
				Config.Pandemic= true;
				Config.COUNTER_Pandimec = 15;
				for (Country country : countries.values()) {
					PandemicSimulation pandemicSimulation = new PandemicSimulation();
					pandemicSimulation.changeEconomyCountry(country);

					}
				btnSimulationPandimic.setVisible(false);
				}
			}
		});
		btnSimulationPandimic.setBounds(10, 307, 162, 64);
		OperationZone.add(btnSimulationPandimic);

		dashbord = new Dashbord(loadSimulation);
		add(dashbord);

		setVisible(true);
	}

	public void decount() {
		if (Config.COUNTER_WAR != 0) {
			Config.COUNTER_WAR--;
		} else {
			btnSimulationWar.setVisible(true);
			Config.WAR = false;
		}
		if (Config.COUNTER_Pandimec != 0) {
			Config.COUNTER_Pandimec--;
		} else {
			btnSimulationPandimic.setVisible(true);
			Config.Pandemic = false;
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dashbord.repaint();
			decount();
		}

	}

}
