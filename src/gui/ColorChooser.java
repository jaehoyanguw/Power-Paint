/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import drawings.ColorIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JColorChooser;

/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class ColorChooser extends AbstractAction {   
    /**
     * The Serial Bar Code.
     */
    private static final long serialVersionUID = 1668149634714942496L;
    /**
     * The panel used for drawing.
     */
    private final PaintPanel myPanel;
    
    /**
     * The ColorChooser constructor that chooses the color.
     * 
     * @param thePanel the panel.
     */
    public ColorChooser(final PaintPanel thePanel) {
        super("Color...", new ColorIcon(thePanel.getColor()));
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY,
                  KeyEvent.getExtendedKeyCodeForChar('C'));
        putValue(Action.SELECTED_KEY, true);
    }

    /**
     * Chooses a color for the drawing.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color color = JColorChooser.showDialog(null, "A Color Chooser", null);
        putValue(SMALL_ICON, new ColorIcon(color));
        myPanel.setColor(color);
    }
}
