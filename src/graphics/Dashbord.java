package graphics;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.initialisation.LoadSimulation;

public class Dashbord extends JPanel {
	/**
	 * 
	 */
	private BufferedImage image;
	private DrawCountry drawCountry = new DrawCountry();
	private CountryInfo countryInfo;
	private MainFrame frame;
	private static final long serialVersionUID = 1L;
	private Element element = new Element();
	Map<String, Country> countries;
	Polygon france = drawCountry.getFRANCE();
	Polygon algeria = drawCountry.getALGERIA();
	Polygon tunisia = drawCountry.getTUNISIA();
	Polygon morocco = drawCountry.getMOROCCO();
	Polygon cameroon = drawCountry.getCAMEROON();
	Polygon spain = drawCountry.getSPAIN();
	Polygon italy = drawCountry.getITALY();

	/**
	 * Create the panel.
	 * 
	 * @param loadSimulation
	 */

	public Dashbord(LoadSimulation loadSimulation) {
		this.countries = loadSimulation.getContinent().getCountries();
		setBackground(new Color(153, 204, 255));
		setBounds(190, 10, 630, 600);
		setLayout(null);
		setToolTipText("");
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (france.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("FRANCE"));
					int confirm = JOptionPane.showConfirmDialog(null,
							countryInfo, "France",
							JOptionPane.OK_OPTION);
				}

				if (algeria.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("ALGERIA"));
					JOptionPane.showMessageDialog(null,
							countryInfo.toString(), "Algeria",
							JOptionPane.CLOSED_OPTION);
				}
				if (tunisia.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("TUNISIA"));
					JOptionPane.showMessageDialog(null,
							countryInfo, "Tunisia",
							JOptionPane.CLOSED_OPTION);
				}
				if (morocco.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("MOROCCO"));
					JOptionPane.showMessageDialog(null,
							countryInfo, "Morocco",
							JOptionPane.CLOSED_OPTION);
				}
				if (cameroon.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("CAMEROON"));
					JOptionPane.showMessageDialog(null,
							countryInfo, "Cameroon",
							JOptionPane.CLOSED_OPTION);
				}
				if (spain.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("SPAIN"));
					JOptionPane.showMessageDialog(null,
							countryInfo, "Spain",
							JOptionPane.CLOSED_OPTION);
				}
				if (italy.contains(getMousePosition())) {
					countryInfo = new CountryInfo(countries.get("ITALY"));
					JOptionPane.showMessageDialog(null,
							countryInfo, "Italy",
							JOptionPane.INFORMATION_MESSAGE);
					
					
				}
				
			}
		});
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			image = ImageIO.read(new File("C:\\Users\\kakif\\git\\Economy\\src\\engine\\config\\Compass.png"));
		} catch (IOException ex) {
			// handle exception...
		}
		g.drawImage(image, 530, 430, this);
		try {
			element.paintAlgeria(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.paintFrance(g);
		element.paintCameroon(g);
		element.paintMorocco(g);
		element.paintSpain(g);
		element.paintItaly(g);
		element.paintTunisia(g);
		if(Config.WAR) {
			element.paintWar(g, Config.WAR_WINNER,Config.WAR_LOSER);
		}
		if(Config.Pandemic) {
			element.paintPandimic(g);
			System.out.println("PANDIMICC");
		}
	}
	
	@Override
	public String getToolTipText(MouseEvent event) {

		if (france.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("FRANCE"));
			return countryInfo.toString();
		}
		if (algeria.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("ALGERIA"));
			return countryInfo.toString();
		}
		if (tunisia.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("TUNISIA"));
			return countryInfo.toString();
		}
		if (morocco.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("MOROCCO"));
			return countryInfo.toString();
		}
		if (cameroon.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("CAMEROON"));
			return countryInfo.toString();
		}
		if (spain.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("SPAIN"));
			return countryInfo.toString();
		}
		if (italy.contains(getMousePosition())) {
			countryInfo = new CountryInfo(countries.get("ITALY"));
			return countryInfo.toString();
		}
		

		return null;
	}

}
