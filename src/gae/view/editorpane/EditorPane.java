/*
 * 
 */
package gae.view.editorpane;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCombination;
import gae.editorComponents.Editor;
import gae.model.Receiver;
import gae.view.GAEPane;
import gae.view.menupane.MenuAdder;

/**
 * The Class EditorPane.
 * 
 * @author Peter EditorPane superclass for other editors to extend. This class
 *         was not used yet.
 *
 */
public class EditorPane extends GAEPane {

	/** The my tabs. */
	private TabPane myTabs;
	private Receiver myReceiver;

	/**
	 * Instantiates a new editor pane.
	 *
	 * @param adder
	 *            the adder
	 */
	public EditorPane(MenuAdder adder, Receiver receiver) {
		super(EditorPane.class.getSimpleName(), adder);
		myTabs = new TabPane();
		myRoot.getChildren().add(myTabs);
		myReceiver = receiver;

		// if you uncomment below, this example works. Except that there is no
		// object named "new" in the inventory yet.

		// Editor editor = new Editor(myMenuAdder, myReceiver, "ExampleEnemy",
		// "new" );
		// Tab newTab = new Tab("Peter"); newTab.setContent(editor.getPane());
		// myTabs.getTabs().add(newTab);

	}

	public void addEditor(String obj) {
		Tab newTab = new Tab(obj);
		Editor newEditor = new Editor(myMenuAdder, myReceiver, obj);
		newTab.setContent(newEditor.getPane());
		myTabs.getTabs().add(newTab);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gae.menupane.Menuable#getMenus()
	 */
	@Override
	public List<Menu> getMenus() {
		List<Menu> menus = new ArrayList<Menu>();

		Menu menuEditor = new Menu("Editor");
		MenuItem closeTabMenuItem = new MenuItem("Close Tab");
		closeTabMenuItem.setOnAction(e -> {
			for (Tab tab : myTabs.getTabs()) {
				if (tab.isSelected()) {
					myTabs.getTabs().remove(tab);
					break;
				}
			}
		});
		closeTabMenuItem.setAccelerator(KeyCombination
				.keyCombination("shortcut+W"));
		menuEditor.getItems().add(closeTabMenuItem);

		menus.add(menuEditor);
		return menus;
	}

}