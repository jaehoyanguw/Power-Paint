/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package tools;



/**
 * The Abstract Tool Class. 
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public abstract class AbstractTool implements ToolInterface {
    /**
     * Only squares or circles.
     */
    private boolean mySquareOrCircle;
    /**
     * The constructor of the Abstract Tool Class. 
     */
    public AbstractTool() {
        mySquareOrCircle = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void squareCircle(final boolean thePerfect) {
        mySquareOrCircle = thePerfect;

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isThePerfect() {
        return mySquareOrCircle;
    }

}
