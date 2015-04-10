package engine;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Point2D;
import com.thoughtworks.xstream.XStream;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.EditableTower;
import interfaces.Movable;


public class Tower implements Movable, EditableTower, Authorable{

	private String myName;
	private String myImageString;
	private List<Integer> myAccessList;
	private Integer myFireRate;
	private Point2D myLocation;
	private Integer myHealth;
	private Projectile myProjectile;
	private Range myRangeObject;
	private int myRange; // <<--only for Xstream purposes
	private Double myCurRotation;
	private Double myTargetRotation;
	private Double myRotationSpeed;
	private Integer myRad;

	// state ?

	public Tower(){
		
	}

	public Tower (String name, String imagePath,  List<Integer> accessList, int range, int health, int radius, int fireRate, Point2D location) {
		init(name, imagePath, accessList, range, health, radius, fireRate, location);
	}

	public Tower (XStream serializer, String data, Point2D location) {
		Tower incomplete = (Tower)serializer.fromXML(data);
		init(incomplete.myName, incomplete.myImageString, incomplete.myAccessList, incomplete.myRange, incomplete.myHealth, incomplete.myRad, incomplete.myFireRate, location);
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
	}

	public String getName() {
		return myName;
	}

	
	@Override
	public void move() {
		rotate();
		if(myCurRotation == myTargetRotation){
			fire();
			target();
		}
	}
	
	private void rotate(){
		// TODO
		// increment myCurRotation based on targetRotation
		
		myCurRotation = myCurRotation + myRotationSpeed;
	}
	
	
	private void fire(){
		
		// TODO: implement this
		
	}
	
	private void target(){
		ArrayList<Enemy> inRange = myRangeObject.getEnemiesInRange();
		Enemy e = selectTarget(inRange);
		setTargetRotation(calculateShot(e));
	}
	

	private void setTargetRotation(double targetAngle){
		myTargetRotation = targetAngle;
	}
	

	
	private Double calculateShot(Enemy e){
		
		// TODO: implement this
		// math involving the enemy's path, speed, projectile speed, rotation speed, current angle
		// this will be the FIRE RATE implementation as well
		
		// perhaps make turret rotation speed variable based on the time at which an enemy can be 
		// shot (based on fire rate, which will NOT be changing but instead fixed per type of tower)
		
		return Math.atan2(myLocation.y-e.getLocation().y, myLocation.x-e.getLocation().x);
		
		
		
	}
	
	private Enemy selectTarget(ArrayList<Enemy> inRange){
		
		Enemy target = null;
		int i = -1;
		
		for (Enemy e : inRange){
			if(e.getTilesWalked() > i){
				target = e;
				i = e.getTilesWalked();
			}
		}
		
		if(isHittable(target))
			return target;
		inRange.remove(target);
		return selectTarget(inRange);
		
		}
		
	
	private boolean isHittable(Enemy e){
		
		// TODO: implement this
		// determine, based on enemy path and other variables, if an enemy is hittable by this tower or not
		
		return true;
	}



	public boolean isDead() {
		return (myHealth <= 0);
	}



	@Override
	public String setName() {
		// TODO Auto-generated method stub
		return myName;
	}

	@Override
	public String setImageString() {
		// TODO Auto-generated method stub
		return myImageString;
	}

	@Override
	public List<Integer> setAccessList() {
		// TODO Auto-generated method stub
		return myAccessList;
	}

	@Override
	public Integer setRange() {
		// TODO Auto-generated method stub
		return myRange;
	}

	@Override
	public Integer setFireRate() {
		// TODO Auto-generated method stub
		return myFireRate;
	}

	@Override
	public Point2D setLocation() {
		// TODO Auto-generated method stub
		return myLocation;
	}

	@Override
	public Integer setHealth() {
		// TODO Auto-generated method stub
		return myHealth;
	}

	@Override
	public Integer setRad() {
		// TODO Auto-generated method stub
		return myRad;
	}

	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateParams(List<Object> params) {
		// TODO Auto-generated method stub
		
	}

}