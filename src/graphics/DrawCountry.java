package graphics;

import java.awt.Polygon;

public class DrawCountry {
	private Polygon FRANCE =new Polygon();
	private Polygon ALGERIA=new Polygon();
	private Polygon TUNISIA=new Polygon();
	private Polygon CAMEROON=new Polygon();
	private Polygon MOROCCO=new Polygon();
	private Polygon SPAIN=new Polygon();
	private Polygon ITALY=new Polygon();

	public DrawCountry() {
		// initialise FRANCE points
		FRANCE.addPoint(100, 100);
		FRANCE.addPoint(175, 80);
		FRANCE.addPoint(205, 125);
		FRANCE.addPoint(160, 170);
		FRANCE.addPoint(140, 200);
		FRANCE.addPoint(70, 140);
		// initialise FRANCE points
		ALGERIA.addPoint(460, 100);
		ALGERIA.addPoint(510, 80);
		ALGERIA.addPoint(560, 90);
		ALGERIA.addPoint(555, 120);
		ALGERIA.addPoint(545, 130);
		ALGERIA.addPoint(555, 150);
		ALGERIA.addPoint(560, 280);
		ALGERIA.addPoint(580, 305);
		ALGERIA.addPoint(525, 375);
		ALGERIA.addPoint(500, 380);
		ALGERIA.addPoint(495, 360);
		ALGERIA.addPoint(405, 220);
		ALGERIA.addPoint(405, 195);
		ALGERIA.addPoint(420, 180);
		ALGERIA.addPoint(440, 165);
		ALGERIA.addPoint(450, 155);
		ALGERIA.addPoint(475, 145);
		// initialise TUNISIA points
		TUNISIA.addPoint(560, 90);
		TUNISIA.addPoint(575, 85);
		TUNISIA.addPoint(600, 90);
		TUNISIA.addPoint(585, 100);
		TUNISIA.addPoint(605, 115);
		TUNISIA.addPoint(585, 140);
		TUNISIA.addPoint(610, 165);
		TUNISIA.addPoint(580, 180);
		TUNISIA.addPoint(560, 210);
		TUNISIA.addPoint(555, 150);
		TUNISIA.addPoint(545, 130);
		TUNISIA.addPoint(555, 120);
		// initialise CAMEROON points
		CAMEROON.addPoint(205, 125);
		CAMEROON.addPoint(250, 100);
		CAMEROON.addPoint(285, 130);
		CAMEROON.addPoint(265, 180);
		CAMEROON.addPoint(190, 210);
		CAMEROON.addPoint(160, 170);
		// initialise MOROCCO points
		MOROCCO.addPoint(140, 200);
		MOROCCO.addPoint(160, 170);
		MOROCCO.addPoint(190, 210);
		MOROCCO.addPoint(240, 240);
		MOROCCO.addPoint(150, 270);
		MOROCCO.addPoint(95, 300);
		MOROCCO.addPoint(50, 220);
		// initialise SPAIN points
		SPAIN.addPoint(240, 240);
		SPAIN.addPoint(190, 210);
		SPAIN.addPoint(265, 180);
		SPAIN.addPoint(360, 180);
		SPAIN.addPoint(385, 260);
		SPAIN.addPoint(370, 325);
		SPAIN.addPoint(315, 310);
		SPAIN.addPoint(250, 350);
		SPAIN.addPoint(220, 300);
		// initialise SPAIN points
		ITALY.addPoint(95, 300);
		ITALY.addPoint(150, 270);
		ITALY.addPoint(240, 240);
		ITALY.addPoint(220, 300);
		ITALY.addPoint(250, 350);
		ITALY.addPoint(200, 405);
		ITALY.addPoint(150, 420);
		ITALY.addPoint(70, 400);
	}

	public Polygon getFRANCE() {
		return FRANCE;
	}

	public Polygon getALGERIA() {
		return ALGERIA;
	}

	public Polygon getTUNISIA() {
		return TUNISIA;
	}

	public Polygon getCAMEROON() {
		return CAMEROON;
	}

	public Polygon getMOROCCO() {
		return MOROCCO;
	}

	public Polygon getSPAIN() {
		return SPAIN;
	}

	public Polygon getITALY() {
		return ITALY;
	}
}
