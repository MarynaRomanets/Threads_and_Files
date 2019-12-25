package kiev.prog;

public class MultiThreadSum {
    static int sum(int[] array, int threadNumber) {
        SingleThreadSum[] threadArray = new SingleThreadSum[threadNumber];
        for (int i = 0; i < threadArray.length; i++) {
            int size = array.length / threadNumber;
            int begin = size * i;
            int end = (size * (i + 1));
            if ((array.length - end) < size) {
                end = array.length;
            }
            threadArray[i] = new SingleThreadSum(array, begin, end);
        }
        int sum = 0;
        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].getThread().join();
                sum = sum + threadArray[i].getSum();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return sum;
    }

}
