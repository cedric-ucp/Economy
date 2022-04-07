package graphics;

import java.awt.Color;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.initialisation.LoadSimulation;

public class EcoGraphics extends JPanel {
	private DrawCountry drawCountry = new DrawCountry();
	private CountryInfo countryInfo;
	private ChartPanel chartPanel;
	private ChartPanel chartPanel1;
	
	private ChartManager chartManager ;
	Map<String, Country> countries;
	LoadSimulation loadSimulation;
	private JFreeChart chart;
	private JFreeChart chartPopulation;
	public EcoGraphics(LoadSimulation loadSimulation) {
		this.loadSimulation = loadSimulation;
		this.countries = loadSimulation.getContinent().getCountries();
		setBackground(Color.yellow);
		setBounds(830, 10, 600, 620);
		setLayout(null);
		setToolTipText("");
				
		chartManager = new ChartManager(loadSimulation); 
		chart = chartManager.getPibBar();
		chartPopulation = chartManager.getPopulation();
		
		chartPanel = new ChartPanel(chart);
		chartPanel1 = new ChartPanel(chartPopulation);
		
		
		chartPanel.setChart(chart);
		chartPanel1.setChart(chartPopulation);
		
		
		chartManager.update();
		

		this.add(chartPanel);
		this.add(chartPanel1);
		chartPanel.setBounds(10, 10,580, 300);
		chartPanel1.setBounds(10, 315 ,580, 300);
		
		setVisible(true);
	}
	public void update() {
		chartManager.update();
		chart = chartManager.getPibBar();
		chartPopulation = chartManager.getPopulation();
		chartPanel.setChart(chart);
		chartPanel1.setChart(chartPopulation);
	}

}
