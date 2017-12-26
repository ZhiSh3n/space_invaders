package lab10;

public class Collision {

	/**
	 * 
	 * @param a - take in a bullet group
	 * @param b - take in an alien group
	 * @param c - take in a player 
	 * @param d - take in the player bullet group
	 * check if anything collides
	 */
	public static void collisionCheck(BulletGroup a, AlienGroup b, Player c, BulletGroup d) {

		// if a bullet collides with an alien, delete both the bullet and the alien
		// radius of bullet is 0.01, alien is 0.02, person is 0.04
		// velocity of bullet is 0.03, alien is very slow
		// person moves with 0.05
		
		
		// check alien - bullet collision
		for (int i = 0; i < a.getSize(); i++) {  
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 8; k++) {
					if (a.getSize() != 0) { // if there is SOMETHING in the linkedlist, then we proceed
						if (b.getAlien(j, k).isNotDead() == true) { // if the alien is alive
							if ( (Math.abs(a.getBullet(i).getXCoordinates() - b.getAlien(j, k).XCoordinates) < 0.05) && (Math.abs(a.getBullet(i).getYCoordinates() - b.getAlien(j, k).YCoordinates) < 0.05)) {
									a.removeBullet(i);
									b.getAlien(j, k).setAlive(false);
									c.addScore(10);
							}
						}
					}
				}
			}

		}
		
		// check alien bullet - player collision
		for (int g = 0; g < d.getSize(); g++) {
			if (d.getSize() != 0) {
				if (((Math.abs(d.getBullet(g).getXCoordinates() - c.XCoordinates) < 0.05) && (Math.abs(d.getBullet(g).getYCoordinates() - c.YCoordinates) < 0.05))) {
					//TODO
					// game over!
					d.removeBullet(g);
					c.minusLives(1);
					c.setXCoordinates();
					c.setYCoordinates();
				}
			}
		}
		
		// check alien - player collision
		for (int w = 0; w < 3; w++) {
			for (int x = 0; x < 8; x++) {
				if (((Math.abs(b.getAlien(w, x).XCoordinates - c.XCoordinates) < 0.07) && (Math.abs(b.getAlien(w, x).YCoordinates - c.YCoordinates) < 0.1)) && (b.getAlien(w, x).isNotDead() == true)) {
					//TODO
					// game over!
					c.minusLives(1);
					c.setXCoordinates();
					c.setYCoordinates();
				}
			}
		}

	}
	
}
