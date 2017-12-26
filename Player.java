package lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class Player extends Entity implements EntityInterface{

	private int score; // a player has a score
	private int lives; // a player has a set number of lives
	private boolean up, down, left, right; // a player can move in these directions
	private long loop;
	private long loop2;

	/**
	 * create the player
	 */
	public Player() {
		this.score = 0;
		this.lives = 3;
		this.XCoordinates = 0.5;
		this.YCoordinates = 0.15;
		this.radius = 0.04;
		this.loop = System.currentTimeMillis();
		this.loop2 = System.currentTimeMillis();
	}

	/**
	 * draw the player
	 */
	public void draw() {
		StdDraw.picture(this.XCoordinates, this.YCoordinates, "images/player.png");
		
		/* IN CASE PICTURE DOESN"T LOAD, USE THIS
		StdDraw.setPenColor(Color.green);
		StdDraw.filledCircle(this.XCoordinates, this.YCoordinates, this.radius);
		 */
	}

	/**
	 * take in a projectile group and listen for user input for firing bullets
	 */
	public void listenFire(BulletGroup projectiles) {
		if ((System.currentTimeMillis() - this.loop2) > 500) { // reload time
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				projectiles.addBullet(new Bullet(this.XCoordinates, this.YCoordinates, Color.red));
				this.loop2 = System.currentTimeMillis();
			}
		}
	}

	/**
	 * listen for user input for movement
	 */
	public void listen() { // reads key input from the user

		if ((System.currentTimeMillis() - this.loop) > 150) { // reload speed

			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				this.YCoordinates += 0.05;
				this.loop = System.currentTimeMillis();
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				this.YCoordinates -= 0.05;
				this.loop = System.currentTimeMillis();
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				this.XCoordinates -= 0.05;
				this.loop = System.currentTimeMillis();
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				this.XCoordinates += 0.05;
				this.loop = System.currentTimeMillis();
			}
		}
	}

	/**
	 * draw the bullets that a player fires
	 * @param a - bullet group
	 */
	public void draw(BulletGroup a) {
		for (int b = 0; b < a.getSize(); b++) {
			a.getBullet(b).draw();
		}
	}

	/**
	 * draw the lives and score of the player
	 */
	public void drawIndicators() {
		// paste background image
		StdDraw.picture(0.5, 0.5, "images/larger.png");

		// paste lives and score defaults
		StdDraw.setPenColor(Color.white);
		Font f = new Font("Verdana", Font.BOLD, 20);
		StdDraw.setFont(f);
		StdDraw.text(0.07, 0.98, "LIVES:");
		StdDraw.text(0.85,  0.98, "SCORE:");

		// paste lives and score iterators
		StdDraw.setPenColor(Color.yellow);
		StdDraw.text(0.17, 0.98, this.getLives());
		StdDraw.text(0.98,  0.98, this.getScore());
	}

	/**
	 * 
	 * @return - the score of the player
	 */
	public String getScore() {
		return "" + this.score;
	}

	/**
	 * 
	 * @param a - set the player's score to this
	 */
	public void addScore(int a) {
		this.score = this.score + a;
	}

	/**
	 * 
	 * @return - lives of player as a string
	 */
	public String getLives() {
		return "" + this.lives;
	}

	/**
	 * 
	 * @return - lives of player as an int
	 */
	public int getLivesNumerical() {
		return this.lives;
	}

	/**
	 * 
	 * @param a - remove lives by this amount
	 */
	public void minusLives(int a) {
		this.lives -= a;
	}
	
	/**
	 * 
	 * @param a - set lives to this
	 */
	public void setLives(int a) {
		this.lives = a;
	}

	/**
	 * set x coordinates to this
	 */
	public void setXCoordinates() {
		this.XCoordinates = 0.5;
	}

	/**
	 * set y coordinates to this
	 */
	public void setYCoordinates() {
		this.YCoordinates = 0.15;
	}

	@Override
	/**
	 * get x coordinates
	 */
	public double getXCoordinates() {
		return this.XCoordinates;
	}

	@Override
	/**
	 * get y coordinates
	 */
	public double getYCoordinates() {
		// TODO Auto-generated method stub
		return this.YCoordinates;
	}

	@Override
	/**
	 * set x coordinates
	 */
	public void setXCoordinates(double value) {
		this.XCoordinates += value;
	}

	@Override
	/**
	 * set y coordinates
	 */
	public void setYCoordinates(double value) {
		this.YCoordinates += value;
	}

}
