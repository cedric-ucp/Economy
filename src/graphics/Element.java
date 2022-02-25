package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Polygon;

import java.io.IOException;


public class Element {
	private DrawCountry drawCountry = new DrawCountry();
	private Font bigfont = new Font("countrynames", Font.BOLD, 16);
	private Font smallFont = new Font("countrynames", Font.BOLD, 14);
	private Font verySmallFont = new Font("countrynames", Font.BOLD, 12);


	public void paintFrance(Graphics g) {
		Polygon p = drawCountry.getFRANCE();
		g.fillPolygon(p);
		g.setFont(bigfont);
		g.setColor(Color.white);
		g.drawString("FRANCE", 110, 130);
	}

	public void paintCameroon(Graphics g) {
		Polygon p = drawCountry.getCAMEROON();
		g.setColor(Color.green);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(smallFont);
		g.drawString("CAMEROON", 185, 160);
	}

	public void paintMorocco(Graphics g) {
		Polygon p = drawCountry.getMOROCCO();

		g.setColor(Color.gray);
		g.fillPolygon(p);
		g.setColor(Color.white);
		g.setFont(bigfont);
		g.drawString("MOROCCO", 100, 240);
	}

	public void paintSpain(Graphics g) {
		Polygon p = drawCountry.getSPAIN();
		g.setColor(Color.red);
		g.fillPolygon(p);
		g.setColor(Color.white);
		g.setFont(bigfont);
		g.drawString("SPAIN", 270, 265);
	}

	public void paintItaly(Graphics g) {
		Polygon p = drawCountry.getITALY();

		g.setColor(Color.yellow);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawString("ITALY", 130, 340);
	}

	public void paintAlgeria(Graphics g) throws IOException {
		Polygon p = drawCountry.getALGERIA();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawString("ALGERIA", 460, 230);
	}

	public void paintTunisia(Graphics g) {
		Polygon p = drawCountry.getTUNISIA();

		g.setColor(Color.orange);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(verySmallFont);
		g.drawString("TUNISIA", 550, 130);
	}
}
