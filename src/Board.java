import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

//Data for boards
public class Board extends JDesktopPane implements java.io.Serializable{
    private static int boardCount = 0;
    private static ArrayList<Board> boards = new ArrayList<>();
    private static final String SAVELOCATION = "MyBoards.boards";

    //Static Methods
    public static Board newBoard(String name, JTabbedPane parent){
        Board b = new Board(name);
        boards.add(b);
        parent.addTab(b.title,b);
        return b;
    }
    public static Board getBoardById(int id){
        //Break Conditions 
        if(id < 0){
            return null;
        }
        if(id >= boards.size()){
            return null;
        }
        return boards.get(id);
    }

    public static void printAll(){
        //Body
        for(int i = 0; i < boards.size(); i++){
            System.out.println(boards.get(i).toString());
        }
    }
    public static boolean saveBoards(){
        try {
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream(SAVELOCATION));
            oos.writeObject(boards);
            oos.close();
            return true;
        } catch (Exception e) {
            System.err.println("COULDNT SAVE BOARDS TO FILE");
            return false;
        } 
    }
    public static boolean loadBoards(){
        try {
             java.io.FileInputStream fis = new java.io.FileInputStream(SAVELOCATION);
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            boards = (ArrayList<Board>) ois.readObject();
            ois.close();
            return true;
        } catch (Exception e) {
            System.err.println("COULDN'T READ BOARDS FROM FILE");
            return false;
        }
    }

    //Instance Fields
    private int id;
    private String title = "Default Board Name";
    private ArrayList<Integer> itemIds = new ArrayList<>();

    //Constructors
    private Board(String name){
        super();
        this.id = boardCount;
        this.title = name;
        boardCount++;
    }

    //Getters
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public ArrayList<Integer> getItemIds(){
        return this.itemIds;
    }

    //Setters
    public boolean setTitle(String name){
        this.title = name;
        return true;
    }   
    public boolean addItem(int itemId){
        this.itemIds.add(itemId);
        return true;
    }
    public boolean removeItem(int itemId){
        this.itemIds.remove(itemId);
        return true;
    }

    @Override
    public String toString(){   
        return String.format("%s\n  %d\n  %s", this.title, this.id, this.itemIds);
    }
}