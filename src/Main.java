import java.awt.Image;
import java.io.*;
import javax.swing.*;

class Main{
    private static final String APP_NAME = "Notoriety";
    private static final String ICON_PATH = "./InvestigationBoard/assets/DetectiveIcon.png";

    public static void main(String[] args) {
        Note.loadNotes();
        Note.newNote("Note1");
        Note.newNote("Note2");
        Note.printAll();
        Note.saveNotes();


        


        JFrame frame = new JFrame(APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the icon image
        ImageIcon icon = new ImageIcon(ICON_PATH); // Replace with your image path
        frame.setIconImage(icon.getImage());

        frame.setSize(1080, 720);
        
        frame.setVisible(true);
    }
    
}