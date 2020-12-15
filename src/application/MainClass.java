package application;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import logic.*;
import ui.*;

public class MainClass {
    public static void main(String[] args){
        
        //setting windows look and feel for the ui
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, "You're not using Windows, so the interface might look a little clunky :(", "ERROR",
                                          JOptionPane.ERROR_MESSAGE); 
        }
        //program control singletons
        Logic logic = Logic.getInstance();
        UI gui = UI.getInstance();
        
        //loading data
        try {
            logic.loadData();
        } catch (Exception ex) {
            gui.displayError(ex.getMessage());
        }
        
        //ui bootup
        gui.displayUI();
    }
}
