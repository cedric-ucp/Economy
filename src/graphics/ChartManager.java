package graphics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.JFreeChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.initialisation.LoadSimulation;

/**
 * 
 * @author Ghezil.A
 * @author Jaafar.A
 *
 */

public class ChartManager {
	private HashMap<Character, Integer> CountryPib = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> CountryPopulation = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> CountryDept= new HashMap<Character, Integer>();
	private ArrayList<Integer> heights = new ArrayList<Integer>();
	private CountryInfo countryInfo;
	Map<String, Country> countries;

	/**
	 * Initializes the manager, by creating null value for each node type.
	 */
	public ChartManager(LoadSimulation loadSimulation) {
		this.countries = loadSimulation.getContinent().getCountries();		
		
		CountryPib.put('A',(int)countries.get("ALGERIA").getEconomy().getPib());
		CountryPib.put('C', (int)countries.get("CAMEROON").getEconomy().getPib());
		CountryPib.put('I', (int)countries.get("ITALY").getEconomy().getPib());
		CountryPib.put('F', (int)countries.get("FRANCE").getEconomy().getPib());
		CountryPib.put('M', (int)countries.get("MOROCCO").getEconomy().getPib());
		CountryPib.put('S', (int)countries.get("SPAIN").getEconomy().getPib());
		CountryPib.put('T', (int)countries.get("TUNISIA").getEconomy().getPib());
		

		CountryDept.put('A',(int)countries.get("ALGERIA").getEconomy().getDebt());
		CountryDept.put('C', (int)countries.get("CAMEROON").getEconomy().getDebt());
		CountryDept.put('I', (int)countries.get("ITALY").getEconomy().getDebt());
		CountryDept.put('F', (int)countries.get("FRANCE").getEconomy().getDebt());
		CountryDept.put('M', (int)countries.get("MOROCCO").getEconomy().getDebt());
		CountryDept.put('S', (int)countries.get("SPAIN").getEconomy().getDebt());
		CountryDept.put('T', (int)countries.get("TUNISIA").getEconomy().getDebt());
		
		CountryPopulation.put('A',(int)countries.get("ALGERIA").getPopulation());
		CountryPopulation.put('C', (int)countries.get("CAMEROON").getPopulation());
		CountryPopulation.put('I', (int)countries.get("ITALY").getPopulation());
		CountryPopulation.put('F', (int)countries.get("FRANCE").getPopulation());
		CountryPopulation.put('M', (int)countries.get("MOROCCO").getPopulation());
		CountryPopulation.put('S', (int)countries.get("SPAIN").getPopulation());
		CountryPopulation.put('T', (int)countries.get("TUNISIA").getPopulation());

	}
	public void update() {
		CountryPib.put('A',(int)countries.get("ALGERIA").getEconomy().getPib());
		CountryPib.put('C', (int)countries.get("CAMEROON").getEconomy().getPib());
		CountryPib.put('I', (int)countries.get("ITALY").getEconomy().getPib());
		CountryPib.put('F', (int)countries.get("FRANCE").getEconomy().getPib());
		CountryPib.put('M', (int)countries.get("MOROCCO").getEconomy().getPib());
		CountryPib.put('S', (int)countries.get("SPAIN").getEconomy().getPib());
		CountryPib.put('T', (int)countries.get("TUNISIA").getEconomy().getPib());
		
		
		CountryDept.put('A',(int)countries.get("ALGERIA").getEconomy().getDebt());
		CountryDept.put('C', (int)countries.get("CAMEROON").getEconomy().getDebt());
		CountryDept.put('I', (int)countries.get("ITALY").getEconomy().getDebt());
		CountryDept.put('F', (int)countries.get("FRANCE").getEconomy().getDebt());
		CountryDept.put('M', (int)countries.get("MOROCCO").getEconomy().getDebt());
		CountryDept.put('S', (int)countries.get("SPAIN").getEconomy().getDebt());
		CountryDept.put('T', (int)countries.get("TUNISIA").getEconomy().getDebt());
		
		
		CountryPopulation.put('A',(int)countries.get("ALGERIA").getPopulation());
		CountryPopulation.put('C', (int)countries.get("CAMEROON").getPopulation());
		CountryPopulation.put('I', (int)countries.get("ITALY").getPopulation());
		CountryPopulation.put('F', (int)countries.get("FRANCE").getPopulation());
		CountryPopulation.put('M', (int)countries.get("MOROCCO").getPopulation());
		CountryPopulation.put('S', (int)countries.get("SPAIN").getPopulation());
		CountryPopulation.put('T', (int)countries.get("TUNISIA").getPopulation());
	}
			

	/**
	 * Adds step by step the evolution of the tree height.
	 * 
	 * @param height current tree height
	 */
	public void registerHeightByStep(int height) {
		heights.add(height);
	}

	/**
	 * Generates the node type pie chart.
	 * 
	 * @return the pie chart
	 */
	
	
	public JFreeChart getPibBar() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(CountryPib.get('A'),"PIB", "ALG");
		dataset.setValue(CountryPib.get('C'),"PIB", "CMR");
		dataset.setValue(CountryPib.get('I'),"PIB", "ITL");
		dataset.setValue(CountryPib.get('F'),"PIB", "FRC");
		dataset.setValue(CountryPib.get('M'),"PIB", "MRC");
		dataset.setValue(CountryPib.get('S'),"PIB", "SPN");
		dataset.setValue(CountryPib.get('T'),"PIB", "TNS");
		
		dataset.setValue(CountryDept.get('A'),"dette publique", "ALG");
		dataset.setValue(CountryDept.get('C'),"dette publique", "CMR");
		dataset.setValue(CountryDept.get('I'),"dette publique", "ITL");
		dataset.setValue(CountryDept.get('F'),"dette publique", "FRC");
		dataset.setValue(CountryDept.get('M'),"dette publique", "MRC");
		dataset.setValue(CountryDept.get('S'),"dette publique", "SPN");
		dataset.setValue(CountryDept.get('T'),"dette publique", "TNS");
		
		
		return ChartFactory.createBarChart("Niveau du PIB de chaque Pays", "Pays", "", dataset, PlotOrientation.VERTICAL, true, true, false);
	}
	public JFreeChart getPopulation() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Algeria", CountryPopulation.get('A'));
		dataset.setValue("CAMEROON", CountryPopulation.get('C'));
		dataset.setValue("ITALY", CountryPopulation.get('I'));
		dataset.setValue("FRANCE", CountryPopulation.get('F'));
		dataset.setValue("MOROCCO", CountryPopulation.get('M'));
		dataset.setValue("SPAIN", CountryPopulation.get('S'));
		dataset.setValue("TUNISIA", CountryPopulation.get('T'));
		return ChartFactory.createPieChart("Répartition de la Population", dataset, true, true, false);
	}


}