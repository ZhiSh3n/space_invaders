Space Invaders
======================
Created by: Zachary Yong

This is a small 2D game I made to resemble the classic Space Invaders game. Everything you'd expect is included in the game with the exception of barricades, which the original game had. The game uses StdDraw to render everything. You can find more information about this [here](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html), which is the single class itself. 

The game is not runnable right after download; the StdDraw class is not included, so that has to be downloaded and properly imported. In addition, the sprite image files included in the repository are not placed in the correct folder configuration, so that will need to be changed as well. Minor edits required to play!

## Files
* [Alien.java](Alien.java)
    * This class defines what an Alien (enemy) is. 
    * Is instantiated with a location and also a boolean for if the Alien is dead or not.
    * Includes a function to draw the Alien (if its alive) and also a function to set the Alien's alive/dead status.
* [AlienGroup.java](AlienGroup.java)
    * This class creates 3 rows of Aliens (8 in each row).
    * The Alien Group has an X-Velocity, which allows it a move left/right each time the StdDraw loops. 
    * Includes a function to draw the Alien Group, as well as a function called ```moveGroup()``` that moves the entire group of Aliens every StdDraw loops (every frame, basically). A
    * Also includes a function that checks if every alien has been killed (this is the win condition for the player). 
* [ArcadeKeys.java](ArcadeKeys.java)
    * This class checks if a relevant key is being pressed and returns the keyCode of the key to be used by other classes. 
* [Bullet.java](Bullet.java)
    * Bullets are used by both Aliens (who shoot at the player) and the player. They have a location and a color. 
    * Includes a function to draw the bullet. 
* [BulletGroup.java](BulletGroup.java)
    * Similar to [AlienGroup.java](AlienGroup.java).
    * Is instantiated with a LinkedList of bullets (so bullets can be added and deleted at any time without restriction). Also has a Y-Velocity for how fast the bullets travel across the screen. 
    * Includes a function to move all the bullets across the screen by the same amount. Also includes a function called ```randomAlienShot()``` that randomly chooses an Alien (or multiple) that is not dead and makes it fire a bullet. 
    * Includes a function to draw all bullets.
* [Collision.java](Collision.java)
    * This class checks for any kind of collision between entities and bullets. 
    * Collisions checked include Alien-bullet, bullet-player, and Alien-player. 
    * When the player is hit or collides into an alien, then 1 life is subtracted from the player's life count. If the player has no lives left, then it's game over. 
    * When an alien is hit by a player bullet, the alien is set to dead and will not appear anymore and cannot be hit by other bullets. 
* [EndGame.java](EndGame.java)
    * If a player loses all lives, then a static page appears, showing the player's score and giving the player the option to restart the game. 
    * Also includes a function that does the same thing except this function activates if the player wins by eliminating all Aliens. 
* [Entity.java](Entity.java)
    * The backbone for Aliens and the player! 
    * Instantiates all entities with a location on the screen and also a radius. 
* [EntityInterface.java](EntityInterface.java]
    * All entities will have functions for getting and setting their location.
* [Game.java](Game.java)
    * Instantiates a game by creating groups for Aliens, player bullets, and Alien bullets. 
    * While the player has lives to spare, loop through a list of functions that makes everything work! (check out the source code). Note that by default the StdDraw looping time is set to 25 milliseconds. 
* [GroupInterface.java](GroupInterface.java)
    * Used by the [AlienGroup.java](AlienGroup.java) and [BulletGroup.java](BulletGroup.java). 
    * Every group has a function that moves the group and remove objects from the group.
* [Player.java](Player.java)
    * Creates a player with 3 starting lives, a location, and a score.
    * Includes a function to draw the player, a function to fire bullets (spacebar), a function to move (arrow keys), a function to draw the bullets the player fires, and a function that draws the lives and score of the player.
* [RandomAlienShots.java](RandomAlienShots.java)
    * Randomly shoots alien bullets.
* [Run.java](Run.java)
    * Run the game from here! Goes directly to the start screen.
* [StartScreen.java](StartScreen.java)
    * Similar to [EndGame.java](EndGame.java). Shows a static screen allowing the player to enter the game.
