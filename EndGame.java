package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class EndGame {

	/**
	 * 
	 * @param a - takes in a player
	 * runs the end game
	 */
	public static void endIt(Player a) {

		while (true) {
			// clear canvas
			StdDraw.clear(); 

			// paste background image
			StdDraw.picture(0.5, 0.5, "images/larger.png");


			// paste lives and score defaults
			StdDraw.setPenColor(Color.yellow);
			Font f = new Font("Verdana", Font.BOLD, 70);
			StdDraw.setFont(f);
			StdDraw.text(0.5, 0.7, "GAME OVER");
			
			// your score
			StdDraw.setPenColor(Color.white);
			Font x = new Font("Verdana", Font.BOLD, 30);
			StdDraw.setFont(x);
			StdDraw.text(0.5, 0.5, "your score was: " + a.getScore());
			
			
			// restart?
			Font b = new Font("Verdana", Font.BOLD, 45);
			StdDraw.setFont(b);
			StdDraw.text(0.5, 0.25, "restart? (enter)");

			//
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
				Run.main(null);
			}
			
			// interval for showing
			StdDraw.show(25);
		}

	}
	
	public static void winIt(Player a) {

		while (true) {
			// clear canvas
			StdDraw.clear(); 

			// paste background image
			StdDraw.picture(0.5, 0.5, "images/larger.png");


			// paste lives and score defaults
			StdDraw.setPenColor(Color.yellow);
			Font f = new Font("Verdana", Font.BOLD, 70);
			StdDraw.setFont(f);
			StdDraw.text(0.5, 0.7, "YOU WIN");
			
			// your score
			StdDraw.setPenColor(Color.white);
			Font x = new Font("Verdana", Font.BOLD, 30);
			StdDraw.setFont(x);
			StdDraw.text(0.5, 0.5, "your score was: " + a.getScore());
			
			
			// restart?
			Font b = new Font("Verdana", Font.BOLD, 45);
			StdDraw.setFont(b);
			StdDraw.text(0.5, 0.25, "restart? (enter)");

			//
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
				Run.main(null);
			}
			
			// interval for showing
			StdDraw.show(25);
		}

	}

}
