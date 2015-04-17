package engine;

import javafx.animation.KeyFrame;
import javafx.util.Duration;

// TODO: Auto-generated Javadoc
/**
 * The Class GameScene.
 * 
 * @author Brooks, Patrick, Robert, and Sid.
 * 
 * 
 */
public abstract class GameScene {
	
	/** The my name. */
	private String myName;
	
	/** The my next. */
	private GameScene myNext;
	
	/** The my has completed. */
	protected boolean myHasCompleted;
	
	/** The my scene. */
	private KeyFrame myScene;
	
	/** The my game lost. */
	protected boolean myGameLost;
	
	/** The my game won. */
	protected boolean myGameWon;
	
	/**
	 * Instantiates a new game scene.
	 */
	public GameScene(){
		myGameLost = false;
	}

	/**
	 * Start.
	 *
	 * @param frameRate the frame rate
	 * @return the key frame
	 */
	public KeyFrame start(double frameRate) {
		myScene = new KeyFrame(Duration.millis(frameRate * 10), e -> update());
		return myScene;
	}

	/**
	 * Update.
	 */
	public abstract void update();
	
	/**
	 * Check complete.
	 */
	public abstract void checkComplete();
	
	/**
	 * Gets the next scene.
	 *
	 * @return the next scene
	 */
	public GameScene getNextScene(){
		return myNext;
	}
	
	/**
	 * Gets the cur scene.
	 *
	 * @return the cur scene
	 */
	public KeyFrame getCurScene(){
		return myScene;
	}
	
	/**
	 * Checks if is complete.
	 *
	 * @return true, if is complete
	 */
	public boolean isComplete(){
		checkComplete();
		return myHasCompleted;
	}
	
	/**
	 * Sets the next scene.
	 *
	 * @param gameScene the new next scene
	 */
	public void setNextScene(GameScene gameScene){
		myNext = gameScene;
	}
}