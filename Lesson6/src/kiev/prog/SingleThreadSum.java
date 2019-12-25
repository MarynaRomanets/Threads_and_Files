package kiev.prog;

public class SingleThreadSum implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private Thread thread;
    private int sum;

    public SingleThreadSum(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
        thread = new Thread(this);
        thread.start();
    }

    public int getSum() {
        return sum;
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            sum += array[i];
        }
    }

}
