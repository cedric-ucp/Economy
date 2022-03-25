package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Element {
	private DrawCountry drawCountry = new DrawCountry();
	private Font bigfont = new Font("countrynames", Font.BOLD, 16);
	private Font smallFont = new Font("countrynames", Font.BOLD, 14);
	private Font verySmallFont = new Font("countrynames", Font.BOLD, 12);

	private BufferedImage image;
	public void paintFrance(Graphics g) {
		Polygon p = drawCountry.getFRANCE();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.BLACK);
		g.drawPolygon(p);
		g.setFont(bigfont);
		g.drawString("FRANCE", 110, 130);
	}

	public void paintCameroon(Graphics g) {
		Polygon p = drawCountry.getCAMEROON();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(smallFont);
		g.drawPolygon(p);
		g.drawString("CAMEROON", 185, 160);
	}

	public void paintMorocco(Graphics g) {
		Polygon p = drawCountry.getMOROCCO();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawPolygon(p);
		g.drawString("MOROCCO", 100, 240);
	}

	public void paintSpain(Graphics g) {
		Polygon p = drawCountry.getSPAIN();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawPolygon(p);
		g.drawString("SPAIN", 270, 265);
	}

	public void paintItaly(Graphics g) {
		Polygon p = drawCountry.getITALY();

		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawPolygon(p);
		g.drawString("ITALY", 130, 340);
	}

	public void paintAlgeria(Graphics g) throws IOException {
		Polygon p = drawCountry.getALGERIA();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(bigfont);
		g.drawPolygon(p);
		g.drawString("ALGERIA", 460, 230);
	}

	public void paintTunisia(Graphics g) {
		Polygon p = drawCountry.getTUNISIA();
		g.setColor(Color.white);
		g.fillPolygon(p);
		g.setColor(Color.black);
		g.setFont(verySmallFont);
		g.drawPolygon(p);
		g.drawString("TUNISIA", 550, 130);
	}
//	public void paintWar(Graphics g,Polygon winner,Polygon loser) throws InterruptedException {
//        for (int i = 0; i <6; i++) {
//               //Pause for 0.5 seconds
//        		g.setColor(Color.orange);
//        		g.fillPolygon(winner);
//               Thread.sleep(300);
//               g.fillPolygon(loser);
//               //Print a message
//               //System.out.println(importantInfo[i]);
//           }
//        for (int i = 0; i <4; i++) {
//    		g.setColor(Color.green);
//    		g.fillPolygon(winner);
//           Thread.sleep(500);
//////           g.setColor(Color.red);
////           g.fillPolygon(loser);
//        }
//	}
//	public void paintWar(Graphics g) throws InterruptedException {
////		try {
////			image = ImageIO.read(new File("C:\\Users\\kakif\\git\\Economy\\src\\engine\\config\\Compass.png"));
////		} catch (IOException ex) {
////			// handle exception...
////		}
////		for (int i = 0; i <6; i++) {
////               //Pause for 0.5 seconds
////        		g.setColor(Color.orange);
////        		g.fillPolygon(winner);
////               Thread.sleep(300);
////               g.fillPolygon(loser);
////               //Print a message
////               //System.out.println(importantInfo[i]);
////           }
////        for (int i = 0; i <4; i++) {
////    		g.setColor(Color.green);
////    		g.fillPolygon(winner);
////           Thread.sleep(500);
////           g.setColor(Color.red);
////           g.fillPolygon(loser);
////        }
	
}
