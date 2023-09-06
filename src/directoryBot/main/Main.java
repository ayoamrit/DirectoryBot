package directoryBot.main;
import directoryBot.file.FileManager;

public class Main {

    public static void main(String[] args){
        FileManager file = new FileManager("D:/MyJava");
        file.startFileCount();
    }

}
