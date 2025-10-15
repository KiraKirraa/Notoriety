import java.util.ArrayList;

public class Board {
    private String title = "Board";
    public String getName(){
        return this.title;
    }
    public boolean setName(String title){
        this.title = title;
        return true;
    }
    
    private ArrayList<Folder> folders = new ArrayList<>();
    public ArrayList<Folder> getFolders(){
        return this.folders;
    }
    public boolean setFolders(ArrayList<Folder> folders){
        this.folders = folders;
        return true;
    }
    public boolean addFolder(Folder folder){
        return this.folders.add(folder);
    }
    public boolean removeFolder(Folder folder){
        return this.folders.remove(folder);
    }

    public Board(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return String.format("%s:\n  %s", this.title, this.folders);
    }
}
