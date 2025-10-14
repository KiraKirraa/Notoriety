import javax.swing.JInternalFrame;

public class Item extends JInternalFrame{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    // Maintains which note this item is displaying, all actions on this item should modify the note with this id
    private final int noteId;

    // Constructor
    public Item(int noteId){
        // Initialize the internal frame with the note's title
        super(Note.getNoteById(noteId).getTitle(), true, true, false, true);
        
        // Set the noteId
        this.noteId = noteId;

        // Set size and properties
        this.setResizable(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(50 + noteId * 50, 50 + noteId * 50); // Offset each frame
        this.setVisible(true);
    }
    
}
