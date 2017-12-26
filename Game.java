package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class Game {

	/**
	 * 
	 * @param player - take in a player
	 * run the main loop of the game
	 */
	public static void gameStart(Player player) {

		// first, we create our entities
		AlienGroup baddies = new AlienGroup();
		BulletGroup projectiles = new BulletGroup(0.05, 1, 50);
		BulletGroup alienProjectiles = new BulletGroup(-0.03, 0, 200);
		long timer = System.currentTimeMillis();

		while (player.getLivesNumerical() > 0) {

			// clear canvas
			StdDraw.clear(); 

			// draw lives and score
			player.drawIndicators();

			// draw the player 
			player.draw();

			// draw the aliens and then move them
			baddies.draw();
			baddies.moveGroup();

			// listen for a command input for movement from the player
			player.listen();

			// listen for a command input for fire from the player
			player.listenFire(projectiles);

			// draw all the bullets and move them
			// if no bullets are fired, it draws nothing (thanks to linkedlist!)
			player.draw(projectiles);
			projectiles.moveGroup();

			//	random alien shots
			alienProjectiles.randomAlienShot(baddies);
			alienProjectiles.drawAlienShot();
			alienProjectiles.moveGroup();
			
			// TODO kamikaze aliens here

			// cumulative checks of any collisions each loop
			Collision.collisionCheck(projectiles, baddies, player, alienProjectiles);

			// check if all aliens are dead
			baddies.checkGroupDeath(player);

			// interval for showing
			StdDraw.show(25);
		}


		EndGame.endIt(player);


	}

}
