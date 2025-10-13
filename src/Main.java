import java.io.*;
import javax.swing.*;

class Main{
    public static void main(String[] args) {
        Note.loadNotes();
        Note.newNote("Note1");
        Note.newNote("Note2");
        Note.printAll();
        Note.saveNotes();
    }
    
}