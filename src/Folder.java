import java.io.File;

public class Folder {
    private String pathToFolder;
    public String getPathToFolder(){
        return this.pathToFolder;
    }
    public boolean setPathToFolder(String pathToFolder){
        this.pathToFolder = pathToFolder;
        return true;
    }
    
    private boolean maximized = false;
    public boolean isMaximized(){
        return this.maximized;
    }
    public boolean setMaximized(boolean state){
        this.maximized = state;
        return true;
    }

    private vec2<Integer> minPos = new vec2<>(0,0);
    public vec2<Integer> getMinPos(){
        return this.minPos;
    }
    public boolean setMinPos(vec2<Integer> minPos){
        this.minPos = minPos;
        return true;
    }

    private vec2<Integer> maxPos = new vec2(0,0);
    public vec2<Integer> getMaxPos(){
        return this.maxPos;
    }
    public boolean setMaxPos(vec2<Integer> maxPos){
        this.maxPos = maxPos;
        return true;
    }

    public Folder(String pathToFolder){
        //Set folder location
        this.pathToFolder = pathToFolder;
        //Set position
        this.minPos.x = 0;
        this.minPos.y = 0;
        this.maxPos.x = 0;
        this.maxPos.y = 0;
    }

    @Override
    public String toString(){
        String toRet = pathToFolder+": ";
        File folder = new File(pathToFolder);
        File[] files = folder.listFiles();
        for(File f : files){
            toRet += "\t"+f.getName();
        }
        return toRet;
    }
}
