package lab10;

public class AlienGroup {

	private Alien[][] group;
	private double xVelocity;
	private long loop;

	/**
	 * uses the alien class to create a group of aliens
	 */
	public AlienGroup() { 
		this.group = new Alien[3][8];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				this.group[i][j] = new Alien((0.12 + 0.1*j), (0.85-0.1*i), true); // all aliens are initially not dead
			}
		}
		this.xVelocity = 0.01;
		this.loop = System.currentTimeMillis();
	}
	
	/**
	 * draw function
	 */
	public void draw() {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 8; b++) {
				this.getAlien(a, b).Draw();
			}
		}
	}

	/**
	 * 
	 * @param a - out of the group, pick the row
	 * @param b - out of the group, pick the column
	 * @return - return the alien situated at [a][b]
	 */
	public Alien getAlien(int a, int b) { 
		return this.group[a][b];
	}

	/*
	 * every game loop, this method is run once
	 * it serves to move the aliens horizontally and vertically across the game screen
	 * includes rest tick, horizontal velocity, and vertical velocity
	 */
	/**
	 * move the group
	 */
	public void moveGroup() {
		if ((System.currentTimeMillis() - this.loop) > 400) { // rest tick between alien movement
			for (int i = 0; i < 3; i++) { 
				for (int j = 0; j < 8; j++) {
					this.group[i][j].setXCoordinates(xVelocity); // move aliens by a horizontal velocity each tick
				}
				this.loop = System.currentTimeMillis();
			}
			// switch sign of horizontal velocity if aliens hit side boundary
			if ((Math.round(this.group[0][7].getXCoordinates()*100)/100.0 == 0.96) || (Math.round(this.group[0][0].getXCoordinates()*100)/100.0 == 0.04)) {
				this.xVelocity = -this.xVelocity;
				for (int i = 0; i < 3; i++) { 
					for (int j = 0; j < 8; j++) {
						this.group[i][j].setYCoordinates(-0.03); // when a side boundary is hit, move aliens down vertically
					}
				}
			}
		}
	}
	
	/*
	 * in order for the player to win, all the aliens must be eliminated
	 * this method checks if all the aliens have been eliminated
	 * 
	 * actually, the game asks that aliens respawn when they are killed....
	 * so i'll do that instead
	 */
	/**
	 * take in the player in the game so that if all aliens are dead,
	 * they are created again
	 * @param player
	 */
	public void checkGroupDeath(Player player) {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.getAlien(i, j).isNotDead() == false) {
					counter += 1;
				}
			}
		}
		if (counter == 24) {
			//EndGame.winIt(player);
			Game.gameStart(player);
		}
	}
	
	
}
