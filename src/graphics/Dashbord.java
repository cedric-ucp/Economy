package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
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
		loadSimulation.getContinent().getCountries();
		 Map <Config.countryName, Country> countries = loadSimulation.getContinent ().getCountries () ;
	        System.out.println("taille dico : " + countries.size());
	        CountryInfo countryInfo ;
	        for (Country country : countries.values ()){
	        	element.paint(country, g);
	        }
	        
		
	}

}
