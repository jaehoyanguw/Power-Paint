/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class About extends AbstractAction {

    /**
     * The Serial Bar Code.
     */
    private static final long serialVersionUID = -5061506178712291134L;
    /**
     * The matching icon used in the frame.
     */
    private final ImageIcon myFrameIconMatch;
    
    /**
     * Constructor for the About that creates the about instructions of the PowerPaint program.
     * 
     * @param theImage the image icon.
     */
    public About(final ImageIcon theImage) {
        super("About...");
        myFrameIconMatch = theImage;
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar('A'));
        putValue(Action.SELECTED_KEY, true);
    }

    /**
     * Shows information about the PowerPaint Program.
     */
    @Override
    public void actionPerformed(final ActionEvent theAction) {
        final String helpStatement = "TCSS 305 PowerPaint\nWinter 2016\nLouis Yang";
        JOptionPane.showMessageDialog(
                                      null, 
                                      helpStatement, 
                                      "About", JOptionPane.INFORMATION_MESSAGE,
                                      myFrameIconMatch);
    }
}
