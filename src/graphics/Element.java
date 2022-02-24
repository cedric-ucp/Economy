package graphics;

import java.awt.Color;
import java.awt.Graphics;

import engine.data.map.Country;

public class Element {
//		public void paint(Map<Config.countryName ,Country> countries ,Graphics g) {
			public void paint(Country c ,Graphics g) {
			//		int x= 50;
//		int y=50;
//		int i = 0 ;
//		for(Country country : countries.values()) {
//				g.setColor(Color.blue);
//				if (i % 2 == 0) {
//					g.fillRect (x, y, 200, 200) ;
//		      g.setColor(Color.black);
//		      g.drawString(country.getCountryName().name(), 125, 150);
//		      x=+;
//		      y=+;
//		}
		
		switch (c.getCountryName ()) {
		case "FRANCE":
				g.setColor(Color.blue);
		      g.fillRect (50, 50, 200, 200);
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName() , 125, 150);
		      
			break;
		case "CAMEROON":
			g.setColor(Color.red);  
			g.fillRect (250, 50, 200, 200);
		      
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName() , 325, 150);
		      break;
		case "MOROCCO":
			g.setColor(Color.green);
		      g.fillRect (50, 250, 200, 200);
		 
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName() , 125, 350);
			break;
		case "ALGERIA":
			g.setColor(Color.yellow);
		      g.fillRect (250, 250, 200, 200);
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName() , 325, 350);
			break;
		default:
			break;
		}

	}

}
