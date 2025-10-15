class Main{
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("YAY");

        Board b = new Board("First Board");
        Folder f1 = new Folder("./InvestigationBoard/notes/folder1");
        Folder f2 = new Folder("./InvestigationBoard/notes/folder2");
        b.addFolder(f1);
        b.addFolder(f2);
        System.out.println(b);
    }
}
