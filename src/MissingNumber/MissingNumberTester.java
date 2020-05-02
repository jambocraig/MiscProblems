package MissingNumber;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Craig
 */
public class MissingNumberTester {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter("LinearData.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        FileWriter fw2 = new FileWriter("BinearData.txt");
        BufferedWriter bw2 = new BufferedWriter(fw2);

        for (int z = 0; z < 30; z++) {
            double start, stop, duration, average;
            double runLin = 0;
            double runBin = 0;
            final int SIZE = (int) Math.pow(2, z);
            int[] intArr = new int[SIZE];
            Random rn = new Random();

            final int TESTS = 1000;

            for (int j = 0; j < TESTS; j++) {
                int gap;
                gap = rn.nextInt(SIZE + 1);

                for (int i = 0; i < SIZE; i++) {
                    if (i < gap) {
                        intArr[i] = i;
                    } else {
                        intArr[i] = i + 1;
                    }
                }

                //System.out.println(Arrays.toString(intArr));
                //find missing number
                int num;
                start = System.nanoTime();
                num = linear(intArr);
                stop = System.nanoTime();
                duration = stop - start;
                //System.out.println("duration = " + duration + " nS");
                runLin += duration;
                //System.out.println(num);

                start = System.nanoTime();
                num = binary(intArr);
                stop = System.nanoTime();
                duration = stop - start;
                //System.out.println("duration = " + duration + " nS");
                runBin += duration;
                //System.out.println(num);
            }
            //System.out.println("For array size = " + SIZE);
            average = runLin / 1000.0;
            //System.out.println("Linear average = " + average);
            bw.write(average + "\n");

            average = runBin / 1000.0;
            //System.out.println("Binary average = " + average);
            bw2.write(average + "\n");
        }
        bw.close();
        bw2.close();
    }

    private static int linear(int[] intArr) {
        int length = intArr.length;
        for (int num = 0; num < length; num++) {
            if (num != intArr[num]) {
                return num;
            }
        }
        return length;
    }

    private static int binary(int[] intArr) {
        int length = intArr.length;
        int low = 0, high = length - 1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (mid == intArr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (mid == intArr[mid]) {
            return mid + 1;
        }
        return mid;
    }
}
