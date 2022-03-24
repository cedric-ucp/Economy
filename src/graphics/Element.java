package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.config.Config;

public class Element {
	private DrawCountry drawCountry = new DrawCountry();
	private Font bigfont = new Font("countrynames", Font.BOLD, 16);
	private Font smallFont = new Font("countrynames", Font.BOLD, 14);
	private Font verySmallFont = new Font("countrynames", Font.BOLD, 12);
	private BufferedImage img,imggreen;

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

	public void paintWar(Graphics g, String Country1, String Country2) {
		Polygon c1 = drawCountry.get(Country1);
		Polygon c2 = drawCountry.get(Country2);
		if (Config.COUNTER_WAR % 2 == 0) {
			g.setColor(Color.green);
			g.fillPolygon(c1);
		} else {
			g.setColor(Color.red);
			g.fillPolygon(c2);
		}
	}

	public void paintPandimic(Graphics g) {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/engine/config/virus.png"));
			imggreen = ImageIO.read(getClass().getResourceAsStream("/engine/config/virus2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Config.COUNTER_Pandimec % 5 == 0) {
			g.drawImage(img, 200, 100, null);
			g.drawImage(imggreen, 300, 100, null);
		} else if(Config.COUNTER_Pandimec % 3 == 1) {
			g.drawImage(img, 200, 300, null);
			g.drawImage(imggreen, 300, 150, null);
		}else if(Config.COUNTER_Pandimec % 3 == 2){
			g.drawImage(img, 400, 300, null);
			g.drawImage(imggreen, 150, 150, null);
		}else {
			g.drawImage(img, 500, 100, null);
			g.drawImage(imggreen, 90, 260, null);
		}
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
