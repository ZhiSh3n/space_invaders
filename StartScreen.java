package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class StartScreen {

	/**
	 * this is the start screen
	 */
	public static void screen() {
		
		Player player = new Player();
		
		// loop that runs to show the main screen
		while (true) {
			// clear canvas
			StdDraw.clear(); 

			// paste background image
			StdDraw.picture(0.5, 0.5, "images/larger.png");


			// welcome!
			StdDraw.setPenColor(Color.white);
			Font c = new Font("Verdana", Font.BOLD, 70);
			StdDraw.setFont(c);
			StdDraw.text(0.5, 0.8, "SPACE");
			StdDraw.text(0.5, 0.65, "INVADERS");
			 
			Font b = new Font("Verdana", Font.BOLD, 30);
			StdDraw.setFont(b);
			StdDraw.text(0.5, 0.3, "press enter to start");

			//
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
				Game.gameStart(player);
			}
			
			// interval for showing
			StdDraw.show(25);
		}
		
	}
	
}
