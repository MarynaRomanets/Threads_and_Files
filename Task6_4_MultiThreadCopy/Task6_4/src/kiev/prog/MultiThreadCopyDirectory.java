package kiev.prog;

import java.io.File;
import java.io.IOException;

import static kiev.prog.CopyDirectory.fileCopy;

public class MultiThreadCopyDirectory {

    public static void copyThreadDirectory(String pathFrom, String pathTo, int numberThread) throws IOException {
        File dirFrom = new File(pathFrom);
        pathFrom = dirFrom.getAbsolutePath();
        File dirTo = new File(pathTo);
        pathTo = dirTo.getAbsolutePath();
        String pathReplace;
        if (dirFrom.isDirectory()) {
            if (!dirTo.isDirectory()) {
                dirTo.mkdir();
                System.out.println("Directory is created: " + pathTo);
            }
            File[] fileFrom = dirFrom.listFiles();
            File[] fileResult = new File[fileFrom.length];
            SingleThreadCopyDirectory[] threaDir = new SingleThreadCopyDirectory[numberThread];
            for (int i = 0; i < threaDir.length; i++) {
                int size = fileFrom.length / numberThread;
                int begin = size * i;
                int end = (size * (i + 1));
                if ((fileFrom.length - end) < size) {
                    end = fileFrom.length;
                }
                threaDir[i] = new SingleThreadCopyDirectory(fileFrom, pathFrom, pathTo, fileResult, begin, end);
            }
            for (int j = 0; j < threaDir.length; j++) {
                try {
                    threaDir[j].getThread().join();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        } else {
            throw new IOException("Source directory doesn't exist: " + pathFrom);
        }
    }
}
