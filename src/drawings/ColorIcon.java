/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint 
 */
package drawings;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * The ColorIcon Class that creates a specialized Icon for buttons, actions and etc. 
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class ColorIcon implements Icon {
    /**
     * The default starting x coordinate of the Icon.
     */
    private static final int START_X = 2;
    /**
     * The default starting y coordinate of the Icon.
     */
    private static final int START_Y = 3;
    /**
     * The default ending x coordinate of the Icon.
     */
    private static final int END_X = 15;
    /**
     * The default ending y coordinate of the Icon.
     */
    private static final int END_Y = 17;
    /**
     * Color of the Icon.
     */
    private final Color myIconColor;
    
    /**
     * The constructor for the ColorIcon Class.
     * 
     * @param theColor the color of the icon.
     */
    public ColorIcon(final Color theColor) {
        myIconColor = theColor;    
    }

    /**
     * {@inheritDoc}
     * This method is not used in this program.
     */
    @Override
    public int getIconHeight() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * This method is not used in this program.
     */
    @Override
    public int getIconWidth() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * This method is not used in this program.
     */
    @Override
    public void paintIcon(final Component theC, final Graphics theG,
                          final int theX, final int theY) {
        final Graphics2D g2d = (Graphics2D) theG.create();
        g2d.setColor(myIconColor);
        g2d.fillRect(START_X, START_Y, END_X , END_Y);
        

    }

}
