package lab10;

import java.awt.Color;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;

public class Bullet extends Entity implements EntityInterface{

	private long loop;
	private Color color;
	
	/**
	 * 
	 * @param a - x coordinates
	 * @param b - y coordinates
	 * @param c - what color you want a bullet ot be
	 */
	public Bullet(double a, double b, Color c) { // it requires an xCoordinate input (starter is a)
		this.radius = 0.01;
		this.XCoordinates = a;
		this.YCoordinates = b;
		this.color = c;
		this.loop = System.currentTimeMillis();
	}
	
	/**
	 * draw function
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.XCoordinates, this.YCoordinates, this.radius);
	}

	@Override
	/** 
	 * return x coordinates
	 */
	public double getXCoordinates() {
		return this.XCoordinates;
	}

	@Override
	/**
	 * return y coordinates
	 */
	public double getYCoordinates() {
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
