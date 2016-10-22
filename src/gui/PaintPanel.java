/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import drawings.Drawings;
import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class PaintPanel extends JPanel {

    /** A generated serialization ID. */
    public static final long serialVersionUID = 1L;    
    /** Default color of the program. */
    public static final Color DEFAULT_UW_COLOR = new Color(51, 0, 111);
    /** Default background color. */
    public static final String BACKGROUND_COLOR = "WHITE";
    /** Default tick space. */
    public static final int TICK_SPACE = 5;
    /** Current color of the drawing tool. */
    private Color myColor;
    /** Current stroke thickness. */
    private int myStrokeThickness;
    /** Collection of drawings. */
    private final List<Drawings> myDrawing;
    /** Drawing was added recently. */
    private boolean myHasDrawing;
    /** Current Shape that will be drawn. */
    private Shape myCurrentShape;
    
    /**
     * Constructor for the PowerPaint GUI. 
     */
    public PaintPanel() {
        super();
        myColor = new Color(DEFAULT_UW_COLOR.getRGB());
        myStrokeThickness = TICK_SPACE;
        myDrawing = new ArrayList<Drawings>();
        myHasDrawing = false;
        this.setBackground(Color.WHITE);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }
    
    /**
     * Adds to the list of finished drawing.
     * 
     * @param theFinishedDrawing the finished drawing.
     */
    public void setFinishedDrawing(final Drawings theFinishedDrawing) {
        myDrawing.add(theFinishedDrawing);
    }
    
    /**
     * Clears all the drawings.
     */
    public void clearDrawing() {
        myDrawing.clear();
    }
    
    /**
     * Sets the Shape of the current drawing that is being drawn.
     * 
     * @param theShape the shape that was drawn.
     */
    public void setShape(final Shape theShape) {
        myCurrentShape = theShape;
    }
    
    /**
     * Sets the color of the current drawing.
     * 
     * @param theColor the color of the drawing.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Sends information about the current drawing color.
     * 
     * @return myColor the color of the drawing.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Sets the stroke thickenss.
     * 
     * @param theStrokeThickness the stroke thickness of the drawing.
     */
    public void setStrokeThickness(final int theStrokeThickness) {
        myStrokeThickness = theStrokeThickness;
    }
    
    /**
     * Send information on the stroke thickness of the drawing.
     * 
     * @return myStrokeThickness the drawing thickness.
     */
    public int getStrokeThickness() {
        return myStrokeThickness;
    }
    
    /**
     * 
     * 
     * @param theHasDrawing if the panel has current active drawing.
     */
    public void setHasDrawing(final boolean theHasDrawing) {
        myHasDrawing = theHasDrawing;
    }
    
    /**
     * Paints all the drawing including the current one drawn.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < myDrawing.size(); i++) {
            g2d.setPaint(myDrawing.get(i).getColor());
            g2d.setStroke(new BasicStroke(myDrawing.get(i).getThickness()));
            g2d.draw(myDrawing.get(i).getShape());
        }
        // if all the previous drawing are made and new drawing is available to be created.
        if (myHasDrawing) {
            g2d.setPaint(myColor);
            g2d.setStroke(new BasicStroke(myStrokeThickness));
            g2d.draw(myCurrentShape);
        }

    }
    

}
