/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;


/**
 * Tool interface.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public interface ToolInterface { 
    
    /**
     * Assigns the start point of the shape that will be drawn by the tool.
     * 
     * @param thePoint the current starting point of the shape.
     */
    void starting(Point thePoint);
    
    /**
     * Draws the shape while the tool is in the process of drawing.
     * 
     * @param thePoint the end point of the shape.
     */
    void moving(Point thePoint);
    
    /**
     * Concludes the final figure of the shape created by the tool.
     * 
     * @param thePoint the end point of the shape.
     */
    void ending(Point thePoint);
    
    /**
     * Gets the shape of the drawing.
     * 
     * @return the shape.
     */
    Shape getShape();
    
    /**
     * Sets the shape to circle or square bounds. 
     * 
     * @param thePerfect the boolean Circle/Square.
     */
    void squareCircle(boolean thePerfect);
    
    /**
     * Returns whether the shape drawn has to be a circle or square.
     * 
     * @return whether or not Circle/Square is selected.
     */
    boolean isThePerfect();
   
}
