package kiev.prog;

import java.io.File;
import java.io.IOException;

public class SingleThreadCopyDirectory implements Runnable {
    private File[] fileFrom;
    private String pathFrom;
    private String pathTo;
    private File[] fileResult;
    private int begin;
    private int end;
    private Thread thread;

    public SingleThreadCopyDirectory(File[] fileFrom, String pathFrom, String pathTo, File[] fileResult, int begin, int end) {
        this.fileFrom = fileFrom;
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        this.fileResult = fileResult;
        this.begin = begin;
        this.end = end;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            String pathReplace = fileFrom[i].getPath();
            pathReplace = pathReplace.replace(pathFrom, pathTo);
            fileResult[i] = new File(pathReplace);
            try {
                CopyDirectory.fileCopy(fileFrom[i], fileResult[i]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
