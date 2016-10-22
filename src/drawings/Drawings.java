/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package drawings;

import java.awt.Color;
import java.awt.Shape;

/**
 * The Drawings Class.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class Drawings {
    
    /**
     * The shape of the drawing produced by the drawing tools.
     */
    private final Shape myShape;
    /**
     * the color of the drawing.
     */
    private final Color myColor;
    /**
     * the thickness of the drawing.
     */
    private final int myThickness;
    
    /**
     * Constructor of the Drawings Class.
     * 
     * @param theShape the shape of the drawing.
     * @param theColor the color of the drawing.
     * @param theThickness the thickness of the drawing.
     */
    public Drawings(final Shape theShape, final Color theColor, final int theThickness) {
        myShape = theShape;
        myColor =  theColor;
        myThickness = theThickness;
    }
    
    /**
     * Gets the shape of the drawing.
     * 
     * @return the shape
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * Gets the color of the drawing.
     * 
     * @return the color
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Gets the thickness of the drawing.
     * 
     * @return the thickness
     */
    public int getThickness() {
        return myThickness;
    }

}
