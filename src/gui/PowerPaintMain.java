/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint
 */
package gui;

import java.awt.EventQueue;

/**
 * Starts the GUI of the PowerPaint Program.
 * 
 * @author Louis Yang (jeho1994).
 * @version 1.0
 */
public final class PowerPaintMain {

    /**
     * PowerPaintMain constructor.
     */
    private PowerPaintMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the SnapShop GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaint();

            }
        });
    }
}
