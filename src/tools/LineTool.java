/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * The LineTool.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class LineTool extends AbstractTool implements ToolInterface {
    
    /**
     * The line created by the tool.
     */
    private Line2D myShape;
    
    /**
     * The starting point of the shape.
     */
    private Point myStartPoint;

    /**
     * The LineTool Constructor.
     */
    public LineTool() {
        super();
        myShape = new Line2D.Double();
        myStartPoint = new Point();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void starting(final Point thePoint) {     
        myShape = new Line2D.Double();
        myStartPoint = new Point();
        myStartPoint = (Point) thePoint.clone();
        myShape.setLine(myStartPoint.getX(), myStartPoint.getY(), 
                        myStartPoint.getX(), myStartPoint.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moving(final Point thePoint) {
        myShape.setLine(myStartPoint.getX(), myStartPoint.getY(), 
                        (int) thePoint.getX(), (int) thePoint.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ending(final Point thePoint) {
        myShape.setLine(myStartPoint.getX(), myStartPoint.getY(), 
                        (int) thePoint.getX(), (int) thePoint.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shape getShape() {
        return myShape;
    }

}
