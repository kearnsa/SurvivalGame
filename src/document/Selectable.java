package document;

import java.awt.Point;

/**
 * A Selectable object can be selected in the game view port.
 * It must have a location.
 * 
 * @author Chris Maltzan
 */
public interface Selectable {

	public boolean isLocation(Point point);
	
	public String getType();
	
	public boolean isSelected();
	
	public void setSelected(boolean b);
	
}
