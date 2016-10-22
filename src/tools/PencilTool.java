/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint   
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

/**
 * The Pencil Tool.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class PencilTool extends AbstractTool implements ToolInterface {
   
    /**
     * The shape or the pencil drawing that will be drawn by the tool.
     */
    private GeneralPath myShape;
    /**
     * The starting x coordinate of the shape that will be drawn.
     */
    private int myStartX;
    /**
     * The starting y coordinate of the shape that will be drawn.
     */
    private int myStartY;
    /**
     * The constructor of the pencil tool.
     */
    public PencilTool() {
        super();
        myShape = new GeneralPath();
        myShape.setWindingRule(GeneralPath.WIND_EVEN_ODD);
        myStartX = 0;
        myStartY = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void starting(final Point thePoint) {
        myShape = new GeneralPath();
        myStartX = (int) thePoint.getX();
        myStartY = (int) thePoint.getY();
        myShape.moveTo(myStartX, myStartY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moving(final Point thePoint) {
        myShape.lineTo(thePoint.getX(), thePoint.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ending(final Point thePoint) {
        myShape.lineTo(thePoint.getX(), thePoint.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Shape getShape() {
        return myShape;
    }

}
