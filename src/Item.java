import javax.swing.JInternalFrame;

public class Item extends JInternalFrame{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    private final int noteId;

    public Item(int noteId){
        super(Note.getNoteById(noteId).getTitle(), true, true, false, true);
        this.noteId = noteId;
        this.setResizable(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(50 + noteId * 50, 50 + noteId * 50); // Offset each frame
        this.setVisible(true);
    }
    
}
