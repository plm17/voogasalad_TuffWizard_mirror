package gae.view.editorpane;

import gae.model.Receiver;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Negatu
 * 
 *
 */
public class ListField extends HBox{
	private Button myAdder;
	private ArrayList<String> myList;
	
	public ListField(String name, Receiver myReceiver){
		myList = new ArrayList<String>();
		myAdder = new Button("Add "+name);
		myAdder.setOnAction(e->{
			ComponentsDialog mydialog = new ComponentsDialog(name, myReceiver);
			String elementName = mydialog.getElement();
			if (elementName!= null){
				addLabel(elementName);
			}
		});
		getChildren().add(myAdder);
	}
	
	private void addLabel(String elementName){
		myList.add(elementName);
		this.getChildren().add(new Label(elementName));
	}

	public ArrayList<String> getList(){
		return myList;
	}
}
