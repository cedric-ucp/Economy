package graphics;

import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.JFreeChartEntity;

import engine.config.Config;
import engine.data.map.Continent;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.screenplay.EconomicImprovement;
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
	private JButton btnImprovment;
	private ChartPanel chartPanel;
//	private JFreeChart chart;
//	private ChartManager chartManager;
	EcoGraphics ecoGraphics;

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
		setBounds(50, 100, 1460, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel OperationZone = new JPanel();
		OperationZone.setBounds(10, 10, 199, 543);
		getContentPane().add(OperationZone);
		OperationZone.setLayout(null);
		
		LoadSimulation loadSimulation = new LoadSimulation();
		loadSimulation.buildContinent();
		Continent continent = loadSimulation.getContinent();
		countries = loadSimulation.getContinent().getCountries();
		EconomicImprovement economicImprovement = new EconomicImprovement(continent);
		for (Country country : countries.values()) {
			economicImprovement.addCountryInvolved(country);
		}
		btnImprovment = new JButton("Improvment");
		String[] improvments = {"Infrastructure Improvement","Inter-country Mutual Help","Trading"};
		btnImprovment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String resultImrpovment = (String) JOptionPane.showInputDialog(null, "Choise the economic imrovmemnt",
						"Economic imrovment", JOptionPane.QUESTION_MESSAGE, null, improvments, improvments[0]);
				switch (resultImrpovment) {
				case "Infrastructure Improvement":
					economicImprovement.infrastructureImprovement();
					break;
				case  "Inter-country Mutual Help":
					economicImprovement.aidBetweenCountries();
					break;
				case "Trading":
					economicImprovement.countryTrade();
					break;
					
				default:
					
					break;
				}				
			}
		});

		btnImprovment.setBounds(10, 71, 162, 64);
		OperationZone.add(btnImprovment);
		
		btnSimulationWar = new JButton("Simulation War");
		String[] countrynames = { "ALGERIA", "CAMEROON", "FRANCE", "ITALY", "MOROCCO", "SPAIN", "TUNISIA" };


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

		btnSimulationWar.setBounds(10, 190, 162, 64);
		OperationZone.add(btnSimulationWar);
	
		ecoGraphics = new EcoGraphics(loadSimulation);
		getContentPane().add(ecoGraphics);
		ecoGraphics.setVisible(true);
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
		getContentPane().add(dashbord);
		

		
//		ChartManager chartManager = new ChartManager(loadSimulation); 
//		chart = chartManager.getPibBar();
//		chartPanel = new ChartPanel(chart);
//		
//		
//		getContentPane().add(chartPanel);
//		chartPanel.setBounds(850, 10,300, 300);
		
		//chartPanel.setVisible(true);


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
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			ecoGraphics.update();
			ecoGraphics.repaint();
			dashbord.repaint();
			decount();
		}

	}
}
