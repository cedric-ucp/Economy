package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
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
	private CountryInfo countryInfo;
	private static final long serialVersionUID = 1L;
	private Element element = new Element();
	public LoadSimulation loadSimulation ;
	Map<Config.countryName, Country> countries;

	/**
	 * Create the panel.
	 * 
	 * @param loadSimulation
	 */

	public Dashbord(LoadSimulation loadSimulation) {
		countries = loadSimulation.getContinent().getCountries();
		this.loadSimulation = loadSimulation;
		setBackground(Color.LIGHT_GRAY);
		setBounds(219, 10, 657, 543);
		setLayout(null);
		setToolTipText("");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		CountryInfo countryInfo;
		for (Country country : countries.values()) {
			element.paint(country, g);
		}
	}

	@Override
	public String getToolTipText(MouseEvent event) {
		Rectangle r1 = new Rectangle(50, 50, 200, 200);
		Rectangle r2 = new Rectangle(250, 50, 200, 200);
		Rectangle r3 = new Rectangle(50, 250, 200, 200);
		Rectangle r4 = new Rectangle(250, 250, 200, 200);
		if (r1.contains(event.getPoint())) {
			for (Country c : countries.values()) {
				if (c.getCountryName().name().equals("FRANCE")) {
					countryInfo = new CountryInfo(c);
					System.out.println(countryInfo);
					return countryInfo.toString();
				}
			}
		}
		if (r2.contains(event.getPoint())) {
			for (Country c : countries.values()) {
				if (c.getCountryName().name().equals("CAMEROON")) {
					countryInfo = new CountryInfo(c);
					System.out.println(countryInfo);
					return countryInfo.toString();
				}
			}
		}
		if (r3.contains(event.getPoint())) {
			for (Country c : countries.values()) {
				if (c.getCountryName().name().equals("MOROCCO")) {
					countryInfo = new CountryInfo(c);
					System.out.println(countryInfo);
					return countryInfo.toString();
				}
			}
		}
		if (r4.contains(event.getPoint())) {
			for (Country c : countries.values()) {
				if (c.getCountryName().name().equals("ALGERIA")) {
					countryInfo = new CountryInfo(c);
					System.out.println(countryInfo);
					return countryInfo.toString();
				}
			}
		}
		return null;
	}

}
