package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
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
	private DrawCountry drawCountry = new DrawCountry();
	private CountryInfo countryInfo;
	private static final long serialVersionUID = 1L;
	private Element element = new Element();
	Map<String, Country> countries;

	/**
	 * Create the panel.
	 * 
	 * @param loadSimulation
	 */

	public Dashbord(LoadSimulation loadSimulation) {
		this.countries=loadSimulation.getContinent().getCountries();
		setBackground(Color.blue);
		setBounds(219, 10, 630, 543);
		setLayout(null);
		setToolTipText("");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		CountryInfo countryInfo;
//		for (Country country : countries.values()) {
//			element.paint(country, g);
//		}
		element.paintFrance(g);
		element.paintCameroon(g);
		element.paintMorocco(g);
		element.paintSpain(g);
		element.paintItaly(g);
		element.paintAlgeria(g);
		element.paintTunisia(g);
	}

	@Override
	public String getToolTipText(MouseEvent event) {
		Polygon france=drawCountry.getFRANCE();
		Polygon algeria=drawCountry.getALGERIA();
		Polygon tunisia=drawCountry.getTUNISIA();
		Polygon morocco=drawCountry.getMOROCCO();
		Polygon cameroon=drawCountry.getCAMEROON();
		Polygon spain=drawCountry.getSPAIN();
		Polygon italy=drawCountry.getITALY();
		
		if(france.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("FRANCE"));
			return countryInfo.toString();
		}
		if(algeria.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("ALGERIA"));
			return countryInfo.toString();
		}
		if(tunisia.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("TUNISIA"));
			return countryInfo.toString();
		}
		if(morocco.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("MOROCCO"));
			return countryInfo.toString();
		}
		if(cameroon.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("CAMEROON"));
			return countryInfo.toString();
		}
		if(spain.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("SPAIN"));
			return countryInfo.toString();
		}
		if(italy.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("ITALY"));
			return countryInfo.toString();
		}
		
		return null;
	}

}
