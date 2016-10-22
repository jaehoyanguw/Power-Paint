/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class ToolBar extends JToolBar {

    /**
     * The Serial Bar Code.
     */
    private static final long serialVersionUID = 7980283436568336682L;

    /** A button group for the mutually exclusive tool bar buttons. */ 
    private final ButtonGroup myGroup;

    /**
     * Construct the ToolBar.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    /**
     * Create a JToggleButton for the ToolBar.
     * 
     * @param theAction to associate with the created JToggleButton
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        add(toggleButton);
    }
}
