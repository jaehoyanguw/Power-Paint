/**
 * PowerPaintGUI TCSS 305 - Assignment 5 Part B : PowerPaint  
 */
package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * The PaintPanel which is used for drawing.
 * 
 * @author Louis Yang (jeho1994)
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
    
    /** Default tick space. */
    public static final int TICK_SPACE = 5;
    
    /**
     * The Serial Bar Code.
     */
    private static final long serialVersionUID = -1420520171997104358L;
    
    /** The file menu. */
    private final JMenu myFileMenu;
    /** The option menu. */
    private final JMenu myOptionMenu;
    /** The tool menu. */
    private final JMenu myToolMenu;
    /** The help menu. */
    private final JMenu myHelpMenu;
    /** A button group for radio buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * The Menu bar for the PowerPaint.
     * 
     * @param thePanel the panel.
     * @param theNewFunction the new function.
     */
    public MenuBar(final PaintPanel thePanel, 
                   final JCheckBoxMenuItem theNewFunction) {
        super();
        myFileMenu = new JMenu("File");
        myOptionMenu = new JMenu("Options");
        myToolMenu = new JMenu("Tools");
        myHelpMenu = new JMenu("Help");
        myGroup = new ButtonGroup();
        setup(thePanel, theNewFunction);
    }
    
    /**
     * The setup of the menubar.
     * 
     * @param thePanel the panel.
     * @param theNewFunction the new function.
     */
    private void setup(final PaintPanel thePanel,
                       final JCheckBoxMenuItem theNewFunction) {
        //1st option menu
        myFileMenu.setMnemonic('F');     
        //2nd option menu
        myOptionMenu.setMnemonic('O');
        
        final JMenu thickness = new JMenu("Thickness");
        thickness.setMnemonic('T');
        final JSlider slider = new JSlider(0, 20, 5);
        slider.setMajorTickSpacing(TICK_SPACE);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();
                thePanel.setStrokeThickness(value);
            }
        });
        thickness.add(slider);    
        myOptionMenu.add(theNewFunction);
        myOptionMenu.addSeparator();
        myOptionMenu.add(thickness);
        myOptionMenu.addSeparator();
        //3rd tool menu 
        myToolMenu.setMnemonic('T');
        //4th help menu
        myHelpMenu.setMnemonic('H');
        this.add(myFileMenu);
        this.add(myOptionMenu);
        this.add(myToolMenu);
        this.add(myHelpMenu);
    }
    
    /**
     * Adds to the existing file menu.
     * 
     * @param theAction the action.
     */
    public void addToFileMenu(final Action theAction) {
        myFileMenu.add(theAction);
    }
    
    /**
     * Adds to the existing option menu.
     * 
     * @param theAction the action.
     */
    public void addToOptionMenu(final Action theAction) {
        myOptionMenu.add(theAction);
    }
    
    /**
     * Adds to the existing tool menu.
     * 
     * @param theAction the action.
     */
    public void addToToolsMenu(final Action theAction) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);       
        myGroup.add(createdButton);
        myToolMenu.add(createdButton);
    }
    
    /**
     * Adds to the existing help menu.
     * 
     * @param theAction the action.
     */
    public void addToHelpMenu(final Action theAction) {
        myHelpMenu.add(theAction);
    }
}
