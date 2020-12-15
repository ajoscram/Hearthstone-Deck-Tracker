package ui;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UI {
    private static UI instance;
    private final MainWindow MAIN_WINDOW;
    
    private UI(){
        MAIN_WINDOW = new MainWindow();
    }
    
    public static UI getInstance(){
        if(instance == null)
            instance = new UI();
        return instance;
    }
    
    public static Icon getClassBanner(String heroClass){
        URL imgURL = getInstance().getClass()
                     .getResource("/resources/"+heroClass.toLowerCase()+"_title.png");
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }
        else
            getInstance().displayError("Couldn't find the header picture for the "
                                       +heroClass+" class. File missing or corrupted.");
        return null;
    }
    
    public void displayUI(){
        MAIN_WINDOW.setVisible(true);
        MAIN_WINDOW.update();
    }
    
    public void displayError(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR",
                                      JOptionPane.ERROR_MESSAGE);
    }
    public void displayInfo(String message){
        JOptionPane.showMessageDialog(null, message, "HS Stats Tracker",
                                      JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean displayConfirm(String message){
        int reply =  JOptionPane.showConfirmDialog(null, message, "HS StatsTracker", 
                                      JOptionPane.YES_NO_OPTION);
        return reply == JOptionPane.YES_OPTION;
    }
}