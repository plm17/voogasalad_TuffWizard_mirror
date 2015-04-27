package engine.gameScreens;

import java.awt.Point;
import java.util.List;

import interfaces.MethodAnnotation;
import interfaces.SpecialEditorAnnotation;
import engine.NodeState;

/**
 * Currently a static title screen Animation can be added later.
 *
 * @author Brooks, Patrick, Robert, and Sid.
 */
public class TitleScene extends GameNode {

	private String myBackgroundPicturePath;
	private String myTitleText;
	private Point myTitlePos = new Point();
	private String myTitleStyle;
	private List<NodeButton> myButtons;

	public TitleScene() {
		super();
	}
	
	@MethodAnnotation(editor=true, name="Title Scene Editor", type="titlescene", fieldName="")
	public void fakeMethod() {
		return;
	}

	@Override
	public void render() {
		// TODO FILL IN WITH APPROPRIATE CALLS FOR TITLESCENE ONCE AVAILABLE

	}

	@Override
	public void update() {

	}

	@Override
	public NodeState checkState() {
		return myState;
	}
	
	public List<NodeButton> getButtons() {
		return myButtons;
	}

	@SpecialEditorAnnotation(specialeditor=true, name="Set Background Image", fieldName="myBackgroundPicturePath")
	public void setBackgroundPicturePath(String path) {
		myBackgroundPicturePath = path;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Text", fieldName="myTitleText")
	public void setTitleText(String text) {
		myTitleText = text;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Position", fieldName="myTitlePos")
	public void setTitlePos(int x, int y) {
		myTitlePos.x = x;
		myTitlePos.y = y;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Title Style", fieldName="myTitleStyle")
	public void setTitleStyle(String style) {
		myTitleStyle = style;
	}
	
	@SpecialEditorAnnotation(specialeditor=true, name="Set Buttons", fieldName="myButtons")
	public void setButtons(List<NodeButton> buttons) {
		myButtons = buttons;
	}
}