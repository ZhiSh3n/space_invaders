package lab10;

public interface GroupInterface {
	
	/*
	 * each group will have these methods
	 */
	
	public void moveGroup();
	public int getSize();
	public Bullet getBullet(int a);
	public void addBullet(Bullet a);
	public void removeBullet(int a);
	
}
