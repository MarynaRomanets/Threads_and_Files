package kiev.prog;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[300000];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        int[] arrayClone = array.clone();
        long timeStart, timeEnd;
        int sum = 0;

        timeStart = System.currentTimeMillis();
        sum = sumArray(array);
        timeEnd = System.currentTimeMillis();
        System.out.println("Static method sumArray() = " + sum + " Time: " + (timeEnd - timeStart) + " ms");

        timeStart = System.currentTimeMillis();
        sum = MultiThreadSum.sum(arrayClone, 3);
        timeEnd = System.currentTimeMillis();
        System.out.println("Multi Thread sum =  " + sum + " Time: " + (timeEnd - timeStart) + " ms");
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
