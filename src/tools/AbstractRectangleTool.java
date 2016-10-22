/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RectangularShape;

/**
 * The AbstractRectangleTool Class.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public abstract class AbstractRectangleTool extends AbstractTool implements ToolInterface {
    
    /**
     * The rectangular shape that will be drawn by the tool.
     */
    private RectangularShape myShape;
    /**
     * The starting x coordinate of the shape that will be drawn.
     */
    private int myStartX;
    /**
     * The starting y coordinate of the shape that will be drawn.
     */
    private int myStartY;
    
    /**
     * Constructor for the AbstractRectangleTool Class.
     * 
     * @param theShape the shape of the tool.
     */
    public AbstractRectangleTool(final RectangularShape theShape) {
        super();
        myShape = theShape;
        myStartX = 0;
        myStartY = 0;
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void starting(final Point thePoint) {
        myShape = (RectangularShape) myShape.clone();
        myStartX = (int) thePoint.getX();
        myStartY = (int) thePoint.getY();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moving(final Point thePoint) {
        final int width = (int) (thePoint.getX() - myStartX);
        final int height = (int) (thePoint.getY() - myStartY);
        int distance = 0;
        
        if (isThePerfect() && width != height) {
            if (Math.abs(width) < Math.abs(height)) {
                distance = Math.abs(width);
            } else {
                distance = Math.abs(height);
            }
            if (width < 0 && height > 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX - distance,
                                             myStartY + distance);
            } else if (height < 0 && width > 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX + distance,
                                             myStartY - distance);
            } else if (height < 0 && width < 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX - distance,
                                             myStartY - distance);
            } else {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX + distance,
                                             myStartY + distance);
            }
        } else {
            myShape.setFrameFromDiagonal(myStartX, myStartY, thePoint.getX(),
                                         thePoint.getY());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ending(final Point thePoint) {
        final int width = (int) (thePoint.getX() - myStartX);
        final int height = (int) (thePoint.getY() - myStartY);
        int distance = 0;
        
        if (isThePerfect() && width != height) {
            if (Math.abs(width) < Math.abs(height)) {
                distance = Math.abs(width);
            } else {
                distance = Math.abs(height);
            }
            if (width < 0 && height > 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX - distance,
                                             myStartY + distance);
            } else if (height < 0 && width > 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX + distance,
                                             myStartY - distance);
            } else if (height < 0 && width < 0) {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX - distance,
                                             myStartY - distance);
            } else {
                myShape.setFrameFromDiagonal(myStartX, myStartY, myStartX + distance,
                                             myStartY + distance);
            }
        } else {
            myShape.setFrameFromDiagonal(myStartX, myStartY, thePoint.getX(),
                                         thePoint.getY());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shape getShape() {
        return myShape;
    }
}
