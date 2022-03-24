package graphics;


public class MainTestGUI {

	public static void main(String[] args) {
		MainFrame gameMainGUI = new MainFrame("Aircraft game");
		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}

}
