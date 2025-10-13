import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Note implements Serializable{
    //Static Fields and Methods
    private static ArrayList<Note> notes = new ArrayList<>();
    private static final String SAVELOCATION = "MyNotes.notes";

    public static boolean saveNotes(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVELOCATION));
            oos.writeObject(notes);
            oos.close();
            return true;
        } catch (Exception e) {
            System.err.println("COULDNT SAVE NOTES TO FILE");
            return false;
        } 
    }
    public static boolean loadNotes(){
        try {
             FileInputStream fis = new FileInputStream(SAVELOCATION);
            ObjectInputStream ois = new ObjectInputStream(fis);
            notes = (ArrayList<Note>) ois.readObject();
            ois.close();
            return true;
        } catch (Exception e) {
            System.err.println("COULDN'T READ NOTES FROM FILE");
            return false;
        }
    }

    public static Note newNote(String title){
        Note n = new Note(title);
        notes.add(n);
        return n;
    }

    //Print all note in order of creation
    public static void printAll(){
        //Body
        for(int i = 0; i < notes.size(); i++){
            System.out.println(notes.get(i).toString());
        }
    }

    public static Note getNoteById(int id){
        //Break Conditions 
        if(id < 0){
            return null;
        }
        if(id >= notes.size()){
            return null;
        }

        //Body
        return notes.get(id);
    }

    //Instance Fields
    private int id;
    private String title;
    private String text;
    
    private Note(String title){
        this.id = notes.size();
        this.title = title;
        this.text = "Default Text";
    }

    //Getters
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getText(){
        return this.text;
    }

    //Setters
    public boolean setTitle(String title){
        this.title = title;
        return true;
    }
    public boolean setText(String text){
        this.text = text;
        return true;
    }

    @Override
    public String toString(){
        return String.format("%s\n  ID: %d\n  Text: %s",title,id,text);
    }

}
