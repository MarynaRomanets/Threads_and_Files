package kiev.prog;

import java.io.File;
import java.util.Scanner;

public class NewThreadCheckingDir implements Runnable{
    private File directory;

    public NewThreadCheckingDir(File directory) {
        super();
        this.directory = directory;
    }

    @Override
    public void run(){
        checkingDirectory();
    }

    public void checkingDirectory() {
        long sizeDirectory = directory.list().length, sizeChecking;
        boolean flag = true;
        while (flag) {
            System.out.println("Checking of directory: " + directory.getAbsolutePath());
            try {
                Thread.sleep(1000);
                sizeChecking = directory.list().length;
                if ( sizeChecking > sizeDirectory) {
                    System.out.println("New file in directory: " + directory.getName());
                    flag = false;
                }
                if (sizeChecking < sizeDirectory) {
                    System.out.println("Delete file from directory: " + directory.getName());
                    flag = false;
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}