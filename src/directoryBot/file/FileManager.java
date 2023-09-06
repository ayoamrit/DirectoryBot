package directoryBot.file;

import directoryBot.notification.Notification;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Objects;

public class FileManager implements Runnable{
    private static File directoryFiles;
    private Thread thread = null;

    private int totalFilesNumber;

    public FileManager(String directoryPath){
        directoryFiles = new File(directoryPath);
    }

    public void startFileCount(){
        thread = new Thread(this);
        thread.start();
    }

    private int getFilesNumber(){
        return Objects.requireNonNull(directoryFiles.list()).length;
    }

    public void run(){
        totalFilesNumber = getFilesNumber();

        while(thread != null){
            int currentFilesNumber = getFilesNumber();

            if(currentFilesNumber > totalFilesNumber){
                totalFilesNumber = currentFilesNumber;

                new Notification("File has been added to the folder");
            }
            else if(currentFilesNumber < totalFilesNumber){
                totalFilesNumber = currentFilesNumber;

                new Notification("File is removed from the folder");
            }
            else{
                continue;
            }

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
