package kiev.prog;

import java.io.*;

public class CopyDirectory {

    public static void copyDirectory(String pathFrom, String pathTo) throws IOException {
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
                for (int i = 0; i < fileFrom.length; i++) {
                    pathReplace = fileFrom[i].getPath();
                    pathReplace = pathReplace.replace(pathFrom, pathTo);
                    fileResult[i] = new File(pathReplace);
                    fileCopy(fileFrom[i], fileResult[i]);
                }
        } else {
            throw new IOException("Source directory doesn't exist: " + pathFrom);
        }
    }

    public static void streamCopy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[10_000_000];
        int number = 0;
        for (; (number = is.read(buffer)) > 0; ) {
            os.write(buffer, 0, number);
        }
    }

    public static void fileCopy(File in, File out) throws IOException {
        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {
            streamCopy(is, os);
        } catch (IOException e) {
            throw e;
        }
    }
}
