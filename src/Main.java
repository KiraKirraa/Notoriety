import java.awt.BorderLayout;
import javax.swing.*;

class Main{
    private static final String APP_NAME = "Notoriety";
    private static final String ICON_PATH = "./InvestigationBoard/assets/DetectiveIcon.png";

    public static void main(String[] args) {
        // Set the look and feel to Motif
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            System.err.println("Couldn't set look and feel");
        }
        
        // Initialize data
        Note.loadNotes();
        Note.newNote("Note1");
        Note.newNote("Note2");
        Note.printAll();
        Note.saveNotes();

        // Create the main application window   
        JFrame frame = new JFrame(APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        ImageIcon icon = new ImageIcon(ICON_PATH); // Replace with your image path
        frame.setIconImage(icon.getImage());

        // Set content
        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);


        Board.loadBoards();

        // Board.newBoard("Board1", tabbedPane);
        // Board.getBoardById(0).addItem(1);
        // Board.newBoard("Board2", tabbedPane);

        tabbedPane.addTab("readd",Board.getBoardById(0));
        Board.saveBoards();

        // ADD FUNCTIONALITY TO TABS LATER??
        // for(int i = 0; i < 2; i++){
        //     Item internalFrame = new Item(i);
        //     Board.getBoardById(i).add(internalFrame);
        //     internalFrame.setVisible(true);
        // }



        // Can this be application stuff instrad? new SwingApplication()?
        frame.setVisible(true);
    }

    
}