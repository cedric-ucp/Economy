package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import engine.data.map.Country;

public class Element {
	public void paint(Country c ,Graphics g) {
		switch (c.getCountryName().name()) {
		case "FRANCE":
				g.setColor(Color.blue);
		      g.fillRect (50, 50, 200, 200);
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName().name(), 125, 150);
		      
			break;
		case "CAMEROON":
			g.setColor(Color.red);  
			g.fillRect (250, 50, 200, 200);
		      
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName().name(), 325, 150);
		      break;
		case "MOROCCO":
			g.setColor(Color.green);
		      g.fillRect (50, 250, 200, 200);
		 
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName().name(), 125, 350);
			break;
		case "CONGO":
			g.setColor(Color.yellow);
		      g.fillRect (250, 250, 200, 200);
		      g.setColor(Color.black);
		      g.drawString(c.getCountryName().name(), 325, 350);
			break;
		default:
			break;
		}

	}

}
