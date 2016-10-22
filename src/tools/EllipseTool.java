/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint 
 */
package tools;

import java.awt.geom.Ellipse2D;

/**
 * The Ellipse Tool.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class EllipseTool extends AbstractRectangleTool {

    /**
     * The constructor of the RectangleTool Class.
     */
    public EllipseTool() {
        super(new Ellipse2D.Double());
    }

}
