package engine;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import interfaces.Collidable;
import interfaces.EditableTower;
import interfaces.Movable;

public class Tower implements Collidable, Movable, EditableTower{

	private String myImageString;
	private String myName;
	private List<Integer> myAccessList;
	private Integer myRange;
	private Integer myFireRate;
	private Point2D myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private Point2D myHeading;
	private int myRad;
	private Shape myCollisionBounds;
	//state?


	public Tower (String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location) {
		init(name, imagePath, accessList, range, health, radius, fireRate, location);
	}

	public Tower (XStream serializer, String data, Point2D location) {
		Tower incomplete = (Tower)serializer.fromXML(data);
		init(incomplete.myName, incomplete.myImageString, incomplete.myAccessList, incomplete.myRange, incomplete.myHealth, incomplete.myRad, incomplete.myFireRate, location);
	}

	/**
	 * detectEnemy().getLocation();
	 * cos(theta) = (u*v) / (||u|| ||v||)
	 * u and v are vectors originating from the tower
	 */
	@Override
	public void move() {

	}

	/**
	 * Check if enemy is in range
	 * Maybe make this return an Enemy at which to shoot?
	 * TODO: Brooks yay
	 * @return
	 */
	public boolean detectEnemy(){
		return false;
	}

	@Override
	public boolean evaluateCollision(Collidable collider) {
		return false;

	}

	/**
	 * Thoughts on how this would work?
	 * Could be accessed by the view somehow?
	 * This would return a projectile which could be used elsewhere
	 * TODO: Help idk how to fully implement this
	 */
//	public Projectile spawnProjectile(){
//		return myProjectile;
//	}

	@Override
	public boolean isDead() {
		return (myHealth <= 0);
	}

	public void setCollisionBounds() {
		myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y, myRad*2, myRad*2);

	}

	@Override
	public Shape getCollisionBounds() {
		return myCollisionBounds;
	}
	public void init(String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location){
		myImageString = imagePath;
		myName = name;
		myAccessList = accessList;
		myRange = range;
		myFireRate = fireRate;
		myLocation = location;
		myHealth = health;
		myRad = radius;
		setCollisionBounds();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}

	@Override
	public String getImageString() {
		// TODO Auto-generated method stub
		return myImageString;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		myName = name;
	}

	@Override
	public void setImageString(String imageString) {
		// TODO Auto-generated method stub
		myImageString = imageString;
	}

	@Override
	public void setAccessList(List<Integer> accessList) {
		// TODO Auto-generated method stub
		myAccessList = accessList;
	}

	@Override
	public void setRange(Integer range) {
		// TODO Auto-generated method stub
		myRange = range;
	}

	@Override
	public void setFireRate(Integer fireRate) {
		// TODO Auto-generated method stub
		myFireRate = fireRate;
	}

	@Override
	public void setLocation(Point2D location) {
		// TODO Auto-generated method stub
		myLocation = location;
	}

	@Override
	public void setHealth(Integer health) {
		// TODO Auto-generated method stub
		myHealth = health;
	}

	@Override
	public void setRadius(Integer radius) {
		// TODO Auto-generated method stub
		myRad = radius;
	}

	@Override
	public void setProjectile(Projectile projectile) {
		// TODO Auto-generated method stub
		myProjectile = projectile;
	}

}