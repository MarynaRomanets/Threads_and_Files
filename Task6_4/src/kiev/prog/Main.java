package kiev.prog;

import java.io.IOException;

import static kiev.prog.CopyDirectory.copyDirectory;

public class Main {

    public static void main(String[] args) {
        String pathFrom, pathTo;
        pathFrom = "c:/myFolder";
        pathTo = "c:/myFoldertest";
        try {
            copyDirectory(pathFrom, pathTo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
