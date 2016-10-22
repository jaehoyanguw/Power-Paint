/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class UndoAction extends AbstractAction {

    /**
     * The Serial Bar Code.
     */
    private static final long serialVersionUID = 580384824157706649L;
    /**
     * The panel used for drawing.
     */
    private final PaintPanel myPanel;
    
    /**
     * The constructor for the UndoAction that clears out all the drawing.
     * 
     * @param thePanel the panel.
     */
    public UndoAction(final PaintPanel thePanel) {
        super("Undo all changes");
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar('U'));
        setEnabled(false);
    }
    
    /**
     * Clears all the drawings.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.clearDrawing();
        myPanel.setHasDrawing(false);
        this.setEnabled(false);
        myPanel.repaint();
    }

}
