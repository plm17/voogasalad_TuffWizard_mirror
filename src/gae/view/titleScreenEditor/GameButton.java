package gae.view.titleScreenEditor;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameButton {
	
	private double myXLoc;
	private double myYLoc;
	private double myScale;
	private String myText;
	private Label myBody;
	
	
	public GameButton(){
		myBody = new Label();
		myBody.setStyle("-fx-background-color: white;  -fx-padding: 30; -fx-border-color: black");
		//set default values
		myXLoc = 0;
		myYLoc = 0;
		myScale = 1;
		myText = "Default";
		updateBody();
	}
	
	public GameButton(double x, double y, double scale, String text){
		myXLoc = x;
		myYLoc = y;
		myScale = scale;
		myText = text;
		myBody = new Label(text);
		myBody.setStyle("-fx-background-color: white;  -fx-padding: 30; -fx-border-color: black");
		updateBody();
		
	}
	
	private void updateBody(){
		myBody.setScaleX(myScale);
		myBody.setScaleY(myScale);
		myBody.setText(myText);
	}
	
	public double getX() {
		return myXLoc;
	}


	public void setX(double myXLoc) {
		this.myXLoc = myXLoc;
	}


	public double getY() {
		return myYLoc;
	}


	public void setY(double myYLoc) {
		this.myYLoc = myYLoc;
	}


	public double getScale() {
		return myScale;
	}


	public void setScale(double myScale) {
		this.myScale = myScale;
		updateBody();
	}


	public String getText() {
		return myText;
	}


	public void setText(String myText) {
		this.myText = myText;
		updateBody();

	}

	public Label getBody(){
		return myBody;
	}

}