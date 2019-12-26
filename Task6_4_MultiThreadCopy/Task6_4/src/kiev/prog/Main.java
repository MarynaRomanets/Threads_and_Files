package kiev.prog;

import java.io.IOException;

import static kiev.prog.CopyDirectory.copyDirectory;
import static kiev.prog.MultiThreadCopyDirectory.copyThreadDirectory;

public class Main {

    public static void main(String[] args) {
        String pathFrom, pathTo;
        pathFrom = "c:/myFolder";
        pathTo = "c:/myFoldertest";

        long timeStart, timeEnd;
        /* simple copying of directory */
        timeStart = System.currentTimeMillis();
        try {
            copyDirectory(pathFrom, pathTo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("Simple copying of Directory. Time: " + (timeEnd - timeStart) + " ms");

        /* Thread copying of Directory */
        int numberThread = 3;
        timeStart = System.currentTimeMillis();
        try {
            copyThreadDirectory(pathFrom, pathTo, numberThread);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("MultiThread copying of Directory. Time: " + (timeEnd - timeStart) + " ms");
    }
}
