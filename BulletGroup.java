package lab10;

import java.awt.Color;
import java.util.LinkedList;

public class BulletGroup implements GroupInterface{
	
	private LinkedList<Bullet> bullets;
	private long loop;
	private long loop2;
	private double yVelocity;
	private double border;
	private double perTime;
	
	/**
	 * 
	 * @param y - velocity of a bullet in a bullet group
	 * @param b - the border of the bullet (collision radius)
	 * @param c - the interval of travel
	 */
	public BulletGroup(double y, double b, double c) {
		this.bullets = new LinkedList<Bullet>();
		this.yVelocity = y;
		this.border = b;
		this.perTime = c;
		this.loop = System.currentTimeMillis();
		this.loop2 = System.currentTimeMillis();
	}
	
	/**
	 * move the group
	 */
	public void moveGroup() {
		if ((System.currentTimeMillis() - this.loop) > this.perTime) { // controls per time of bullet
			for (int i = 0; i < bullets.size(); i++) {
				this.bullets.get(i).setYCoordinates(this.yVelocity); // controls distance of bullet per time
					if (this.border < 0.5) {
						if (this.bullets.get(i).YCoordinates < this.border) {
							this.bullets.remove(i);
						}
					}
					if (this.border > 0.5) {
						if (this.bullets.get(i).YCoordinates > this.border) {
							this.bullets.remove(i);
						}
					}
			}
			this.loop = System.currentTimeMillis();
		}
	}
	
	/**
	 * 
	 * @param a - simulate random alien bullets firing
	 */
	public void randomAlienShot(AlienGroup a) {
		for (int w = 0; w < 3; w++) {
			for (int y = 0; y < 8; y++) {
				if (a.getAlien(w, y).isNotDead() == true) {
					if (Math.random() < 0.001) {
						if ((System.currentTimeMillis() - this.loop2) > 500) {
							this.addBullet(new Bullet(a.getAlien(w, y).XCoordinates, a.getAlien(w, y).YCoordinates, Color.white));
							this.loop2 = System.currentTimeMillis();
						}
					}
				}
			}
		}
	}
	
	/**
	 * draw the rando alien shots
	 */
	public void drawAlienShot() {
		for (int g = 0; g < this.getSize(); g++) {
			this.getBullet(g).draw();
		}
	}
	
	/**
	 * return the size of the bullets
	 */
	public int getSize() {
		return this.bullets.size();
	}
	
	/**
	 * return the bullet situated at a in the linked list
	 */
	public Bullet getBullet(int a) {
		return this.bullets.get(a);
	}
	
	/**
	 * add a bullet to position a in the linked list
	 */
	public void addBullet(Bullet a) {
		this.bullets.add(a);
	}
	
	/**
	 * remove the bullet situated at a in the linked list
	 */
	public void removeBullet(int a) {
		this.bullets.remove(a);
	}

}
