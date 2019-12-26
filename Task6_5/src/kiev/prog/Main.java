package kiev.prog;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    String path = "c:/myFolder";
        File directory = new File(path);
        path = directory.getAbsolutePath();
        try {
            if (!directory.isDirectory()) {
                throw new IOException("Directory doesn't exist: " + path);
            } else {
                view(directory.listFiles());
                Thread threadCheckingDir = new Thread( new NewThreadCheckingDir(directory));
                threadCheckingDir.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void view(File[] files) {
        System.out.println(files.length + " files:");
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
