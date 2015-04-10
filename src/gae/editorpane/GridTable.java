package gae.editorpane;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GridTable extends Group{
	private String[][] myTiles;
	
	public GridTable (int x, int y){
		VBox cols = new VBox();
		myTiles = new String[x][y];
		for (int i=0;i<x;i++){
			HBox rows = new HBox();
			for (int j=0;j<y;j++){
				Button cell = new Button("Unassigned");
				cell.setOnAction(e->{
					ComponentsDialog mydialog = new ComponentsDialog("Tile");
					String elementName = mydialog.getElement();
					if (elementName!= null){
						cell.setText(elementName);
						myTiles[x][y] = elementName;
					}
				});
				rows.getChildren().add(cell);
			}
			cols.getChildren().add(rows);
		}
		getChildren().add(cols);
	}
	
	public String[][] getTable(){
		return myTiles;
	}

}