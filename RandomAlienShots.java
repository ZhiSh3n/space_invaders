package lab10;

import java.awt.Color;

public class RandomAlienShots {
	
	/**
	 * 
	 * @param a - alien group
	 * @param b - bullet group
	 * @param c - a time interval
	 * simulate random bullet shots of aliens
	 */
	public static void run(AlienGroup a, BulletGroup b, long c) {
		for (int w = 0; w < 3; w++) {
			for (int y = 0; y < 8; y++) {
				if (a.getAlien(w, y).isNotDead() == true) {
					if (Math.random() < 0.001) {
						if ((System.currentTimeMillis() - c) > 500) {
							b.addBullet(new Bullet(a.getAlien(w, y).XCoordinates, a.getAlien(w, y).YCoordinates, Color.white));
							c = System.currentTimeMillis();
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param a - bullet group
	 * draw the random bullets
	 */
	public static void draw(BulletGroup a) {
		for (int g = 0; g < a.getSize(); g++) {
			a.getBullet(g).draw();
		}
	}

}
