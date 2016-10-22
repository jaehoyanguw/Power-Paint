/*
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint 
 */
package gui;

import drawings.Drawings;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tools.EllipseTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;
import tools.ToolInterface;

/**
 * The Graphical User Interface for PowerPaint Program.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 *
 */
public class PowerPaint {
    /** The default image of the program. */
    public static final ImageIcon FRAME_IMAGE = new ImageIcon("./images/uwseal.gif");
    /** The dimension of the program. */
    public static final Dimension DEFAULT_DIMENSION = new Dimension(500, 400);
    /** The frame of the GUI. */
    private final JFrame myFrame;
    /** My current tool used for drawing. */
    private ToolInterface myCurrentTool;
    /** My canvas of drawing. */
    private final PaintPanel myPanel;
    /** The undo Action. */
    private final Action myUndo;
    /** The exit action. */
    private final Action myExitAction;
    /** The color action. */
    private final Action myColorChooser;
    /** The help action. */
    private final Action myAbout;
    /** Drawing was added recently. */
    private boolean myPerfect;
    
    /**
     * The PowerPaint Constructor.
     */
    public PowerPaint() {
        myFrame =  new JFrame("PowerPaint");
        myFrame.setIconImage(FRAME_IMAGE.getImage());
        myPanel =  new PaintPanel();
        myCurrentTool = new PencilTool();
        myUndo = new UndoAction(myPanel);
        myExitAction = new QuitAction(myFrame);
        myColorChooser = new ColorChooser(myPanel);
        myAbout = new About(FRAME_IMAGE);
        myPerfect = false;
        //sets up its components
        setup();
    }
    
    /**
     * Sets up the GUI.
     */
    private void setup() {
        setLookAndFeel();
        addListener(myPanel);
        final ToolBar toolBar = new ToolBar();
        final ArrayList<Tools> tools = new ArrayList<Tools>();
        tools.add(new Tools("Pencil", new ImageIcon("./images/pencil.gif"), 
                            new PencilTool()));
        tools.add(new Tools("Line", new ImageIcon("./images/line.gif"),
                            new LineTool()));
        tools.add(new Tools("Rectangle", new ImageIcon("./images/rectangle.gif"),
                            new RectangleTool()));
        tools.add(new Tools("Ellipse", new ImageIcon("./images/ellipse.gif"),
                            new EllipseTool()));
        
        final JCheckBoxMenuItem newOption = newCircleOrSquareFunction();
        final MenuBar menuBar = new MenuBar(myPanel, newOption);
        menuBar.addToFileMenu(myUndo);
        menuBar.addToFileMenu(myExitAction);
        menuBar.addToOptionMenu(myColorChooser);
        menuBar.addToHelpMenu(myAbout);
        
        //sets the each tool actions to the menu bar.
        for (final Tools tool : tools) {
            menuBar.addToToolsMenu(tool);
            toolBar.createToolBarButton(tool);
        }

        myFrame.setJMenuBar(menuBar);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        /** A ToolKit. */
        final Toolkit kit = Toolkit.getDefaultToolkit();    
        //centers the program in the center
        myFrame.setLocation(
            (int) (kit.getScreenSize().getWidth() / 2 - myFrame.getWidth() / 2),
            (int) (kit.getScreenSize().getHeight() / 2 - myFrame.getHeight() / 2));
        myFrame.pack();
        myFrame.setMinimumSize(DEFAULT_DIMENSION);
        myFrame.add(toolBar, BorderLayout.SOUTH);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setVisible(true);
    }
    
    /**
     * 
     * @param thePanel the panel.
     */
    private void addListener(final PaintPanel thePanel) {
        thePanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent theAction) {
                final Point startPoint = new Point(theAction.getX(), theAction.getY());
                myCurrentTool.starting(startPoint);
                thePanel.setHasDrawing(true);
                thePanel.setShape(myCurrentTool.getShape());  
            }

            public void mouseReleased(final MouseEvent theAction) {
                final Point startPoint = new Point(theAction.getX(), theAction.getY());
                myCurrentTool.ending(startPoint);
                thePanel.setFinishedDrawing(new Drawings(myCurrentTool.getShape(), 
                                                         thePanel.getColor(),
                                                         thePanel.getStrokeThickness()));
                thePanel.setHasDrawing(false);
                myUndo.setEnabled(true);
                thePanel.setShape(myCurrentTool.getShape());
                thePanel.repaint();
            }
        });
        thePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent theAction) {
                final Point startPoint = new Point(theAction.getX(), theAction.getY());
                myCurrentTool.moving(startPoint);
                thePanel.setShape(myCurrentTool.getShape());
                thePanel.repaint();
            }
        });
    }
    
    /**
     * New option of the program where the rectangle and ellipse only draws squares and
     * circles.
     * 
     * @return the new option square or circle.
     */
    private JCheckBoxMenuItem newCircleOrSquareFunction() {
        final JCheckBoxMenuItem squareOrCircle = new JCheckBoxMenuItem("Square/Circle only",
                                                                       false);
        squareOrCircle.setMnemonic('S');
        squareOrCircle.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent theItem) {
                myPerfect = squareOrCircle.isSelected();
                myCurrentTool.squareCircle(myPerfect);
            }
        });
        return squareOrCircle;
    }
    
    /** Sets the frame to look metallic. */
    private static void setLookAndFeel() {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException");
        } catch (final ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (final InstantiationException e) {
            System.out.println("InstantiationException");
        } catch (final IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }
    
    /**
     * Chooses a specific tool for the drawing.
     */
    private class Tools extends AbstractAction {
        
        /** A generated serialization ID. */
        private static final long serialVersionUID = 5378597116905801274L;
        /** Current tool. */
        private final ToolInterface mySelectedTool;
        /**
         * Constructs an action with the specified name and icon to set a specific tool.
         * 
         * @param theName The name.
         * @param theIcon The icon.
         * @param theTool the tool.
         */
        Tools(final String theName, final Icon theIcon, final ToolInterface theTool) {
            super(theName);
            mySelectedTool = theTool;
            
            // Here is how to assign a larger icon to the tool bar.
            final ImageIcon icon = (ImageIcon) theIcon;
            final Image largeImage =
                icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
            final ImageIcon largeIcon = new ImageIcon(largeImage);
            putValue(Action.LARGE_ICON_KEY, largeIcon);
            
            // set a mnemonic on the first character of the name
            putValue(Action.MNEMONIC_KEY,
                     KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
            
            // tool tips
            putValue(Action.SHORT_DESCRIPTION, theName + " background");
            
            // coordinate button selection
            putValue(Action.SELECTED_KEY, true);
            
        }

        /**
         * Sets the panel to the specified color.
         * 
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            myCurrentTool = mySelectedTool;
            myCurrentTool.squareCircle(myPerfect);
        }
    }
}
