/*
 * 
 */
package engine;

import interfaces.Authorable;
import interfaces.Collidable;
import interfaces.Movable;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 * 
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 *
 * 
 */




public class Enemy extends GridObject implements Collidable, Movable {


	private String myName;

	/** The my speed. */


	private Integer mySpeed;

	/** The my damage. */
	private Integer myDamage;

	/** The my health. */
	private Integer myHealth;

	/** The my walkable. */
	private List<Integer> myWalkable;

	/** The my image string. */
	private String myImageString;

	/** The my collision bounds. */
	private Shape myCollisionBounds;


	/** The my steps. */
	private LinkedList<Tile> myTilePath;

	/** The my rad. */
	private int myRad;

	/** The tiles walked. */
	private int tilesWalked;


	private Integer myID; // IMPLEMENT CREATING THIS

	/** The timer. */
	private Timer timer;


	private Double distanceWalked;


	private Path myPath;
	//orientation??
	//State?


	/**
	 * Instantiates a new enemy.
	 */
	public Enemy(){

		myTilePath = new LinkedList<Tile>();
	}


	
		public void setHealth(int x){
			myHealth = x;
		}




		/**
		 * Sets the steps.
		 *
		 * @param steps the new steps
		 */

		public void setSteps(LinkedList<Tile> steps){
			myTilePath = steps;
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */


		public void setSpeed(int x){
			mySpeed = x;
		}

		public void setDamage(int x){
			myDamage = x;

		}





		public List<String> getWalkables(){
			return myAccessNames;
		}


		void setPath(Path p){
			myPath = p.generateNew();

		}

		public List<Tile> getTilePath(){
			return myTilePath;

		}

		public void setTilePath(LinkedList<Tile> l){
			myTilePath = l; 
		}






		/**
		 * Gets the enemy damage.
		 *
		 * @return the enemy damage
		 */
		public Integer getEnemyDamage(){
			return myDamage;
		}





		/**
		 * The Class reverseEffect.
		 */
		class reverseEffect extends TimerTask {

			/** The speed change. */
			private Integer speedChange;

			/**
			 * Instantiates a new reverse effect.
			 *
			 * @param speed the speed
			 */
			reverseEffect(Integer speed) {
				speedChange = speed;
			}

			/* (non-Javadoc)
			 * @see java.util.TimerTask#run()
			 */
			public void run() {
				mySpeed += speedChange;
				timer.cancel();
			}
		}

		/* (non-Javadoc)
		 * @see interfaces.Collidable#isDead()
		 */
		@Override
		public boolean isDead() {
			if (myHealth <= 0) {
				return true;
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see interfaces.Collidable#getCollisionBounds()
		 */
		public Shape getCollisionBounds() {
			return myCollisionBounds;
		}

		/* (non-Javadoc)
		 * @see interfaces.Collidable#setCollisionBounds()
		 */
		@Override
		public void setCollisionBounds() {
			//myCollisionBounds = new Ellipse2D.Double(myLocation.x, myLocation.y,myRad * 2, myRad * 2);

		}


		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public Placement move() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean evaluateCollision(Collidable collider) {
			// TODO Auto-generated method stub
			return false;
		}
	}



