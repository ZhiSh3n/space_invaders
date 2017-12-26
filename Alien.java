package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Alien extends Entity implements EntityInterface{ 
	
	private boolean notDead;
	
	/**
	 * 
	 * @param a - the x coordinate of the entity
	 * @param b - the y coordinate of the entity
	 * @param c - a boolean for whether or not the entity is dead
	 */
	public Alien(double a, double b, boolean c) {
		this.notDead = c;
		this.radius = 0.02;
		this.XCoordinates = a;
		this.YCoordinates = b;
		
	}
	
	/**
	 * a draw function for drawing the alien given its coordinates
	 */
	public void Draw() {
		if (this.notDead == true) { // if they are not dead, then we draw them
			StdDraw.picture(this.XCoordinates, this.YCoordinates, "images/invader.png");
			/* IN CASE PICTURE DOESNT LOAD, USE THIS
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.filledCircle(this.XCoordinates, this.YCoordinates, this.radius);
			*/
		}
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
		return this.YCoordinates;
	}

	@Override
	/**
	 * add x coordinate
	 */
	public void setXCoordinates(double value) {
		this.XCoordinates += value;
	}

	@Override
	/**
	 * add y coordinate
	 */
	public void setYCoordinates(double value) {
		this.YCoordinates += value;
	}
	
	/**
	 * return the dead status of the alien
	 * @return
	 */
	public boolean isNotDead() {
		return this.notDead;
	}
	
	/**
	 * set the alien to be alive again
	 * @param a - T/F for alive or dead
	 */
	public void setAlive(boolean a) {
		this.notDead = a;
	}

}
